package fr.hikarion.api.manager;

import fr.hikarion.api.models.Module;
import org.bukkit.Bukkit;

import java.util.*;

public class ModuleManager {

    private Map<String, Module> modules;
    private List<String> activated;
    private List<String> unactivated;

    public ModuleManager() {
        this.modules = new HashMap<>();
        this.activated = new ArrayList<>();
        this.unactivated = new ArrayList<>();
    }

    public Module getModule(String name) {
        return this.modules.get(name);
    }

    public void addModule(Module module) {
        if (!this.modules.containsKey(module.getName())
                && !this.modules.containsValue(module)) {

            this.modules.put(module.getName(), module);

            Bukkit.getConsoleSender().sendMessage("§f" + module.getName() + " §aajouté a la liste des modules.");

        } else {
            Bukkit.getConsoleSender().sendMessage("§cImpossible d'ajouter le module: §f" + module.getName());
            Bukkit.getConsoleSender().sendMessage("§cInfo: Already exist");
        }
    }

    public void delModule(Module module) {
        if (this.modules.containsKey(module.getName())
                && this.modules.containsValue(module)) {

            this.modules.remove(module.getName());

            Bukkit.getConsoleSender().sendMessage("§f" + module.getName() + " §aretiré de la liste des modules.");

        } else {
            Bukkit.getConsoleSender().sendMessage("§cImpossible de retirer le module: §f" + module.getName());
            Bukkit.getConsoleSender().sendMessage("§cInfo: Doesn't exist");
        }
    }

    public List<String> getModuleNameList() {
        Set<String> keySet = modules.keySet();
        return new ArrayList<String>(keySet);
    }

    public List<Module> getModuleList() {
        Collection<Module> values = modules.values();
        return new ArrayList<Module>(values);
    }

    public List<String> getActivatedList() {
        return this.activated;
    }

    public List<String> getUnactivatedList() {
        return this.unactivated;
    }
}
