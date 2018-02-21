package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Oddity;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class OddityView extends EntityView<Oddity> {
    public OddityView(String filepath) {
        super(filepath);
    }

    public OddityView() {
        this(config.get(JsonPathsConfig.Key.NUMENERA_ODDITY, "data/numenera/oddities.json"));
    }

    @Override
    protected void initializeEntityPane() {
        this.entityPane = new OddityPane();
    }

    @Override
    protected Class<Oddity> derivedClass() {
        return Oddity.class;
    }

    @Override
    protected Oddity createEntity() {
        return new Oddity();
    }
}
