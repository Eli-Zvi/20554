/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: PhilosopherApp
 */
package com.example.mamman15q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PhilosopherApp extends Application {

    /*
    added this to force the program to close and doesn't leave the threads after closing the window
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PhilosophersGraphic.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Philosophers");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
