package components;

import courses.Course;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CourseInfo extends VBox {

    public CourseInfo(Course course) {


        Text titleField = new Text("Course Title: " + course.getTitle());

        Text initialField = new Text("Course Initial: " + course.getInitial());

        Text typeField = new Text("Course Type: " + course.getType());

        Text creditField = new Text("Credits: " + course.getCredit());

        Text requireField = new Text("Pre-requisites: " + course.getRequire());

        Text descriptionField = new Text("Course Details:\n" + course.getDescription());
        descriptionField.setWrappingWidth(650.0);

        this.getChildren().addAll(titleField, initialField, typeField, creditField, requireField, descriptionField);

        this.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 10; -fx-spacing: 5; -fx-border-color: #ccc; -fx-border-width: 1; -fx-border-radius: 5; -fx-background-radius: 5; -fx-font-size: 19;");
    }
}
