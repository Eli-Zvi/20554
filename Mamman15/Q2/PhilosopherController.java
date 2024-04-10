/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: PhilosopherController
 */

package com.example.mamman15q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhilosopherController {
    @FXML
    private Line P1P5Stick;
    @FXML
    private Line P1P2Stick;
    @FXML
    private Line P4P5Stick;
    @FXML
    private Line P3P4Stick;
    @FXML
    private Line P2P3Stick;

    @FXML
    private Line P1RightStick;
    @FXML
    private Line P1LeftStick;

    @FXML
    private Line P2LeftStick;
    @FXML
    private Line P2RightStick;

    @FXML
    private Line P3RightStick;
    @FXML
    private Line P3LeftStick;

    @FXML
    private Line P4RightStick;
    @FXML
    private Line P4LeftStick;

    @FXML
    private Line P5RightStick;
    @FXML
    private Line P5LeftStick;

    @FXML
    private Button closeButton;
    @FXML
    private Button startButton;

    private final ExecutorService exec = Executors.newFixedThreadPool(5); //initialize threads

    private Chopstick stick;
    private Chopstick stick2;
    private Chopstick stick3;
    private Chopstick stick4;
    private Chopstick stick5;

    private Philosopher P1;
    private Philosopher P2;
    private Philosopher P3;
    private Philosopher P4;
    private Philosopher P5;

    static boolean stop = false; //used to stop threads when stop isnt overriden in app class

    public void initialize()
    {
        /*
         initializes philosophers and their respective philosophers
         */
        stick = new Chopstick(P1P5Stick);
        stick2 = new Chopstick(P1P2Stick);
        stick3 = new Chopstick(P2P3Stick);
        stick4 = new Chopstick(P3P4Stick);
        stick5 = new Chopstick(P4P5Stick);

        P1 = new Philosopher("P1",stick, stick2, P1RightStick, P1LeftStick);
        P2 = new Philosopher("P2",stick2, stick3, P2RightStick, P2LeftStick);
        P3 = new Philosopher("P3",stick3, stick4, P3RightStick, P3LeftStick);
        P4 = new Philosopher("P4",stick4, stick5, P4RightStick, P4LeftStick);
        P5 = new Philosopher("P5",stick5, stick, P5RightStick, P5LeftStick);

        closeButton.setDisable(true);
    }

    @FXML
    void closeButtonPressed(ActionEvent event) {
        closeButton.setDisable(true);
        stop = true;
    }

    @FXML
    void startButtonPressed(ActionEvent event) {
         startButton.setDisable(true);
         closeButton.setDisable(false);

         /*
         start threads
          */
         exec.execute(P1);
         exec.execute(P2);
         exec.execute(P3);
         exec.execute(P4);
         exec.execute(P5);

         exec.shutdown();
    }
}
