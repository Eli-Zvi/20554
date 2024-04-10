/**
 * Student Name: Ilay Zvi
 *  Date: 11/1/2023
 *  Class Name: Calculator
 */

package com.example.mamman13q2;

public class Calculator {

    final static char[] OPERATORS = {'*','-','+','/'}; //stores all 4 types of operators and is used by findOperator
    private String [] numbers = {"",""}; //stores the numbers given by the user
    private char operator = ' '; //stores the operator given by the user
    private int currentNumber = 0; //currentNumber changes from 0 and 1, changes based on the use of an operator as an indication that we moved to the second number
    private double result = 0; //the result of the operation

    public double getResult() { return result; }

    public String getFirstNumber() { return numbers[0]; }

    public String getSecondNumber()
    {
        return numbers[1];
    }

    public char getOperator() { return operator; }

    /**
     * Concat param number to the end of the current number
     * @param number a number button that was pressed by user
     */
    public void concatNumber(int number)
    {
        if(numbers[currentNumber].equals("0")) //if the current number is 0, replace with the number that was pressed i.e: "0" -> "5"
            numbers[currentNumber] = "" + number;
        else numbers[currentNumber] += number;

        if(result != 0) //reset result after a number was pressed
            result = 0;
    }

    /**
     * Saves given operator in variable operator
     * @param number a number between 0-3 that indicates the operator type
     * @return true if operator was found successfully false otherwise
     */
    public boolean findOperator(int number)
    {
        if(numbers[1].isEmpty()) {
            if (result != 0) { //if result isn't 0 it means the user wants the first number to be result
                numbers[0] = String.valueOf(result);
                result = 0;
            }

            if(numbers[0].isEmpty() || numbers[0].equals("0.")) //if the first number is empty, we assume its 0
                numbers[0] = "0";

            if(numbers[0].endsWith("."))
                numbers[0] = numbers[0].substring(0,numbers[0].length()-1);

            currentNumber++; //find next number
            operator = OPERATORS[number]; //saves operator type in operator
            return true;
        } return false;
    }

    /**
     * negate the current number
     */
    public void negateNumber()
    {
        if(result != 0) {
            numbers[0] = String.valueOf(result); //store result in numbers[0]
            result = 0; //reset result
        }

        if(!numbers[currentNumber].isEmpty() && Double.parseDouble(numbers[currentNumber]) != 0) //check if the current number is empty and the number isn't 0
        {
            if(numbers[currentNumber].charAt(0) != '-') //if the number isn't negative, add a negative mark at the begging
                numbers[currentNumber] = "-".concat(numbers[currentNumber]);
            else
            {
                numbers[currentNumber] = numbers[currentNumber].substring(1);//remove negative from the beginning
            }
        }
    }

    /**
     * Adds decimal at the end of the number
     */
    public void addDecimal()
    {
        if(result != 0)//reset result
            result = 0;

        if(!numbers[currentNumber].contains(".")) { //check if there's a decimal
            if (numbers[currentNumber].isEmpty()) //if the number is empty aka 0
                numbers[currentNumber] += "0.";
            else numbers[currentNumber] += "."; //if there is a number add a dot at the end
        }
        else {
            if(numbers[currentNumber].equals("0.")) //if . was clicked again before any numbers were clicked, remove the 0.
                numbers[currentNumber] = "";

            if(numbers[currentNumber].endsWith(".")) //if the number ends with a "." we can remove it
                numbers[currentNumber] = numbers[currentNumber].substring(0,numbers[currentNumber].length()-1);
        }
    }

    /**
     * Calculates the result of numbers[0] (+,-,*,/) numbers[1]
     * a calculation is done successfully if both numbers aren't empty
     * @return true if the calculation was done successfully, false otherwise
     */
    public boolean calculate()
    {
        if(currentNumber == 1 && !numbers[1].isEmpty()) { //checks if numbers[1] is empty
            double firstNumber = Double.parseDouble(numbers[0]);
            double secondNumber = Double.parseDouble(numbers[1]);

            switch (operator) {
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
            }

            //reset variables
            operator = ' ';
            currentNumber = 0;
            numbers[0] = "";
            numbers[1] = "";
            return true;
        }
        return false;
    }

    /* planned on using but never had any use
    public boolean isCurrentNumberEmpty(){ return numbers[currentNumber].isEmpty(); }
    public String getCurrentNumber() { return numbers[currentNumber]; }
    */
}
