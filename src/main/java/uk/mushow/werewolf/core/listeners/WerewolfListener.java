package uk.mushow.werewolf.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import uk.mushow.werewolf.core.cycle.GameStart;
import uk.mushow.werewolf.core.data.GameState;
import uk.mushow.werewolf.core.manager.GameCycleManager;

public class WerewolfListener implements Listener {

    private final int MAX_PLAYERS = 10;
    private final GameCycleManager gameCycleManager;
    private final JavaPlugin plugin;

    public WerewolfListener(GameCycleManager gameCycleManager, JavaPlugin plugin) {
        this.gameCycleManager = gameCycleManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(formatMessage(event.getPlayer().getName(), Bukkit.getOnlinePlayers().size(), "joined"));

        if(Bukkit.getOnlinePlayers().size() == 1) setGameMaster(event.getPlayer());
        checkGameStart();
    }

    private void setGameMaster(Player player) {
        gameCycleManager.getRoleManager().setGameMaster(player.getUniqueId());
        player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GRAY + "You're now the Game Master. Please choose the roles");
        giveGameMasterKit(player);
    }

    private void giveGameMasterKit(Player player) {
        player.getItemInHand().setType(Material.DRAGON_EGG);
    }

    private void checkGameStart() {
        if(gameCycleManager.isState(GameState.WAITING) && Bukkit.getOnlinePlayers().size() == MAX_PLAYERS) {
            GameStart autoStartTask = new GameStart(gameCycleManager, plugin);
            autoStartTask.runTaskTimer(plugin, 0, 20);
            gameCycleManager.setState(GameState.STARTING);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(formatMessage(event.getPlayer().getName(), Bukkit.getOnlinePlayers().size() - 1, "left"));
    }

    private String formatMessage(String playerName, int onlineCount, String action) {
        return ChatColor.GRAY + "(" + ChatColor.YELLOW + onlineCount + ChatColor.GRAY + "/" + ChatColor.YELLOW + Bukkit.getMaxPlayers() + ChatColor.GRAY + ") " + ChatColor.YELLOW + playerName + ChatColor.GRAY + " " + action + " the game.";
    }

}