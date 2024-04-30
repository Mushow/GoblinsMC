package uk.mushow.globlinsmc;

import org.bukkit.plugin.java.JavaPlugin;

public class GoblinsCorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Goblins plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Goblins plugin disabled");
    }



}
