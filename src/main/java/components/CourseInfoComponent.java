package components;

import courses.Course;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CourseInfoComponent extends VBox {

//    private Text titleField;
//    private Text typeField;
//    private Text creditField;
//    private Text requireField;
//    private Text descriptionField;

    public CourseInfoComponent( Course course) {
        this.setPrefSize(674.0, 184.0);

        // Course Title
        HBox titleBox = new HBox();
        Text titleField = new Text( "Course Title: "+course.getTitle());
        titleField.setFont(new Font(19.0));
        titleBox.getChildren().add(titleField);

        // Course Type
        HBox typeBox = new HBox();
        Text typeField = new Text("Course Type: "+course.getType());
        typeField.setFont(new Font(19.0));
//        typeField.setWrappingWidth(558.4413471221924);
        typeBox.getChildren().add(typeField);

        // Course Credit
        HBox creditBox = new HBox();
        Text creditField = new Text( "Credits: "+ course.getCredit());
        creditField.setFont(new Font(19.0));
//        creditField.setWrappingWidth(558.4413471221924);
        creditBox.getChildren().add( creditField);

        // Pre-requisites
        HBox requireBox = new HBox();
        Text requireField = new Text(course.getRequire());
        requireField.setFont(new Font(19.0));
//        requireField.setWrappingWidth(558.4413471221924);
        requireBox.getChildren().add(requireField);

        // Course Description
        HBox descriptionBox = new HBox();
        Text descriptionField = new Text("Course Details:\n"+course.getDecription());
        descriptionField.setFont(new Font(18.0));
        descriptionField.setWrappingWidth(666.0195598602295);
        descriptionBox.getChildren().add(descriptionField);

        // Add all HBoxes to the root VBox
        this.getChildren().addAll(titleBox, typeBox, creditBox, requireBox, descriptionBox);
    }

}
