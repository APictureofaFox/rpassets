package rpassets.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpassets.core.model.numenera.Cypher;
import rpassets.ui.view.EntityView;
import rpassets.ui.view.numenera.CypherView;

public class Main extends Application {

    EntityView<Cypher> entityView = new CypherView();
    ListView<Cypher> listView = entityView.getListView();

    @Override
    public void start(Stage primaryStage) {
        //Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        VBox root = new VBox();
        primaryStage.setScene(new Scene(root, 300, 275));
        root.getChildren().addAll(listView);

        primaryStage.setTitle("RPAssets");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
