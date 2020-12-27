package fr.hikarion.api.models;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class HikarionPlayer {

    private UUID uuid;
    private String name;

    private Map<String, Object> data;

    public HikarionPlayer(Player player) {

        this.uuid = player.getUniqueId();
        this.name = player.getName();

    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }
}
