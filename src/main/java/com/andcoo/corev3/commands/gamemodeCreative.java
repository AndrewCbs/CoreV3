package com.andcoo.corev3.commands;

import com.andcoo.corev3.methods.gm;
import com.andcoo.corev3.corev3;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodeCreative implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("Core.gamemode.creative")) {
            gm.gamemodeMethod(GameMode.CREATIVE, p, args); // Casts to the class and uses the method.

            return true;
        }else{
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("noPermission")));
        }
        return true;

    }
}


