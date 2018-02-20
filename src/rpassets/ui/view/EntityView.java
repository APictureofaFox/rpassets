package rpassets.ui.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import rpassets.core.model.AssetEntity;
import rpassets.core.model.ListModel;

public abstract class EntityView<E extends AssetEntity> {
    protected static final JsonPathsConfig config = JsonPathsConfig.INSTANCE;
    private ListModel<E> listModel;
    private ListView<E> listView;
    private ObservableList<E> items;
    private Pane root;
    private Pane listBox;
    private Pane entityWidget;

    public EntityView(String filepath) {
        initializeModel(filepath);

        this.listBox = new VBox(listView);
        this.entityWidget = new Pane();
        this.root = new HBox();

        this.root.getChildren().addAll(listBox, entityWidget);
        this.root.setPrefSize(900, 600);

        this.entityWidget.prefHeightProperty().bind(this.root.heightProperty());
        this.listBox.prefHeightProperty().bind(this.root.heightProperty());
        this.listView.prefHeightProperty().bind(this.listBox.heightProperty());
    }

    private void initializeModel(final String filepath) {
        this.listModel = new ListModel<>(derivedClass(), filepath);
        this.items = FXCollections.observableArrayList(listModel.items());
        this.listView = new ListView<>();
        this.listView.setItems(this.items);
        this.listView.setCellFactory(this::cellFactory);
    }

    private ListCell<E> cellFactory(ListView<E> list) {
        return new DefaultEntityListCell<>();
    }

    protected abstract Class<E> derivedClass();

    public Pane getRoot() {
        return this.root;
    }
}
