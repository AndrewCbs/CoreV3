package com.andcoo.corev3.commands;

import com.andcoo.corev3.corev3;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode implements CommandExecutor {

    // gamemode_0-message

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

                if (args.length == 1 && p.hasPermission("core.gamemode")) {
                    switch (args[0]) {
                        case "0":
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemode_0-message")));
                            break;

                        case "1":
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemode_1-message")));
                            break;

                        case "2":
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemode_2-message")));
                            break;

                        case "3":
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemode_3-message")));
                            break;

                        default:
                            p.sendMessage("§c/gm");
                            break;
                    }
                } else if (args.length >= 2) {
                    p.sendMessage("§cWrong usage of args.");

                } else if (!p.hasPermission("core.gamemode")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("noPermission")));
                }else if (args.length == 0) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemode-wrong_usage")));
                }
            }
            return true;
        }

    }
