package rpassets.ui.view.numenera;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import rpassets.core.model.numenera.Cypher;
import rpassets.core.roll.Roll;
import rpassets.ui.view.EntityPane;

public class CypherPane extends EntityPane<Cypher> {
    private TextField nameEnField;
    private TextField nameRuField;
    private TextField levelField;
    private CheckBox occulticCheckBox;
    private Button addUseForm;
    private Button removeUseForm;
    private ListView<String> useFormsListView;
    private TextArea effectArea;
    private TextField sourceField;

    CypherPane() {
        super();
    }

    @Override
    protected Pane initializeContent() {
        VBox root = new VBox();
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(10);

        this.nameEnField = new TextField("");
        HBox nameEnRow = new HBox(new Label("Название (en): "), nameEnField);
        HBox.setHgrow(nameEnField, Priority.ALWAYS);

        this.nameRuField = new TextField("");
        HBox nameRuRow = new HBox(new Label("Название (ru): "), nameRuField);
        HBox.setHgrow(nameRuField, Priority.ALWAYS);

        this.levelField = new TextField("");
        this.occulticCheckBox = new CheckBox();
        Label checkBox = new Label("Оккультный");
        checkBox.setGraphic(this.occulticCheckBox);
        checkBox.setContentDisplay(ContentDisplay.RIGHT);
        HBox levelRow = new HBox(checkBox, new Label(" Уровень: "), levelField);
        HBox.setHgrow(levelField, Priority.ALWAYS);

        this.useFormsListView = new ListView<>();
        this.useFormsListView.setCellFactory(TextFieldListCell.forListView());
        this.useFormsListView.setPrefHeight(levelField.getFont().getSize() * 6);
        this.addUseForm = new Button("+");
        this.addUseForm.setOnAction(event -> useFormsListView.getItems().add("Ручное устройство"));
        this.removeUseForm = new Button("-");
        this.removeUseForm.setOnAction(event -> {
            String entity = useFormsListView.getSelectionModel().getSelectedItem();
            if (entity != null) {
                useFormsListView.getItems().remove(entity);
            }
        });
        Pane useFormSeparator = new Pane();
        HBox.setHgrow(useFormSeparator, Priority.ALWAYS);
        HBox useFormHeaderRow = new HBox(new Label("Формы"), useFormSeparator, addUseForm, removeUseForm);

        this.effectArea = new TextArea("");
        this.effectArea.setWrapText(true);
        VBox.setVgrow(effectArea, Priority.ALWAYS);

        this.sourceField = new TextField("");
        HBox sourceRow = new HBox(new Label("Источник: "), sourceField);
        HBox.setHgrow(sourceField, Priority.ALWAYS);

        root.getChildren().addAll(
                nameEnRow,
                nameRuRow,
                levelRow,
                useFormHeaderRow,
                useFormsListView,
                new Label("Эффект"),
                effectArea,
                sourceRow
        );

        return root;
    }

    @Override
    protected void clearContent() {
        nameEnField.setText("");
        nameRuField.setText("");
        levelField.setText("");
        occulticCheckBox.setSelected(false);
        useFormsListView.getChildrenUnmodifiable().clear();
        effectArea.setText("");
        sourceField.setText("");
    }

    @Override
    protected void redrawContent() {
        nameEnField.setText(item.getNameEn());
        nameRuField.setText(item.getNameRu());
        levelField.setText(item.getLevel().toString());
        occulticCheckBox.setSelected(item.isOccultic());
        useFormsListView.setItems(FXCollections.observableArrayList(item.getUseForms()));
        effectArea.setText(item.getEffect());
        sourceField.setText(item.getSource());
    }

    @Override
    protected void setContentEditable(boolean editable) {
        nameEnField.setEditable(editable);
        nameRuField.setEditable(editable);
        levelField.setEditable(editable);
        occulticCheckBox.setDisable(!editable);
        addUseForm.setDisable(!editable);
        removeUseForm.setDisable(!editable);
        useFormsListView.setEditable(editable);
        effectArea.setEditable(editable);
        sourceField.setEditable(editable);
    }

    @Override
    protected void applyChanges() {
        item.setNameEn(nameEnField.getText());
        item.setNameRu(nameRuField.getText());
        item.setLevel(new Roll(levelField.getText()));
        item.setOccultic(occulticCheckBox.isSelected());
        item.setUseForms(useFormsListView.getItems());
        item.setEffect(effectArea.getText());
        item.setSource(sourceField.getText());
    }
}
