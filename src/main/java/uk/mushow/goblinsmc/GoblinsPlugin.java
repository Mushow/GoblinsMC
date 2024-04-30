package uk.mushow.goblinsmc;

import org.bukkit.plugin.java.JavaPlugin;
import uk.mushow.goblinsmc.core.listeners.GoblinListener;

public class GoblinsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Goblins plugin enabled");
        registerEvents();
    }

    @Override
    public void onDisable() {
        getLogger().info("Goblins plugin disabled");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new GoblinListener(), this);
    }

}
