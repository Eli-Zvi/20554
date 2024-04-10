/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 19/1/2023
 *  Class Name: PhoneBookApp
 */
package com.example.mamman14q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhoneBookApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("phoneBook.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("PhoneBook");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}