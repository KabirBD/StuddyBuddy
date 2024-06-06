package controllers;

import com.google.gson.Gson;
import components.*;
import courses.Course;
import courses.Courses;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.studdybuddy.App;
import tools.Cgpa;
import tools.DateCustomizer;
import tools.LocalStorage;
import user.Task;
import user.UserData;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HomePage {
    @FXML
    private Label cgpaOutput;

    @FXML
    private VBox completedCourseInfoContainer;

    @FXML
    private VBox completedCourseListContainer;

    @FXML
    private Label completedCreditOut;

    @FXML
    private VBox completedTasksContainer;

    @FXML
    private TextField courseInitialTextField;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private VBox enrolledCourseInfoContainer;

    @FXML
    private VBox enrolledCourseListContainer;

    @FXML
    private Label enrolledCreditOut;

    @FXML
    private VBox missingTasksContainer;

    @FXML
    private Label semesterOutput;

    @FXML
    private TextArea taskDetailsField;

    @FXML
    private VBox todayTasksContainer;

    @FXML
    private TitledPane todayTitlePane;

    @FXML
    private Label trailOutput;

    @FXML
    private Label tuitionFee;

    @FXML
    private VBox upcomingTasksContainer;

    @FXML
    private VBox userInfoContainer;


    @FXML
    void initialize() {
        dueDatePicker.setValue(LocalDate.now());
        dueDatePicker.setEditable(false);
        courseInitialTextField.textProperty().addListener((observable, oldValue, newValue) -> checkInitial(courseInitialTextField, oldValue, newValue));
        if (LocalStorage.fileExists("taskData")) {
            Gson gson = new Gson();
            Task[] tasks = gson.fromJson(LocalStorage.loadJsonString("taskData"), Task[].class);
            updateTasks(tasks);
        }

        todayTitlePane.setExpanded(true);

        UserData userData = LocalStorage.loadUseData();

        if (userData != null) {
            if (userData.getCompletedCourse() != null && userData.getCompletedCourse().length > 0) {
                for (Course course : userData.getCompletedCourse()) {
                    if (course != null)
                        completedCourseListContainer.getChildren().add(new CompletedCourseRow(course.getInitial(), course.getTitle(), course.getGrade()));
                }
            } else {
                completedCourseInfoContainer.getChildren().remove(0, 3);
            }
            if (userData.getEnrolledCourse() != null && userData.getEnrolledCourse().length > 0) {
                for (Course course : userData.getEnrolledCourse()) {
                    if (course != null)
                        enrolledCourseListContainer.getChildren().add(new EnrolledCourseRow(course.getInitial(), course.getTitle()));
                }
                tuitionFee.setText("" + (Courses.countTotalCredit(userData.getEnrolledCourse()) * 6500 + 4500 + 3750 + 2250 + 3750) + " TAKA");
            } else {
                enrolledCourseInfoContainer.getChildren().remove(0, 3);
            }

            cgpaOutput.setText("" + Cgpa.calculate(userData.getCompletedCourse()) + (Cgpa.calculate(userData.getCompletedCourse()) < 2 ? " Probation" : ""));
            semesterOutput.setText("" + userData.getSemester() + suffix(userData.getSemester()));
            trailOutput.setText(userData.getTrail());
            completedCreditOut.setText("" + Courses.countTotalCredit(userData.getCompletedCourse()));
            enrolledCreditOut.setText("" + Courses.countTotalCredit(userData.getEnrolledCourse()));
            userInfoContainer.getChildren().removeLast();
        } else {
            userInfoContainer.getChildren().removeFirst();
        }

    }

    private void checkInitial(TextField textField, String oldValue, String newValue) {
        if (Courses.isValid(newValue)) {
            textField.setStyle("-fx-text-box-border: green ;\n" + "  -fx-focus-color: green ;");
        } else {
            textField.setStyle("-fx-text-box-border: red ;\n" + "  -fx-focus-color: red ;");
        }

    }

    private void updateTasks(Task[] tasks) {
        for (Task task : tasks) {
            if (task != null) {
                if (DateCustomizer.isToday(task.date) && !task.isCompleted) {
                    TaskView t = new TaskView(todayTasksContainer, completedTasksContainer, task.title, task.details, task.date, task.isCompleted);
                    todayTasksContainer.getChildren().add(t);
                } else if (DateCustomizer.isUpcoming(task.date) && !task.isCompleted) {
                    TaskView t = new TaskView(upcomingTasksContainer, completedTasksContainer, task.title, task.details, task.date, task.isCompleted);
                    upcomingTasksContainer.getChildren().add(t);
                } else if (DateCustomizer.isPast(task.date) && !task.isCompleted) {
                    TaskView t = new TaskView(missingTasksContainer, completedTasksContainer, task.title, task.details, task.date, task.isCompleted);
                    missingTasksContainer.getChildren().add(t);
                } else {
                    TaskView t = new TaskView(completedTasksContainer, completedTasksContainer, task.title, task.details, task.date, task.isCompleted);
                    completedTasksContainer.getChildren().add(t);
                }
            }
        }
    }

    @FXML
    void addTask(ActionEvent event) {
        if (courseInitialTextField.getText().isEmpty() || taskDetailsField.getText().isEmpty() || !Courses.isValid(courseInitialTextField.getText())) {
            return;
        }
        try {
            LocalDate selectedDate = dueDatePicker.getValue();
            DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = selectedDate.format(DATE);
            String title = Courses.getCourse(courseInitialTextField.getText()).getTitle();
            if (DateCustomizer.isToday(date)) {
                TaskView t = new TaskView(todayTasksContainer, completedTasksContainer, title, taskDetailsField.getText(), date, false);
                todayTasksContainer.getChildren().addFirst(t);
            } else if (DateCustomizer.isPast(date)) {
                TaskView t = new TaskView(missingTasksContainer, completedTasksContainer, title, taskDetailsField.getText(), date, false);
                missingTasksContainer.getChildren().addFirst(t);
            } else if (DateCustomizer.isUpcoming(date)) {
                TaskView t = new TaskView(upcomingTasksContainer, completedTasksContainer, title, taskDetailsField.getText(), date, false);
                upcomingTasksContainer.getChildren().addFirst(t);
            }
            saveSnapshot();
            taskDetailsField.setText("");
            courseInitialTextField.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void saveSnapshot() {
        Task[] tasks = new Task[todayTasksContainer.getChildren().size() + completedTasksContainer.getChildren().size() + missingTasksContainer.getChildren().size() + upcomingTasksContainer.getChildren().size()];
        int i = 0;
        for (Node task : todayTasksContainer.getChildren()) {
            if (task instanceof TaskView tskView) {
                tasks[i++] = tskView.getTask();
            }
        }
        for (Node task : completedTasksContainer.getChildren()) {
            if (task instanceof TaskView tskView) {
                tasks[i++] = tskView.getTask();
            }
        }
        for (Node task : missingTasksContainer.getChildren()) {
            if (task instanceof TaskView tskView) {
                tasks[i++] = tskView.getTask();
            }
        }
        for (Node task : upcomingTasksContainer.getChildren()) {
            if (task instanceof TaskView tskView) {
                tasks[i++] = tskView.getTask();
            }
        }
        Gson gson = new Gson();
        String jsonData = gson.toJson(tasks);
        LocalStorage.saveJsonString(jsonData, "taskData");
        System.out.println(gson.toJson(tasks));
    }

    @FXML
    void openCgpaCalculator(ActionEvent event) throws IOException {
        App.loadCgpaCalculatorPage();
    }

    @FXML
    void openCourseQuery(ActionEvent event) throws IOException {
        App.loadCourseQueryPage();
    }

    @FXML
    void openInfoForm(ActionEvent event) throws IOException {
        App.loadUserInfoPage();
    }


    private String suffix(int n) {
        return n == 1 ? "st" : n == 2 ? "nd" : n == 3 ? "rd" : "th";
    }

}
