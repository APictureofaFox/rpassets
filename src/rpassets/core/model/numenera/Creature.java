package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;

import java.util.ArrayList;
import java.util.List;

class Modification {
    String skill;
    int asLevel;
}

public class Creature extends AssetEntity {
    private int level;
    private String description;
    private String motive;
    private String environment;
    private int health;
    private int damage;
    private Distance movement;
    private List<Modification> modifications;
    private String combat;
    private String interaction;
    private String use;
    private String loot;
    private List<String> intrusions;

    public Creature() {
        super("new creature", "новое существо");
        this.level = 1;
        this.description = "";
        this.motive = "";
        this.environment = "";
        this.health = this.level * 3;
        this.damage = this.level;
        this.movement = Distance.shortRange();
        this.modifications = new ArrayList<>();
        this.combat = "";
        this.interaction = "";
        this.use = "";
        this.loot = "";
        this.intrusions = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Distance getMovement() {
        return movement;
    }

    public void setMovement(Distance movement) {
        this.movement = movement;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public List<String> getIntrusions() {
        return intrusions;
    }

    public void setIntrusions(List<String> intrusions) {
        this.intrusions = intrusions;
    }
}
