package rpassets.ui.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import rpassets.core.model.AssetEntity;
import rpassets.core.model.ListModel;
import rpassets.ui.Config;

public abstract class EntityView<E extends AssetEntity> {
    private ListModel<E> listModel;
    private ListView<E> listView;
    private ObservableList<E> items;
    protected static final JsonPathsConfig config = JsonPathsConfig.INSTANCE;

    public EntityView(String filepath) {
        this.listModel = new ListModel<>(derivedClass(), filepath);
        this.items = FXCollections.observableArrayList(listModel.items());
        this.listView = new ListView<>();
        this.listView.setItems(this.items);
        this.listView.setCellFactory(this::cellFactory);
    }

    protected ListCell<E> cellFactory(ListView<E> list) {
        return new DefaultEntityListCell<>();
    }

    protected abstract Class<E> derivedClass();

    public ListView<E> getListView() {
        return listView;
    }
}
