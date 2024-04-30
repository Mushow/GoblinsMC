package uk.mushow.goblinsmc.core.manager;

import org.bukkit.Bukkit;

public class GameCycleManager {

    private boolean isNight;

    public GameCycleManager() {
        isNight = true;
    }

    public void startNight() {
        isNight = true;
    }

    public void endNight() {
        isNight = false;
    }

    public boolean isNight() {
        return isNight;
    }

    public void toggleDayNight() {
        Bukkit.broadcastMessage(isNight ? "Night falls. Everyone goes to sleep." : "Day breaks. Everyone wake up.");
        if (isNight) {
            startNight();
        } else {
            endNight();
        }
    }

}
