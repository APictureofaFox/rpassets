package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;

public class Oddity implements AssetEntity {
    private String description;

    public Oddity(String description) {
        this.description = description;
    }

    public Oddity() {
        this("");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
