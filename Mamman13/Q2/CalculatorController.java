/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 11/1/2023
 *  Class Name: CalculatorController
 */

package com.example.mamman13q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorController {

    private Calculator calc;

    @FXML
    private Button zeroButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;

    @FXML
    private Button signButton;
    @FXML
    private Button decimalButton;
    @FXML
    private Button equalsButton;

    @FXML
    private Button multiplicationButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button additionButton;
    @FXML
    private Button divisionButton;

    @FXML
    private Label displayLabel;

    private ArrayList<Button> numberButtons; //sorted list of buttons from 0-9
    private ArrayList<Button> operatorButton; //list of buttons sorted according to OPERATORS in Calculator class

    public void initialize()
    {
        numberButtons = new ArrayList<>(Arrays.asList(zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton));
        operatorButton = new ArrayList<>(Arrays.asList(multiplicationButton,subtractionButton,additionButton,divisionButton));
        calc = new Calculator();
    }

    @FXML
    void equalsButtonPressed(ActionEvent event) {
        if(calc.calculate()) //check if calculation was done successfully
            displayLabel.setText(String.valueOf(calc.getResult()));
    }

    @FXML
    void numberButtonPressed(ActionEvent event) {
        int number = numberButtons.indexOf((Button)event.getSource()); //(Button)event.getSource() -> returns a button 0-9, and then searches for it in numberButtons and returns integer 0-9
        calc.concatNumber(number); //send integer to be added to the end of the current number
        displayLabel.setText(calc.getFirstNumber() + calc.getOperator() + calc.getSecondNumber());

    }

    @FXML
    void operatorButtonPressed(ActionEvent event) {
        if(calc.findOperator(operatorButton.indexOf((Button) event.getSource()))) //finds a number between 0-3 that belongs to the operator and sends it to findOperator so it can be stored
            displayLabel.setText(calc.getFirstNumber() + calc.getOperator() + calc.getSecondNumber());
    }

    @FXML
    void signButtonPressed(ActionEvent event) {
        calc.negateNumber();
        displayLabel.setText(calc.getFirstNumber() + calc.getOperator() + calc.getSecondNumber());
    }

    @FXML
    void decimalButtonPressed(ActionEvent event) {
        calc.addDecimal();
        displayLabel.setText(calc.getFirstNumber() + calc.getOperator() + calc.getSecondNumber());
    }
}
