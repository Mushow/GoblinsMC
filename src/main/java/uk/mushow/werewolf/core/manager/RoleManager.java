package uk.mushow.werewolf.core.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import uk.mushow.werewolf.core.data.Role;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoleManager {

    private final List<Role> availableRoles;
    private final Map<UUID, Role> playerRoles;

    private UUID gameMasterUUID;

    public RoleManager() {
        this.availableRoles = new ArrayList<>();
        this.playerRoles = new HashMap<>();
        assignRoles();
    }

    public void assignRoles() {
        List<UUID> playerUUIDs = Bukkit.getOnlinePlayers().stream()
                .map(Player::getUniqueId)
                .collect(Collectors.toList());

        Collections.shuffle(availableRoles);
        Collections.shuffle(playerUUIDs);

        IntStream.range(0, playerUUIDs.size()).forEach(i -> playerRoles.put(playerUUIDs.get(i), availableRoles.get(i)));
    }

    public Role getRole(UUID playerUUID) {
        return playerRoles.get(playerUUID);
    }

    public void setGameMaster(UUID gameMasterUUID) {
        this.gameMasterUUID = gameMasterUUID;
    }

    public void setRoles(List<Role> roles) {
        availableRoles.clear();
        availableRoles.addAll(roles);
    }
}
