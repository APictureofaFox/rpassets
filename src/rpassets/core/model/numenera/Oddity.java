package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;

public class Oddity extends AssetEntity {
    private String description;

    public Oddity(String description) {
        super("new oddity", "новая диковинка");
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
