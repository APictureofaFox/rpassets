package rpassets.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rpassets.core.model.numenera.Cypher;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.numenera.CypherView;

public class Main extends Application {

    EntityView<Cypher> entityView = new CypherView();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(entityView.getRoot()));

        primaryStage.setTitle("RPAssets");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
