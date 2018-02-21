package rpassets.ui.view.numenera;

import rpassets.core.model.numenera.Artifact;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.JsonPathsConfig;

public class ArtifactView extends EntityView<Artifact> {
    public ArtifactView(String filepath) {
        super(filepath);
    }

    public ArtifactView() {
        this(config.get(JsonPathsConfig.Key.NUMENERA_ARTIFACT, "data/numenera/artifact.json"));
    }

    @Override
    protected void initializeEntityPane() {
        this.entityPane = new ArtifactPane();
    }

    @Override
    protected Class<Artifact> derivedClass() {
        return Artifact.class;
    }

    @Override
    protected Artifact createEntity() {
        return new Artifact();
    }
}
