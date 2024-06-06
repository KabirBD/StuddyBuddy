package controllers;

import components.CourseItem;
import courses.Course;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import tools.Cgpa;

import java.util.ArrayList;
import java.util.List;

public class CgpaCalculator {

    @FXML
    private VBox courseListContainer;

    @FXML
    private Text cgpaOutput;

    @FXML
    void calculateCgpa() {
        Course[] courses = getCoursesArray(courseListContainer);
        cgpaOutput.setText("Calculated CGPA: " + Cgpa.calculate(courses));
    }

    @FXML
    public void addNewCourse() {
        CourseItem a = new CourseItem(courseListContainer);
        courseListContainer.getChildren().add(a);
    }

    @FXML
    void initialize(){
        addNewCourse();
        addNewCourse();
    }

    public static Course[] getCoursesArray(VBox courseListContainer) {
        List<Course> courses = new ArrayList<>();
        List<Node> children = courseListContainer.getChildren();

        for (Node node : children) {
            if (node instanceof CourseItem courseItem) {
                Course course = courseItem.getCourse();
                if (course != null) {
                    courses.add(course);
                }
            }
        }
        // Convert List to Course[]
        Course[] courseArray = new Course[courses.size()];
        return courses.toArray(courseArray);
    }
}