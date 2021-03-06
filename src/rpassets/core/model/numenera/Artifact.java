package rpassets.core.model.numenera;

import rpassets.core.model.AssetEntity;
import rpassets.core.roll.Roll;

public class Artifact extends AssetEntity {
    private Roll level;
    private String useForm;
    private String effect;
    private Roll depletionRoll;
    private int depletionFailure;
    private String source;

    public Artifact() {
        super("new artifact", "новый артефакт");
        this.level = new Roll("1d6");
        this.useForm = "";
        this.effect = "";
        this.depletionRoll = new Roll("1d20");
        this.depletionFailure = 1;
        this.source = "";
    }

    public Roll getLevel() {
        return level;
    }

    public void setLevel(Roll level) {
        this.level = level;
    }

    public String getUseForm() {
        return useForm;
    }

    public void setUseForm(String useForm) {
        this.useForm = useForm;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Roll getDepletionRoll() {
        return depletionRoll;
    }

    public void setDepletionRoll(Roll depletion) {
        this.depletionRoll = depletion;
    }

    public int getDepletionFailure() {
        return depletionFailure;
    }

    public void setDepletionFailure(int depletionFailure) {
        this.depletionFailure = depletionFailure;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
