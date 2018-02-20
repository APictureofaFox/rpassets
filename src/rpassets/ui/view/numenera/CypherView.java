package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Cypher;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class CypherView extends EntityView<Cypher> {
    public CypherView(String filepath) {
        super(filepath);
    }

    public CypherView() {
        super(config.get(JsonPathsConfig.Key.NUMENERA_CYPHER, "data/numenera/cyphers.json"));
    }

    @Override
    protected Class<Cypher> derivedClass() {
        return Cypher.class;
    }
}
