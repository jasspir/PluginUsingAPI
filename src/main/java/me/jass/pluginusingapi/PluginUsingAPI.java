package me.jass.pluginusingapi;

import me.jass.api.API;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PluginUsingAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.WARNING, "grabbing api...");
        API api = getServer().getServicesManager().load(API.class);

        if (api == null) {
            getLogger().log(Level.WARNING, "failed to grab api");
        } else {
            getLogger().log(Level.WARNING, api.getName());
        }
    }

    @Override
    public void onDisable() {
    }
}
