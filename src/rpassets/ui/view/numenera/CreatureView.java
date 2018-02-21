package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Creature;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class CreatureView extends EntityView<Creature> {
    public CreatureView(String filepath) {
        super(filepath);
    }

    public CreatureView() {
        this(config.get(JsonPathsConfig.Key.NUMENERA_CREATURE, "data/numenera/creatures.json"));
    }

    @Override
    protected void initializeEntityPane() {
        this.entityPane = new CreaturePane();
    }

    @Override
    protected Class<Creature> derivedClass() {
        return Creature.class;
    }

    @Override
    protected Creature createEntity() {
        return new Creature();
    }
}
