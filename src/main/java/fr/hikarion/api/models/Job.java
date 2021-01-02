package fr.hikarion.api.models;

public class Job {

    private String name;
    private int level;
    private double xp;
    private double xpMax;

    public Job(String name, int level, double xp, double xpMax) {

        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpMax = xpMax;

    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public double getXpMax() {
        return xpMax;
    }

    public void setXpMax(double xpMax) {
        this.xpMax = xpMax;
    }
}
