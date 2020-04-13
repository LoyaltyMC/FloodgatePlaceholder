package com.rngservers.floodgateplaceholder.placeholder;

import com.rngservers.floodgateplaceholder.FloodgatePlaceholder;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.FloodgateAPI;
import org.geysermc.floodgate.FloodgatePlayer;

public class PlaceholderManager {
    private FloodgatePlaceholder plugin;

    public PlaceholderManager(FloodgatePlaceholder plugin) {
        this.plugin = plugin;
    }

    public String getPlaceholder(Player player) {
        if (FloodgateAPI.isBedrockPlayer(player.getUniqueId())) {
            FloodgatePlayer floodgatePlayer = FloodgateAPI.getPlayer(player.getUniqueId());
            switch (floodgatePlayer.getDeviceOS()) {
                case ANDROID:
                    return plugin.getConfig().getString("settings.android").replace("&", "§");
                case IOS:
                    return plugin.getConfig().getString("settings.ios").replace("&", "§");
                case OSX:
                    return plugin.getConfig().getString("settings.osx").replace("&", "§");
                case FIREOS:
                    return plugin.getConfig().getString("settings.fireos").replace("&", "§");
                case GEARVR:
                    return plugin.getConfig().getString("settings.gearvr").replace("&", "§");
                case HOLOLENS:
                    return plugin.getConfig().getString("settings.hololens").replace("&", "§");
                case WIN10:
                    return plugin.getConfig().getString("settings.win10").replace("&", "§");
                case WIN32:
                    return plugin.getConfig().getString("settings.win32").replace("&", "§");
                case DEDICATED:
                    return plugin.getConfig().getString("settings.dedicated").replace("&", "§");
                case ORBIS:
                    return plugin.getConfig().getString("settings.orbis").replace("&", "§");
                case NX:
                    return plugin.getConfig().getString("settings.nx").replace("&", "§");
                case SWITCH:
                    return plugin.getConfig().getString("settings.switch").replace("&", "§");
                case XBOX_ONE:
                    return plugin.getConfig().getString("settings.xboxOne").replace("&", "§");
                default:
                    return plugin.getConfig().getString("settings.unknown").replace("&", "§");
            }
        } else {
            return plugin.getConfig().getString("settings.java").replace("&", "§");
        }
    }
}
