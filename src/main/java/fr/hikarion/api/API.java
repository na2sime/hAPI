package fr.hikarion.api;

import fr.hikarion.api.commands.ModuleCommands;
import fr.hikarion.api.listeners.PlayerJoin;
import fr.hikarion.api.listeners.PlayerQuit;
import fr.hikarion.api.manager.ModuleManager;
import fr.hikarion.api.manager.PlayerManager;
import fr.hikarion.api.manager.ScoreboardManager;
import fr.hikarion.api.utils.BungeeChannelApi;
import fr.hikarion.api.utils.FileUtils;
import fr.hikarion.api.utils.Serialize;
import fr.hikarion.api.utils.commands.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class API extends JavaPlugin {

    private static API instance;

    private FileUtils fileUtils;
    private Serialize serialize;

    private CommandFramework commandFramework;
    private BungeeChannelApi bungeeChannelApi;

    private PlayerManager playerManager;
    private ScoreboardManager scoreboardManager;
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {

        instance = this;

        this.commandFramework = new CommandFramework(this);
        this.commandFramework.registerHelp();

        this.loadClasses();
        this.loadListeners();

    }

    private void loadClasses() {
        this.fileUtils = new FileUtils();
        this.serialize = new Serialize();
        this.bungeeChannelApi = BungeeChannelApi.of(this);

        this.moduleManager = new ModuleManager();
        this.playerManager = new PlayerManager();
        this.scoreboardManager = new ScoreboardManager();
    }

    private void loadListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoin(), this);
        pluginManager.registerEvents(new PlayerQuit(), this);
    }

    private void loadCommands() {
        commandFramework.registerCommands(new ModuleCommands());
    }

    public FileUtils getFileUtils() {
        return this.fileUtils;
    }

    public Serialize getSerialize() {
        return this.serialize;
    }

    public PlayerManager getPlayerManager() {
        return this.playerManager;
    }

    public BungeeChannelApi getBungeeChannelApi() {
        return bungeeChannelApi;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public static API getInstance() {
        return instance;
    }


}
