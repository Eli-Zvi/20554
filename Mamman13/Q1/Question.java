/**
 * Student Name: Ilay Zvi
 *  Date: 9/1/2023
 *  Class Name: Question
 */
package com.example.mamman13q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question {

    private String question;
    private ArrayList<String> answers;
    private String correctAnswer;

    public Question(String question, String[] answers, String correctAnswer)
    {
        this.question = question;
        this.answers = new ArrayList<>(Arrays.asList(answers));
        this.correctAnswer = correctAnswer;
    }

    /**
     * returns 1 out of 4 questions for the question based on answerNumber
     * @param answerNumber the answer number(0-3)
     * @return a string containing one of the answers for the question
     */
    public String getAnswer(int answerNumber)
    {
        return answers.get(answerNumber);
    }

    /**
     * checks if answer is the correct answer to the question
     * @param answer - answer to be compared to correctAnswer
     * @return true if answer is the correct answer, false otherwise
     */
    public boolean checkAnswer(String answer)
    {
        return answer.equals(correctAnswer);
    }

    /**
     * shuffles the answers
     */
    public void shuffle()
    {
        Collections.shuffle(answers);
    }
}
