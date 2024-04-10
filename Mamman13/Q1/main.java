/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 9/1/2023
 *  Class Name: main
 */
package com.example.mamman13q1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("multipleChoice.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Exam");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}