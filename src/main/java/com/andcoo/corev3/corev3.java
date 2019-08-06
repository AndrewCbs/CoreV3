package com.andcoo.corev3;

import com.andcoo.corev3.commands.*;
import com.chefren.corev3.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public final class corev3 extends JavaPlugin {

    public ArrayList<UUID> vanised = new ArrayList<UUID>();
    public static HashMap<String, String> messageData = new HashMap<String, String>(); // Makes a hashmap String.

    private static corev3 instance; // Makes this class accessible for every other class

    public corev3() {
        instance = this;
    } // Sets the instance for this class.


    public static corev3 getInstance() { // Makes a new method to get the instance of this class. (e.g corev3.getInstance.[...]
        return instance;
    }

    @Override
    public void onEnable() {


        instance = this;

        //A method that calls all the constructors.
        registerCommands();

        File f = new File(getDataFolder() + File.separator + "messages.yml"); // Creates a new DataFolder with the name Messages.yml
        if (!f.exists()) { // If the file doesnt exist try to create it
            try {
                f.createNewFile();
            } catch (IOException e) { // Else if it doesnt work to create the file, catch the error with a printStackTrace with the error.
                e.printStackTrace();
            }
        }


        /*/
        Sets the HashMap MessagesData
        /*/

        setMessage("noPermission", "&cAccess Denied.");
        setMessage("gamemodeEnabled", "&cGameMode has been set to %gamemode-name%.");
        setMessage("couldnotfindPlayer", "&cError: Could not find player %target%.");
        setMessage("setGamemodeforPlayer", "&cGameMode has been updated for %target%.");
        setMessage("gamemode_0-message", "&cGameMode has been updated to SURVIVAL.");
        setMessage("gamemode_1-message", "&cGameMode has been updated to CREATIVE.");
        setMessage("gamemode_2-message", "&cGameMode has been updated to ADVENTURE.");
        setMessage("gamemode_3-message", "&cGameMode has been updated to SPECTATOR.");
        setMessage("gamemode-wrong_usage", "&cError: Use /gm <1, 2, 3>");
        setMessage("vanishEnabled", "&cVanish has been enabled.");
        setMessage("vanishDisabled", "&cVanish has been disabled.");


        FileConfiguration config = YamlConfiguration.loadConfiguration(f); // Loads the configuration file f thats put above.
        for (String message : config.getConfigurationSection("").getKeys(false)) { // loops through every message and creates a String message and loops through every config section with a path "" aka null
            messageData.put(message, config.getString(message)); // Puts the messages above in the config.


        }

        getServer().getConsoleSender().sendMessage("Plugin has been Enabled.");

    }



    @Override
    public void onDisable() {
    }



    public void registerCommands()
    {

        getCommand("gm").setExecutor(new gamemode());
        getCommand("gmc").setExecutor(new gamemodeCreative());
        getCommand("gms").setExecutor(new gamemodeSurvival());
        getCommand("gmsp").setExecutor(new gamemodeSpectator());
        getCommand("gma").setExecutor(new gamemodeAdventure());

        getCommand("vanish").setExecutor(new vanish());


    }
    private void setMessage(String name, String message) {
        File f = new File(getDataFolder() + File.separator+"messages.yml"); // Makes an instance of the messages.yml file.
        FileConfiguration config = YamlConfiguration.loadConfiguration(f); // loads the (f) config file.
        if (!config.isSet(name)) { // if the config doesnt have the name set (the name in the hashmap) (Name aka the configuration properties)
            config.set(name, message); // set the name (eg PermissionDenied etc)
            try { // Try to save the config (f)
                config.save(f);
            } catch (IOException e) { // Else if it doesnt work use a catch method to print the stacktrace.
                e.printStackTrace();
            }
        }
    }

    }


