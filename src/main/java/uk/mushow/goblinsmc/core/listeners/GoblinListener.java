package uk.mushow.goblinsmc.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GoblinListener implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {}

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event) {}

}
