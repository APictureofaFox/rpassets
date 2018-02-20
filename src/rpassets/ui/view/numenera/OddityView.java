package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Oddity;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class OddityView extends EntityView<Oddity> {
    public OddityView(String filepath) {
        super(filepath);
    }

    public OddityView() {
        super(config.get(JsonPathsConfig.Key.NUMENERA_ODDITY, "data/numenera/oddities.json"));
    }

    @Override
    protected Class<Oddity> derivedClass() {
        return Oddity.class;
    }
}
