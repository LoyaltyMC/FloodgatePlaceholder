package com.rngservers.floodgateplaceholder;

import com.rngservers.floodgateplaceholder.commands.FloodgatePlaceholderCommand;
import com.rngservers.floodgateplaceholder.placeholder.Placeholder;
import com.rngservers.floodgateplaceholder.placeholder.PlaceholderManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FloodgatePlaceholder extends JavaPlugin {
    private Placeholder placeholder;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (getServer().getPluginManager().getPlugin("floodgate-bukkit") != null) {
            getCommand("floodgateplaceholder").setExecutor(new FloodgatePlaceholderCommand(this));
            PlaceholderManager placeholderManager = new PlaceholderManager(this);
            placeholder = new Placeholder(this, placeholderManager);
            placeholder.register();
        } else {
            getServer().getLogger().info("floodgate-bukkit not found! Disabling plugin.");
            getServer().getPluginManager().disablePlugin(this);
        }
    }
}
