package controllers;

import components.CourseItem;
import javafx.fxml.FXML;

import javafx.scene.layout.*;


import java.io.IOException;


public class CgpaCalculator {

    CourseItem[] addedCourses = new CourseItem[10];
    int i=0;

    @FXML
    private VBox courseListContainer;

    @FXML
    void goHome() throws IOException {
        for(CourseItem course: addedCourses){
            if(course!=null){
                System.out.println(course.getInitial() + " | " + course.getCredit());
            }
        }

    }

    @FXML
    public void addNewCourse() {
        CourseItem a = new CourseItem(courseListContainer);
        addedCourses[i++] = a;
        courseListContainer.getChildren().add(a);
    }




}