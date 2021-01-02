package fr.hikarion.api.manager;

import fr.hikarion.api.utils.ScoreboardSign;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardManager {

    private final Map<UUID, ScoreboardSign> playersScoreboards;

    public ScoreboardManager() {
        this.playersScoreboards = new HashMap<>();
    }

    public void createScoreboard(Player player, String display) {
        ScoreboardSign scoreboard = new ScoreboardSign(player, display);
        scoreboard.create();
        this.playersScoreboards.put(player.getUniqueId(), scoreboard);
    }

    public void unloadScoreboard(Player player) {
        this.playersScoreboards.remove(player.getUniqueId());
    }

    public ScoreboardSign getScoreboard(Player player) {
        return this.playersScoreboards.get(player.getUniqueId());
    }

}
