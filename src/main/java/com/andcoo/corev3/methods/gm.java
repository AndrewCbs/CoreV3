package com.andcoo.corev3.methods;

import com.andcoo.corev3.corev3;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class gm {


    public static boolean gamemodeMethod(GameMode gm, Player p, String[] args) { // Returns the default boolean on the regular onCommand


        if (args.length == 0) {
            p.setGameMode(gm); // Use the method GameMode in spigot api to set the players gamemode to a gamemode specified.
         //   p.sendMessage("§cGamMode set to " + gm.toString()); // gm.toString gets the GameMode's name with Capital Letters.

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("gamemodeEnabled").
                    replaceAll("%gamemode-name%", gm.toString())));


            return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]); //Gets the Player target in the argument args[0] /gmc <args[0]> <- args[0] here
        if (target == null) { // if target is null
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("couldnotfindPlayer").replaceAll("%target%", args[0])));

            return true;
        } else {
            target.setGameMode(gm); // set targets gamemode [...
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', corev3.messageData.get("setGamemodeforPlayer").
                    replaceAll("%target%", target.getName())));


        }
        return true;
    }
}
