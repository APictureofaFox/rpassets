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
        Scene scene = new Scene(entityView.getRoot());
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.setTitle("RPAssets");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
