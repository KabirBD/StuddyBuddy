package components;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class CourseItem extends HBox {
    private TextField initialField;
    private TextField creditField;
    private TextField pointField;

    public CourseItem(VBox parentContainer) {
        setAlignment(Pos.CENTER);
        setPrefHeight(38.0);
        setPrefWidth(400.0);

        initialField = createTextField();
        creditField = createTextField();
        pointField = createTextField();

        getChildren().addAll(initialField, creditField, pointField);

        Button deleteButton = new Button("Delete");
        deleteButton.setCancelButton(true);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        deleteButton.setOnAction(event -> parentContainer.getChildren().remove(this));

        getChildren().add(deleteButton);
    }

    private TextField createTextField() {
        return new TextField();
    }

    // Getters for the TextFields
    public String getInitial() {
        return initialField.getText();
    }

    public String getCredit() {
        return creditField.getText();
    }

    public String getPoint() {
        return pointField.getText();
    }
}
