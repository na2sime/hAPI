package fr.hikarion.api.manager;

import fr.hikarion.api.API;
import fr.hikarion.api.models.HikarionPlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final Map<UUID, HikarionPlayer> hikarionPlayers;
    private API main;

    public PlayerManager() {
        this.hikarionPlayers = new HashMap<>();
        this.main = API.getInstance();
    }

    public void loadProfile(Player player) {
        String json = main.getFileUtils().loadFile(new File(main.getDataFolder() + "/players", player.getName() + ".json"));
        HikarionPlayer profile = (HikarionPlayer) (main).getSerialize().deserialize(json, HikarionPlayer.class);
        if (profile == null) {
            profile = new HikarionPlayer(player);
        }
        this.hikarionPlayers.put(player.getUniqueId(), profile);
    }

    public void saveProfile(Player player) {
        HikarionPlayer profile = getPlayer(player);
        String json = (main).getSerialize().serialize(profile);
        main.getFileUtils().saveFile(new File(main.getDataFolder() + "/players", player.getName() + ".json"), json);
        this.hikarionPlayers.remove(player.getUniqueId());
    }

    public HikarionPlayer getPlayer(Player player) {
        return this.hikarionPlayers.get(player.getUniqueId());
    }

}
