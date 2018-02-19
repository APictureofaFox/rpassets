package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;

import java.util.List;

class Modification {
    String skill;
    int asLevel;
}

public class Creature implements AssetEntity {
    private String nameEn;
    private String nameRu;
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
}
