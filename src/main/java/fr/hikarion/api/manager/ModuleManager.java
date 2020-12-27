package fr.hikarion.api.manager;

import fr.hikarion.api.models.Module;

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
        this.modules.put(module.getName(), module);
    }

    public void delModule(Module module) {
        this.modules.remove(module.getName());
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
