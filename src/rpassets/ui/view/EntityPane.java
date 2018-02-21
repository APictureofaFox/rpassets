package rpassets.ui.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import rpassets.core.model.AssetEntity;

public abstract class EntityPane<E extends AssetEntity> {
    protected E item;
    private VBox root;

    private Button editButton;
    private Button cancelButton;
    private Button applyButton;

    protected EntityPane() {
        this.editButton = new Button("edit");
        this.editButton.setOnAction(event -> setEditable(true));

        this.cancelButton = new Button("cancel");
        this.cancelButton.setOnAction(event -> {
            setEditable(false);
            refreshContent();
        });

        this.applyButton = new Button("apply");
        this.applyButton.setOnAction(event -> {
            setEditable(false);
            applyChanges();
        });

        setButtonsEditable(false);
        Pane separator = new Pane();
        HBox.setHgrow(separator, Priority.ALWAYS);

        HBox bottom = new HBox(
                this.editButton,
                separator,
                this.cancelButton,
                this.applyButton
        );

        Pane content = initializeContent();
        VBox.setVgrow(content, Priority.ALWAYS);

        this.root = new VBox(
                content,
                bottom
        );

        setEditable(false);
        this.editButton.setDisable(true);
    }

    protected abstract Pane initializeContent();
    protected abstract void clearContent();
    private void refreshContent() {
        setEditable(false);
        if (item != null) redrawContent();
        else clearContent();
    }
    protected abstract void redrawContent();
    public void setItem(E item) {
        this.item = item;
        refreshContent();
    }

    private void setEditable(boolean editable) {
        setContentEditable(editable);
        setButtonsEditable(editable);
    }
    private void setButtonsEditable(boolean editable) {
        this.editButton.setDisable(editable);
        this.cancelButton.setDisable(!editable);
        this.applyButton.setDisable(!editable);
    }
    protected abstract void setContentEditable(boolean editable);
    protected abstract void applyChanges();
    public Pane getPane() { return this.root; }
}
