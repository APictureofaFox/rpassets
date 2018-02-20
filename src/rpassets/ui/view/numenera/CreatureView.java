package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Creature;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class CreatureView extends EntityView<Creature> {
    public CreatureView(String filepath) {
        super(filepath);
    }

    public CreatureView() {
        super(config.get(JsonPathsConfig.Key.NUMENERA_CREATURE, "data/numenera/creatures.json"));
    }

    @Override
    protected Class<Creature> derivedClass() {
        return Creature.class;
    }
}
