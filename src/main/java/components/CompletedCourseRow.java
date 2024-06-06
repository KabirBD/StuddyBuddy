package components;

import courses.Course;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class CompletedCourseRow extends HBox {
    Label initialLabel;
    Label courseTitleLabel;
    Label gradeLabel;

    public CompletedCourseRow(String initial, String courseTitle, String grade) {

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

        gradeLabel = new Label(grade);
        gradeLabel.setPrefSize(57.0, 22.0);
        gradeLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        gradeLabel.setTextFill(javafx.scene.paint.Color.web("#181212"));
        gradeLabel.setFont(new Font(15.0));
        HBox.setHgrow(gradeLabel, javafx.scene.layout.Priority.ALWAYS);

        this.getChildren().addAll(initialLabel, courseTitleLabel, gradeLabel);
    }

    public Course getCourse() {
        return new Course(this.initialLabel.getText(), this.courseTitleLabel.getText(), this.gradeLabel.getText());
    }
}
