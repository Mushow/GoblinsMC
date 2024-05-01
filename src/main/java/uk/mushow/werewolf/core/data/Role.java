package uk.mushow.werewolf.core.data;

import org.bukkit.ChatColor;

public enum Role {

    VILLAGER(ChatColor.GRAY, " Villager "),
    WEREWOLF(ChatColor.RED, " Werewolf "),
    SEER(ChatColor.BLUE, " Seer "),
    WITCH(ChatColor.DARK_PURPLE, " Witch "),
    HUNTER(ChatColor.DARK_GREEN, " Hunter "),
    CUPID(ChatColor.LIGHT_PURPLE, " Cupid "),
    THIEF(ChatColor.DARK_AQUA, " Thief "),
    GUARD(ChatColor.DARK_GRAY, " Guard "),
    LITTLE_GIRL(ChatColor.AQUA, " Little Girl "),
    RAT(ChatColor.GOLD, " Rat ");

    Role(ChatColor chatColor, String roleName) {
        this.chatColor = chatColor;
        this.roleName = roleName;
    }

    private final ChatColor chatColor;
    private final String roleName;

    private ChatColor getChatColor() {
        return chatColor;
    }

    private String getRoleName() {
        return roleName;
    }

    public String getRoleNameWithColor() {
        return chatColor + roleName;
    }

}
