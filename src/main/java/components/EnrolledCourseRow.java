package components;

import courses.Course;
import courses.Courses;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.Objects;

public class EnrolledCourseRow extends HBox {
    Label initialLabel;
    Label courseTitleLabel;

    public EnrolledCourseRow(String initial, String courseTitle) {
        this.setSpacing(5.0);
        this.setStyle("-fx-background-color: #f2b6b6;");
        this.setPadding(new Insets(5.0));

        initialLabel = new Label(initial);
        initialLabel.setPrefSize(66.0, 26.0);
        initialLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        initialLabel.setTextFill(javafx.scene.paint.Color.web("#181212"));
        initialLabel.setFont(new Font(15.0));
        HBox.setHgrow(initialLabel, javafx.scene.layout.Priority.ALWAYS);

        courseTitleLabel = new Label(courseTitle);
        courseTitleLabel.setPrefSize(401.0, 26.0);
        courseTitleLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        courseTitleLabel.setTextFill(javafx.scene.paint.Color.web("#181212"));
        courseTitleLabel.setFont(new Font(15.0));
        HBox.setHgrow(courseTitleLabel, javafx.scene.layout.Priority.ALWAYS);

        this.getChildren().addAll(initialLabel, courseTitleLabel);
    }

    public Course getCourse() {
        return new Course(this.initialLabel.getText(), this.courseTitleLabel.getText(), Objects.requireNonNull(Courses.getCourse(initialLabel.getText())).getCredit(), "");
    }
}
