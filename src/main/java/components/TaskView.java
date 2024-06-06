package components;

import com.google.gson.Gson;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tools.LocalStorage;
import user.Task;

public class TaskView extends HBox {

    private boolean isCompleted;
    private Task task;

    private Label courseTitleView;
    private Text taskDetailsView;
    private Text dueDateView;
    private Button completeButton;
    private Button deleteButton;

    public TaskView(VBox parentContainer, VBox completedTasksContainer, String title, String details, String dueDate, boolean isCompleted) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5.0);
        this.setStyle("-fx-background-color: #f5f5f5; -fx-border-radius: 5px;");

        VBox contentBox = new VBox();
        contentBox.setSpacing(5.0);
        contentBox.setPadding(new Insets(5, 10, 5, 5));

        courseTitleView = new Label(title);
        courseTitleView.setTextFill(Color.DARKGREEN);
        courseTitleView.setFont(Font.font("System Bold", 16));
        contentBox.getChildren().add(courseTitleView);

        taskDetailsView = new Text(details);
        taskDetailsView.setFill(Color.BLACK);
        taskDetailsView.setWrappingWidth(220);
        taskDetailsView.setFont(Font.font(14));
        contentBox.getChildren().add(taskDetailsView);

        dueDateView = new Text(dueDate);
        dueDateView.setFill(Color.GRAY);
        dueDateView.setFont(Font.font("System Italic", 12));
        contentBox.getChildren().add(dueDateView);

        this.getChildren().add(contentBox);

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.setSpacing(5.0);
        buttonBox.setPadding(new Insets(5, 10, 5, 5));

        completeButton = new Button("Complete");
        completeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-color: transparent; -fx-border-radius: 5px;");
        completeButton.setPrefWidth(80.0);
        completeButton.setFont(Font.font("System Bold", 12));
        completeButton.setCursor(Cursor.HAND);
        completeButton.setDisable(isCompleted);
        completeButton.setOnAction(event -> {
            this.isCompleted = true;
            completeButton.setDisable(true);
            if (LocalStorage.fileExists("taskData")) {
                Gson gson = new Gson();
                Task[] tasks = gson.fromJson(LocalStorage.loadJsonString("taskData"), Task[].class);
                for (int i = 0; i < tasks.length; i++) {
                    if (tasks[i] != null && tasks[i].equals(this.task)) tasks[i].isCompleted = true;
                }
                LocalStorage.saveJsonString(gson.toJson(tasks), "taskData");
            }
            completedTasksContainer.getChildren().add(new TaskView(completedTasksContainer, completedTasksContainer, title, details, dueDate, true));
            parentContainer.getChildren().remove(this);
        });
        buttonBox.getChildren().add(completeButton);

        deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-border-color: transparent; -fx-border-radius: 5px;");
        deleteButton.setPrefWidth(80.0);
        deleteButton.setFont(Font.font("System Bold", 12));
        deleteButton.setCursor(Cursor.HAND);
        deleteButton.setOnAction((event) -> {
            if (LocalStorage.fileExists("taskData")) {
                Gson gson = new Gson();
                Task[] tasks = gson.fromJson(LocalStorage.loadJsonString("taskData"), Task[].class);
                for (int i = 0; i < tasks.length; i++) {
                    if (tasks[i] != null && tasks[i].equals(this.task)) tasks[i] = null;
                }
                LocalStorage.saveJsonString(gson.toJson(tasks), "taskData");
            }
            parentContainer.getChildren().remove(this);
        });
        buttonBox.getChildren().add(deleteButton);

        this.getChildren().add(buttonBox);

        this.setPadding(new Insets(5.0));

        this.setTask(new Task(getTitle(), getDetails(), getDueDate(), isCompleted));
    }

    public String getTitle() {
        return this.courseTitleView.getText();
    }

    public String getDetails() {
        return this.taskDetailsView.getText();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDueDate() {
        return this.dueDateView.getText();
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
