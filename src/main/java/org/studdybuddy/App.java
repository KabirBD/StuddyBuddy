package org.studdybuddy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SnapshotResult;
import javafx.stage.Stage;
import tools.DateCustomizer;

import java.io.IOException;

public class App extends Application {

    public static Stage homeStage;
    public static Stage userInfoFormStage;
    public static Stage cgpaCalculatorStage;
    public static Stage courseQueryStage;

    @Override
    public void start(Stage stage) throws IOException {
        homeStage = stage;
        cgpaCalculatorStage = new Stage();
        courseQueryStage = new Stage();
        userInfoFormStage = new Stage();
        loadHomePage();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println(DateCustomizer.getTime());
        System.exit(0);
    }

    public static void loadHomePage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        homeStage.setTitle("Studdy Buddy");
        homeStage.setScene(scene);
        homeStage.setMinWidth(500);
        homeStage.setMinHeight(400);
        homeStage.show();
    }

    public static void loadCgpaCalculatorPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cgpaCalculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        cgpaCalculatorStage.setTitle("CGPA Calculator");
        cgpaCalculatorStage.setScene(scene);
        courseQueryStage.setMinWidth(500);
        cgpaCalculatorStage.setMinHeight(400);
        cgpaCalculatorStage.show();
    }

    public static void loadCourseQueryPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("courseQuery.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        courseQueryStage.setTitle("Course Query");
        courseQueryStage.setScene(scene);
        courseQueryStage.setMinWidth(500);
        courseQueryStage.setMinHeight(400);
        courseQueryStage.show();
    }

    public static void loadUserInfoPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("studentInfoForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        userInfoFormStage.setTitle("User Information");
        userInfoFormStage.setScene(scene);
        userInfoFormStage.setMinWidth(500);
        userInfoFormStage.setMinHeight(400);
        userInfoFormStage.show();
    }

    public static void closeUserInfoPage() {
        userInfoFormStage.close();
    }


}