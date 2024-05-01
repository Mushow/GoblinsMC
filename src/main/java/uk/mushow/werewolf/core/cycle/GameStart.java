package uk.mushow.werewolf.core.cycle;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import uk.mushow.werewolf.core.data.GameState;
import uk.mushow.werewolf.core.manager.GameCycleManager;

public class GameStart extends BukkitRunnable {

    private final GameCycleManager gameCycleManager;
    private final JavaPlugin plugin;
    private int count = 10;

    public GameStart(GameCycleManager gameCycleManager, JavaPlugin plugin) {
        this.gameCycleManager = gameCycleManager;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(count == 0) {
            plugin.getLogger().info("Game starting...");
            gameCycleManager.setState(GameState.NIGHT);
            gameCycleManager.getRoleManager().assignRoles();
            cancel();
        } else {
            plugin.getLogger().info("Game starting in " + count + " seconds");
            count--;
        }
    }

}
