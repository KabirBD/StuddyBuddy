package org.studdybuddy;


import courses.Courses;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tools.Date;

import java.io.IOException;

public class App extends Application {

    public static Stage currentStage;


    public  static void loadPage( String fxml) throws IOException {
        loadPage(fxml, "Studdy Buddy");
    }
    public  static void loadPage( String fxml, boolean newStage) throws IOException {
        loadPage(fxml, "Studdy Buddy", newStage);
    }
    public  static void loadPage( String fxml, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = currentStage;
//        stage.setHeight(stage.getHeight());
//        stage.setWidth(stage.getWidth());
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        currentStage = stage;
    }

    public  static void loadPage( String fxml, String title, boolean newStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage;
        if (newStage){
            stage = new Stage();
        }else{
         stage = currentStage;
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        currentStage = stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        currentStage = stage;
        loadPage("home", "Studdy Buddy");
    }

    public static void main(String[] args) {
        launch();
        System.out.println(Date.getTime());
//        System.exit(0);
    }
}