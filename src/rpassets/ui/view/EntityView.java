package rpassets.ui.view;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import rpassets.core.model.AssetEntity;
import rpassets.core.model.ListModel;

public abstract class EntityView<E extends AssetEntity> {
    protected static final JsonPathsConfig config = JsonPathsConfig.INSTANCE;
    private ListModel<E> listModel;
    private ListView<E> listView;
    protected EntityPane<E> entityPane;

    private BorderPane root;
    private Pane listBox;
    private Pane topBar;

    protected EntityView(String filepath) {
        initializeListBox(filepath);
        initializeEntityPane();

        SplitPane center = new SplitPane(this.listBox, this.entityPane.getPane());
        center.setDividerPositions(0.25);

        initializeTopBar();

        this.root = new BorderPane();
        this.root.setPrefSize(900, 600);
        this.root.setLeft(this.listBox);
        this.root.setCenter(center);
        this.root.setTop(this.topBar);
    }

    private void initializeListBox(final String filepath) {
        this.listModel = new ListModel<>(derivedClass(), filepath);
        this.listView = new ListView<>();
        this.listView.setItems(FXCollections.observableArrayList(listModel.getItems()));
        this.listView.setCellFactory(param -> new DefaultEntityListCell<>());

        this.listBox = new VBox(this.listView, new Label(filepath));
        this.listView.prefHeightProperty().bind(this.listBox.heightProperty());
        this.listView.getSelectionModel().selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) -> entityPane.setItem(newValue)
                );
    }

    private void initializeTopBar() {
        Button addEntityButton = new Button("add");
        addEntityButton.setOnAction(event -> {
            E entity = createEntity();
            listModel.getItems().add(entity);
            listView.getItems().add(entity);
        });

        Button removeEntityButton = new Button("delete");
        removeEntityButton.setOnAction(event -> {
            E entity = listView.getSelectionModel().getSelectedItem();
            if (entity != null) {
                listModel.getItems().remove(entity);
                listView.getItems().remove(entity);
            }
        });

        Button saveFileButton = new Button("save file");
        saveFileButton.setOnAction(event -> listModel.saveFile());

        this.topBar = new HBox(
                addEntityButton,
                removeEntityButton,
                saveFileButton
        );
    }

    protected abstract void initializeEntityPane();
    protected abstract Class<E> derivedClass();
    protected abstract E createEntity();

    public Pane getRoot() {
        return this.root;
    }
}
