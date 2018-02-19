package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;
import rpassets.core.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public class Cypher implements AssetEntity {
    private String nameEn;
    private String nameRu;
    private Roll level;
    private boolean occultic;
    private List<String> useForms;
    private String effect;
    private String source;

    public Cypher() {
        this.nameEn = "";
        this.nameRu = "";
        this.level = new Roll("1d6");
        this.occultic = false;
        this.useForms = new ArrayList<>();
        this.effect = "";
        this.source = "";
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public Roll getLevel() {
        return level;
    }

    public void setLevel(Roll level) {
        this.level = level;
    }

    public boolean isOccultic() {
        return occultic;
    }

    public void setOccultic(boolean occultic) {
        this.occultic = occultic;
    }

    public List<String> getUseForms() {
        return useForms;
    }

    public void addUseForm(String useForm) {
        this.useForms.add(useForm);
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
