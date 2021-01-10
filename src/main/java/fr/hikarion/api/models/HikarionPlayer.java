package fr.hikarion.api.models;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HikarionPlayer {

    private UUID uuid;
    private String name;

    private Map<String, Job> jobs;

    public HikarionPlayer(Player player) {

        this.uuid = player.getUniqueId();
        this.name = player.getName();
        this.jobs = new HashMap<>();

    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Job> getJobs() {
        return jobs;
    }

    public void addData(Job job) {
        if (!jobs.containsKey(job.getName())
                && !jobs.containsValue(job)) {
            jobs.put(job.getName(), job);
        }
    }

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }
}
