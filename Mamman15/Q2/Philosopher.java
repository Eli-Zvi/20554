/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: Philosopher
 */
package com.example.mamman15q2;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.shape.Line;
import java.util.Random;

public class Philosopher extends Task<Void>{

        private String name;
        private Chopstick rightStick; //the stick to the right of the philosopher
        private Chopstick leftStick; //the stick to the left of the philosopher
        private Line rightEatStick; //the stick that will be displayed when the philosopher picks up the right stick
        private Line leftEatStick; //the stick that will be displayed when the philosopher picks up the left stick
        private Random rand = new Random();
        private static final int EAT_THINK_TIME = 1000;

        public Philosopher(String name,Chopstick rightStick, Chopstick leftStick, Line rightEatStick, Line leftEatStick)
        {
            this.rightStick = rightStick;
            this.leftStick = leftStick;
            this.rightEatStick = rightEatStick;
            this.leftEatStick = leftEatStick;
            this.name = name;
        }

        public Line getLeftEatStick() {
                return leftEatStick;
        }

        public Line getRightEatStick() {
                return rightEatStick;
        }

        public Chopstick getLeftStick()
        {
                return leftStick;
        }

        public Chopstick getRightStick()
        {
                return rightStick;
        }

        /**
         * Run philosopher thread
         */
        @Override
        protected Void call()
        {
                while(!PhilosopherController.stop) //stops only when stop is initiated by user
                {
                        if(rightStick.takeChopStick()) { //attempt to take right stick lock
                                if (leftStick.takeChopStick()) { //attempt to take left stick lock
                                        gotPermission(); //change the gui,think and eat
                                } else {
                                        rightStick.putDownStick(); //put right stick down if left stick is taken
                                }
                        }
                }
                return null;
        }

        /**
         * When philosopher has grabbed both chopsticks, displays them in his hand and removes them from the table
         * he then eats for a period of time
         * the GUI is updated to put the chopsticks on the table and are removed from his hands, and he then releases their lock
         * finally he thinks for a period of time
         */
        private void gotPermission()
        {
                this.setStickVis(true); //show philosopher's sticks and take them from table
                eat();
                this.setStickVis(false); //hide philosopher sticks and put them down on table
                rightStick.putDownStick(); //put right stick down
                leftStick.putDownStick(); //put left stick down
                think();
        }

        /**
         * Philosopher is eating
         */
        public synchronized void eat()
        {
                try {
                        System.out.println(this.name + " is eating");
                        wait(EAT_THINK_TIME * (rand.nextInt(2)+1)); //waits for 2-3 seconds while eating
                }catch (InterruptedException e)
                {}
        }

        /**
         * Philosopher is thinking after eating
         */
        public synchronized void think()
        {
                try {
                        System.out.println(this.name + " thinking");
                        wait(EAT_THINK_TIME * (rand.nextInt(2)+1)); //waits for 2-3 seconds while thinking
                }catch (InterruptedException e) {}
        }

        /**
         * Shows philosopher's chopsticks when bool is true, and stop showing the respective sticks on the table
         * does the opposite when bool is false
         * @param bool sets the Philosophers eating sticks visible if true and the left and right sticks invisible,
         *             does the opposite when false
         */
        public void setStickVis(boolean bool)
        {
                Platform.runLater(() -> {
                        if(bool) {
                                getLeftStick().setStickVis(false);
                                getRightStick().setStickVis(false);
                                getRightEatStick().setVisible(true);
                                getLeftEatStick().setVisible(true);
                        }else {
                                getLeftStick().setStickVis(true);
                                getRightStick().setStickVis(true);
                                getRightEatStick().setVisible(false);
                                getLeftEatStick().setVisible(false);
                        }
                });

        }
}
