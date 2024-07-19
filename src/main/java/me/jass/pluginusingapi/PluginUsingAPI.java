package me.jass.pluginusingapi;

import me.jass.api.API;
import me.jass.api.SneakEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PluginUsingAPI extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().log(Level.WARNING, "grabbing api...");
        API api = getServer().getServicesManager().load(API.class);

        if (api == null) {
            getLogger().log(Level.WARNING, "failed to grab api");
        } else {
            Bukkit.broadcastMessage(api.getName());
            getLogger().log(Level.WARNING, api.getName());
        }

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void sneakEvent(SneakEvent event) {
        Bukkit.broadcastMessage("Sneaking: " + event.isSneaking());
    }

    @Override
    public void onDisable() {
    }
}
