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

public class EnrolledCourseItem extends HBox {
    TextField courseInitialField = new TextField();
    ;

    public EnrolledCourseItem(String initial) {
        courseInitialField.setText(initial);
        set();
    }

    public EnrolledCourseItem() {
        set();
    }

    private void set() {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10.0);
        this.setPadding(new Insets(5.0));

        Label courseInitialLabel = new Label("Course Initial");
        courseInitialLabel.setFont(new javafx.scene.text.Font(13.0));

        courseInitialField.setPromptText("Type Initial");
        courseInitialField.textProperty().addListener((observable, oldValue, newValue) -> checkInitial(courseInitialField, oldValue, newValue));

        Button deleteButton = new Button("Delete");
        deleteButton.setMnemonicParsing(false);

        deleteButton.setOnAction(event -> {
            VBox parent = (VBox) this.getParent();
            if (parent != null) {
                parent.getChildren().remove(this);
            }
        });

        this.getChildren().addAll(courseInitialLabel, courseInitialField, deleteButton);
    }

    private void checkInitial(TextField textField, String oldValue, String newValue) {
        if (Courses.isValid(newValue)) {
            textField.setStyle("-fx-text-box-border: green ;\n" + "  -fx-focus-color: green ;");
        } else {
            textField.setStyle("-fx-text-box-border: red ;\n" + "  -fx-focus-color: red ;");
        }

    }


    public Course getCourse() {
        if (Courses.isValid(courseInitialField.getText())) {
            Course refCourse = Courses.getCourse(courseInitialField.getText());
            assert refCourse != null;
            return new Course(refCourse.getInitial(), refCourse.getTitle(), refCourse.getCredit());
        }
        return null;
    }
}
