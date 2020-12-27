package fr.hikarion.api.listeners;

import fr.hikarion.api.API;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        API.getInstance().getPlayerManager().saveProfile(event.getPlayer());
        API.getInstance().getScoreboardManager().unloadScoreboard(event.getPlayer());
    }

}
