package controllers;

import com.google.gson.Gson;
import components.CompletedCourseItem;
import components.CompletedCourseRow;
import components.EnrolledCourseItem;
import components.EnrolledCourseRow;
import courses.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import org.studdybuddy.App;
import tools.LocalStorage;
import user.UserData;

import java.io.IOException;

public class StudentInfoForm {

    @FXML
    private VBox completedCourseContainer;

    @FXML
    private VBox enrolledCourseContainer;


    @FXML
    private ChoiceBox<Integer> semesterPicker;

    @FXML
    private ChoiceBox<String> trailPicker;

    @FXML
    void initialize() {
        semesterPicker.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        trailPicker.getItems().addAll("Not Selected", "Algorithms and Computation", "Software Engineering", "Networks", "Computer Architecture and VLSI", "Artificial Intelligence", "Bioinformatics");
        semesterPicker.setValue(1);
        trailPicker.setValue("Not selected");
        UserData userData = LocalStorage.loadUseData();
        if (userData != null) {
            semesterPicker.setValue(userData.getSemester());
            trailPicker.setValue(userData.getTrail());
            for (Course course : userData.getCompletedCourse()) {
                if (course != null)
                    completedCourseContainer.getChildren().add(new CompletedCourseItem( course.getInitial(), course.getGrade()));
            }
            for (Course course : userData.getEnrolledCourse()) {
                if (course != null)
                    enrolledCourseContainer.getChildren().add(new EnrolledCourseItem(course.getInitial()));
            }
        }

    }

    @FXML
    void addCompletedCourseBox(ActionEvent event) {
        completedCourseContainer.getChildren().add(new CompletedCourseItem());
    }

    @FXML
    void addEnrolledCourseBox(ActionEvent event) {
        enrolledCourseContainer.getChildren().add(new EnrolledCourseItem());
    }

    @FXML
    void saveInfo(ActionEvent event) throws IOException {
        Gson gson = new Gson();
        UserData data = this.getUserData();
        LocalStorage.saveJsonString(gson.toJson(data), "userInfo.json");
        App.closeUserInfoPage();
        App.loadHomePage();
    }


    public Course[] getCompletedCourses() {
        Course[] courses = new Course[completedCourseContainer.getChildren().size()];
        int i = 0;
        for (Node item : completedCourseContainer.getChildren()) {
            if (item instanceof CompletedCourseItem courseItem) {
                if (courseItem.getCourse() != null) courses[i++] = courseItem.getCourse();
            }
        }
        return courses;
    }

    public Course[] getEnrolledCourses() {
        Course[] courses = new Course[enrolledCourseContainer.getChildren().size()];
        int i = 0;
        for (Node item : enrolledCourseContainer.getChildren()) {
            if (item instanceof EnrolledCourseItem courseItem) {
                if (courseItem.getCourse() != null) courses[i++] = courseItem.getCourse();
            }
        }
        return courses;
    }

    public UserData getUserData() {
        return new UserData(semesterPicker.getValue(), trailPicker.getValue(), getCompletedCourses(), getEnrolledCourses());
    }

}
