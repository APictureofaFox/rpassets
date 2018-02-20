package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;
import rpassets.core.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public class Cypher extends AssetEntity {
    private Roll level;
    private boolean occultic;
    private List<String> useForms;
    private String effect;
    private String source;

    public Cypher() {
        super("new cypher", "новый шифр");
        this.level = new Roll("1d6");
        this.occultic = false;
        this.useForms = new ArrayList<>();
        this.effect = "";
        this.source = "";
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
