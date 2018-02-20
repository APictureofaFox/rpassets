package rpassets.ui.view;

import javafx.scene.control.ListCell;
import rpassets.core.model.AssetEntity;

public class DefaultEntityListCell<E extends AssetEntity> extends ListCell<E> {
    @Override
    protected void updateItem(E item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item.getNameRu());
        }
    }
}
