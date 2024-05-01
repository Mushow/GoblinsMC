package uk.mushow.goblinsmc.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GoblinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(formatMessage(event.getPlayer().getName(), Bukkit.getOnlinePlayers().size(), "joined"));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(formatMessage(event.getPlayer().getName(), Bukkit.getOnlinePlayers().size() - 1, "left"));
    }

    private String formatMessage(String playerName, int onlineCount, String action) {
        return ChatColor.GRAY + "(" + ChatColor.YELLOW + onlineCount + ChatColor.GRAY + "/" + ChatColor.YELLOW + Bukkit.getMaxPlayers() + ChatColor.GRAY + ") " + ChatColor.YELLOW + playerName + ChatColor.GRAY + " " + action + " the game.";
    }

}