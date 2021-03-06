package net.hypercubemc.beacon;

import net.fabricmc.loader.api.Version;
import net.hypercubemc.beacon.api.chat.BeaconChatManager;
import net.hypercubemc.beacon.api.events.BeaconEventManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents an instance of a Beacon plugin
 */
public class BeaconPluginInstance {
    private final String pluginName;
    private final Version pluginVersion;
    private BeaconPluginState pluginState;

    BeaconPluginInstance(String pluginName, Version pluginVersion, BeaconPluginState pluginState) {
        this.pluginName = pluginName;
        this.pluginVersion = pluginVersion;
        this.pluginState = pluginState;
    }
    
    /**
     * Gets the name of the plugin
     * @return The name of the plugin as a String
     */
    public String getPluginName() {
        return pluginName;
    }

    /**
     * Gets the version of the plugin
     * @return The version of the plugin as a Version
     */
    public Version getPluginVersion() {
        return pluginVersion;
    }

    /**
     * Gets the state of the plugin
     * @return The state of the plugin as a BeaconPluginState
     */
    public BeaconPluginState getPluginState() {
        return pluginState;
    }

    void setPluginState(BeaconPluginState pluginState) {
        this.pluginState = pluginState;
    }
    
    /**
     * Gets the direct log4j2 logger for the plugin
     * @return A Logger
     */
    public Logger getRawLogger() {
        return LogManager.getLogger(pluginName);
    }
    
    /**
     * Gets the BeaconPluginLogger for the plugin
     * <br>
     * This is what you should be using to log
     * @return A BeaconPluginLogger
     */
    public BeaconPluginLogger getLogger() {
        return new BeaconPluginLogger(pluginName);
    }

    /**
     * Gets an instance of BeaconChatManager
     * <br>
     * It has useful methods to manage the chat
     * @return BeaconChatManager
     */
    public BeaconChatManager getChatManager() {
        return new BeaconChatManager(this);
    }

    /**
     * Gets an instance of BeaconEventManager
     * <br>
     * This class serves as a manager for the event system.
     * <br>
     * Use {@link net.hypercubemc.beacon.api.events.BeaconEventManager#registerListener BeaconEventManager.registerPlugin(YourBeaconEventListenerClass)} to register your event listener class and your event handlers
     * @return BeaconEventManager
     */
    public BeaconEventManager getEventManager() {
        return new BeaconEventManager(this);
    }
}
