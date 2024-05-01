package uk.mushow.werewolf.core.manager;

import org.bukkit.Bukkit;
import uk.mushow.werewolf.core.data.GameState;

public class GameCycleManager {
    private GameState gameState;
    private RoleManager roleManager;

    public GameCycleManager() {
        gameState = GameState.WAITING;
        roleManager = new RoleManager();
    }

    public void startNight() {
        gameState = GameState.NIGHT;
    }

    public void endNight() {
        gameState = GameState.VOTE;
    }

    public boolean isNight() {
        return gameState == GameState.NIGHT;
    }

    public void toggleDayNight() {
        Bukkit.broadcastMessage(isNight() ? "Night falls. Everyone goes to sleep." : "Day breaks. Everyone wake up.");
        if (!isNight()) {
            startNight();
        } else {
            endNight();
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean isState(GameState state) {
        return gameState == state;
    }

    public void setState(GameState gameState) {
        this.gameState = gameState;
    }

    public RoleManager getRoleManager() {
        return roleManager;
    }

}
