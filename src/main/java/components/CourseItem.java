package components;

import courses.Course;
import courses.Courses;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import tools.Cgpa;

import java.util.Objects;

public class CourseItem extends HBox {
    private TextField initialField;
    private TextField creditField;
    private TextField gradeField;

    public CourseItem(VBox parentContainer) {
        setAlignment(Pos.CENTER);
        setSpacing(5);

        initialField = new TextField();
        creditField = new TextField();
        gradeField = new TextField();

        initialField.textProperty().addListener((observable, oldValue, newValue) -> checkInitial(initialField, oldValue, newValue));
        gradeField.textProperty().addListener((observable, oldValue, newValue) -> checkGrade(gradeField, oldValue, newValue));
        getChildren().addAll(initialField, creditField, gradeField);
        Button deleteButton = new Button("Delete");
        deleteButton.setCancelButton(true);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        deleteButton.setOnAction((event) -> parentContainer.getChildren().remove(this));

        getChildren().add(deleteButton);
    }

    public String getInitial() {
        return initialField.getText();
    }

    public double getCredit() {
        if (!creditField.getText().isEmpty()) {
            return Double.parseDouble(creditField.getText());
        } else return 0;
    }

    public String getGrade() {
        return gradeField.getText();
    }

    public Course getCourse() {
        if (Courses.isValid(this.getInitial()) && !this.getInitial().isBlank() && !this.getGrade().isBlank() && !this.creditField.getText().isBlank()) {
            Course refCourse = Courses.getCourse(this.getInitial());
            if (refCourse != null) {
                return new Course(refCourse.getInitial(), refCourse.getTitle(), this.getCredit(), this.getGrade());
            }
        }
        return null;
    }


    private void checkInitial(TextField textField, String oldValue, String newValue) {
        if (Courses.isValid(newValue)) {
            creditField.setText(String.valueOf(Objects.requireNonNull(Courses.getCourse(newValue)).getCredit()));
            textField.setStyle("-fx-text-box-border: green ;\n" + "  -fx-focus-color: green ;");
        } else {
            creditField.setText("");
            textField.setStyle("-fx-text-box-border: red ;\n" + "  -fx-focus-color: red ;");
        }

    }

    private void checkGrade(TextField textField, String oldValue, String newValue) {
        if (Cgpa.isValidGrade(newValue)) {
            textField.setStyle("-fx-text-box-border: green ;\n" + "  -fx-focus-color: green ;");
        } else {
            textField.setStyle("-fx-text-box-border: red ;\n" + "  -fx-focus-color: red ;");
        }

    }

}
