/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 9/1/2023
 *  Class Name: MultipleChoiceController
 */
package com.example.mamman13q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MultipleChoiceController {

    private Exam exam;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private ToggleGroup answerToggleGroup;
    @FXML
    private RadioButton answer1Button;
    @FXML
    private RadioButton answer2Button;
    @FXML
    private RadioButton answer3Button;
    @FXML
    private RadioButton answer4Button;
    @FXML
    private Label answer1Label;
    @FXML
    private Label answer2Label;
    @FXML
    private Label answer3Label;
    @FXML
    private Label answer4Label;

    @FXML
    private Button nextButton;

    @FXML
    private Button retakeButton;


    /**
     * initializes a new exam
     */
    public void initialize()
    {
        exam = new Exam();
        // sets the radio buttons to be not traversable
        answer1Button.setFocusTraversable(false);
        answer2Button.setFocusTraversable(false);
        answer3Button.setFocusTraversable(false);
        answer4Button.setFocusTraversable(false);

        disableLabels(); // disables the unnecessary labels and buttons
        nextQuestion(); // displays first question
    }

    /**
     * displays the result of the user's answer(correct/incorrect) and changes the UI
     * @param event - radio button click event
     */
    @FXML
    private void answerRadioButtonSelected(ActionEvent event) {

        if(exam.checkAnswer((String) answerToggleGroup.getSelectedToggle().getUserData())) // check if the answer is correct
        {
            exam.incrementCorrectAnswers(); //increment the number of correct answers
            resultLabel.setText("Correct"); //display "correct"
        } else {
            resultLabel.setText("Incorrect"); //display incorrect if incorrect answer
        }

        resultLabel.setVisible(true); //display result
        changeButtonClick(true); //lock radio buttons

        if(exam.nextQuestion()) //if theres more questions show next button
        {
            nextButton.setDisable(false);
        }
        else { //otherwise we finished exam, show score and enable retake button
            scoreLabel.setText("Exam Score: " + (100 * exam.getCorrectAnswers()/exam.getTotalQuestions()));
            scoreLabel.setVisible(true);
            nextButton.setDisable(true);
            retakeButton.setDisable(false);
        }
    }

    /**
     * display next question on next button click
     * @param event
     */
    @FXML
    private void nextButtonPressed(ActionEvent event) {
        nextQuestion();
        resultLabel.setVisible(false);
        nextButton.setDisable(true);
    }

    /**
     * retake exam on retake button click
     * @param event
     */
    @FXML
    private void retakeButtonPressed(ActionEvent event) {
        retakeButton.setDisable(true);
        exam.retake();
        disableLabels();
        exam.resetCorrectAnswers();
        nextQuestion();
    }

    /**
     * disables the unnecessary labels and retake/next button while a question is under way
     */
    public void disableLabels()
    {
        scoreLabel.setVisible(false);
        resultLabel.setVisible(false);
        retakeButton.setDisable(true);
        nextButton.setDisable(true);
    }

    /**
     * Sets radio buttons' mode
     * @param bool - boolean stating the mode we should set the button to
     */
    public void changeButtonClick(boolean bool)
    {
        answer1Button.setDisable(bool);
        answer2Button.setDisable(bool);
        answer3Button.setDisable(bool);
        answer4Button.setDisable(bool);
    }

    /**
     * displays the next question onto the UI
     */
    public void nextQuestion()
    {
        if(answerToggleGroup.getSelectedToggle() != null)
            answerToggleGroup.getSelectedToggle().setSelected(false);

        exam.shuffle(); //shuffle the new question
        //displays the new question and answers, and store the answer variables inside buttons 1-4
        questionLabel.setText(exam.getQuestion());
        answer1Button.setUserData(exam.getAnswer(0));
        answer2Button.setUserData(exam.getAnswer(1));
        answer3Button.setUserData(exam.getAnswer(2));
        answer4Button.setUserData(exam.getAnswer(3));
        answer1Label.setText(exam.getAnswer(0));
        answer2Label.setText(exam.getAnswer(1));
        answer3Label.setText(exam.getAnswer(2));
        answer4Label.setText(exam.getAnswer(3));
        changeButtonClick(false);

    }

}
