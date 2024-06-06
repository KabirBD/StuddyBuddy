package controllers;


import components.CourseInfo;
import courses.Course;
import courses.Courses;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class CourseQuery {


    @FXML
    private TextField queryInputField;

    @FXML
    private VBox searchResultContainer;

    @FXML
    void search() {
        searchResultContainer.getChildren().clear();
        Course[] matchedCourses = Courses.getMatchedCourses(queryInputField.getText());
        if (matchedCourses != null)
            for (Course course : matchedCourses) {
                if (course != null) {
                    searchResultContainer.getChildren().add(new CourseInfo(course));
                }
            }
    }


}
