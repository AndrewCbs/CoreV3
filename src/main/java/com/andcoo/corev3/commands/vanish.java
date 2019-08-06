package com.andcoo.corev3.commands;

import com.andcoo.corev3.corev3;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vanish implements CommandExecutor {


    // Default is in vanish = false


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("vanish")) {
            if (!corev3.getInstance().vanised.contains(p.getUniqueId())) {

                for (Player online : Bukkit.getOnlinePlayers())
                    online.hidePlayer(p);

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("vanishEnabled")));
                corev3.getInstance().vanised.add(p.getUniqueId());

                return true;

            } else if (corev3.getInstance().vanised.contains(p.getUniqueId())) {

                for (Player online : Bukkit.getOnlinePlayers())

                    online.showPlayer(p);

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("vanishDisabled")));
                corev3.getInstance().vanised.remove(p.getUniqueId());


            }
            return true;
        }
        return true;
    }
}
