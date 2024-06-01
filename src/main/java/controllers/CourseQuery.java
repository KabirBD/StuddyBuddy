package controllers;


import components.CourseInfoComponent;
import courses.Courses;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Objects;

public class CourseQuery {


    @FXML
    private TextField queryInputField;

    @FXML
    private VBox searchResultContainer;

    @FXML
    void search() {
        searchResultContainer.getChildren().clear();
        searchResultContainer.getChildren().add( new CourseInfoComponent(Objects.requireNonNull(Courses.getCourse(queryInputField.getText()))));
        System.out.println(Courses.getCourse(queryInputField.getText()));
    }

}
