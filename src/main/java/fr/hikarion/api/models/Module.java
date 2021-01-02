package fr.hikarion.api.models;

import fr.hikarion.api.API;

public class Module {

    private final String name;
    private boolean active;

    public Module(String name, boolean active) {
        this.name = name;
        this.active = active;
        if (active) API.getInstance().getModuleManager().getActivatedList().add(this.name);
        if (!active) API.getInstance().getModuleManager().getUnactivatedList().add(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            API.getInstance().getModuleManager().getActivatedList().add(this.name);
            API.getInstance().getModuleManager().getUnactivatedList().remove(this.name);
        } else {
            API.getInstance().getModuleManager().getUnactivatedList().add(this.name);
            API.getInstance().getModuleManager().getActivatedList().remove(this.name);
        }
    }
}
