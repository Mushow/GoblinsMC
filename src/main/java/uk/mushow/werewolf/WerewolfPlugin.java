package uk.mushow.werewolf;

import org.bukkit.plugin.java.JavaPlugin;
import uk.mushow.werewolf.core.listeners.WerewolfListener;
import uk.mushow.werewolf.core.manager.GameCycleManager;

public class WerewolfPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Werewolf plugin enabled");
        GameCycleManager gameCycleManager = new GameCycleManager();
        registerEvents(gameCycleManager);
    }

    @Override
    public void onDisable() {
        getLogger().info("Werewolf plugin disabled");
    }

    private void registerEvents(GameCycleManager gameCycleManager) {
        getServer().getPluginManager().registerEvents(new WerewolfListener(gameCycleManager, this), this);
    }

}
