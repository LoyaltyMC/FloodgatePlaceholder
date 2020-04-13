package com.rngservers.floodgateplaceholder.placeholder;

import com.rngservers.floodgateplaceholder.FloodgatePlaceholder;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class Placeholder extends PlaceholderExpansion {
    private FloodgatePlaceholder plugin;
    private PlaceholderManager placeholderManager;

    public Placeholder(FloodgatePlaceholder plugin, PlaceholderManager placeholderManager) {
        this.plugin = plugin;
        this.placeholderManager = placeholderManager;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier() {
        return "floodgateplaceholder";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier){
        if (player == null) {
            return "";
        }

        if (identifier.equals("status")) {
            return plugin.getConfig().getString("status", "" + placeholderManager.getPlaceholder(player));
        }
        return null;
    }
}