package com.rngservers.floodgateplaceholder.commands;

import com.rngservers.floodgateplaceholder.FloodgatePlaceholder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FloodgatePlaceholderCommand implements CommandExecutor {
    private FloodgatePlaceholder plugin;

    public FloodgatePlaceholderCommand(FloodgatePlaceholder plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String version = "1.0";
        String author = "RandomUnknown";

        if (args.length < 1) {
            sender.sendMessage(ChatColor.DARK_GRAY + "» " + ChatColor.DARK_PURPLE + "FGP " + ChatColor.GRAY
                    + ChatColor.GRAY + "v" + version);
            if (sender.hasPermission("floodgateplaceholder.reload")) {
                sender.sendMessage(ChatColor.GRAY + "/fgp reload " + ChatColor.DARK_GRAY + "-" + ChatColor.RESET
                        + " Reload plugin");
            }
            sender.sendMessage(ChatColor.DARK_GRAY + "Author: " + ChatColor.GRAY + author);
            return true;
        }
        if (args.length == 1) {
            if (args[0].toLowerCase().equals("reload")) {
                if (sender.hasPermission("floodgateplaceholder.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "FGP"
                            + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " Config reloaded!");
                } else {
                    sender.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + "FGP"
                            + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " No Permission!");
                }
            }
        }
        return true;
    }
}
