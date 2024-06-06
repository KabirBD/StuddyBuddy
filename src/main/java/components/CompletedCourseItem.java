package components;

import courses.Course;
import courses.Courses;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tools.Cgpa;

import java.util.Objects;

public class CompletedCourseItem extends HBox {

    private TextField courseInitialField = new TextField();;
    private TextField gradeField = new TextField();;

    public CompletedCourseItem(String initial, String grade) {
        courseInitialField.setText(initial);
        gradeField.setText(grade);
        set();

    }

    public CompletedCourseItem() {
        set();
    }


    private void set() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10.0);
        this.setPadding(new Insets(5.0));

        Label courseInitialLabel = new Label("Course Initial");
        courseInitialLabel.setFont(new javafx.scene.text.Font(13.0));

        courseInitialField.setPromptText("Enter Course Initial");
        courseInitialField.textProperty().addListener((observable, oldValue, newValue) -> checkInitial(courseInitialField, oldValue, newValue));

        Label gradeLabel = new Label("Grade");
        gradeLabel.setFont(new javafx.scene.text.Font(13.0));

        gradeField.setPromptText("Enter Obtained Grade");
        gradeField.textProperty().addListener((observable, oldValue, newValue) -> checkGrade(gradeField, oldValue, newValue));

        Button deleteButton = new Button("Delete");
        deleteButton.setMnemonicParsing(false);

        deleteButton.setOnAction(event -> {
            VBox parent = (VBox) this.getParent();
            if (parent != null) {
                parent.getChildren().remove(this);
            }
        });

        this.getChildren().addAll(courseInitialLabel, courseInitialField, gradeLabel, gradeField, deleteButton);
    }

    private void checkInitial(TextField textField, String oldValue, String newValue) {
        if (Courses.isValid(newValue)) {
            textField.setStyle("-fx-text-box-border: green ;\n" + "  -fx-focus-color: green ;");
        } else {
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

    public Course getCourse() {
        if (Courses.isValid(courseInitialField.getText()) && Cgpa.isValidGrade(gradeField.getText())) {
            Course refCourse = Courses.getCourse(courseInitialField.getText());
            assert refCourse != null;
            return new Course(refCourse.getInitial(), refCourse.getTitle(), refCourse.getCredit(), gradeField.getText().toUpperCase());
        }
        return null;

    }
}
