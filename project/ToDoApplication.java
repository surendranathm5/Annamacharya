package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ToDoApplication extends Application {

    private ListView<String> listView;
    private TextField taskInput;

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        listView = new ListView<>();
        taskInput = new TextField();
        taskInput.setPromptText("Enter a new task");

        Button addButton = new Button("Add Task");
        Button removeButton = new Button("Remove Selected");

        addButton.setOnAction(e -> addTask());
        removeButton.setOnAction(e -> removeSelectedTask());

        HBox inputBox = new HBox(10, taskInput, addButton);
        inputBox.setPadding(new Insets(10));

        VBox layout = new VBox(10, inputBox, listView, removeButton);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            listView.getItems().add(task);
            taskInput.clear();
        }
    }

    private void removeSelectedTask() {
        String selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            listView.getItems().remove(selected);
        }
    }
}
