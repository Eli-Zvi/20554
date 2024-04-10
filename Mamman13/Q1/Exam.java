/**
 * Student Name: Ilay Zvi
 *  Date: 9/1/2023
 *  Class Name: Exam
 */
package com.example.mamman13q1;

public class Exam {

    private static final String[] QUESTIONS = {
            "What is the result of 143 * 59?",
            "What is the capital of Austria?",
            "What is the derivative of 10x?",
            "Which of the following is a fruit?",
            "What is the result of 29381 + 9827?",
            "In what year did the first world war start?",
            "What is the integral of 59",
            "Who is the tallest president in U.S. history?",
            "What is 31% of 7812?",
            "This country/pop singer had three songs that appeared on Billboard’s Top 20 songs of 2015; one such title was her top hit, “Bad Blood”"
    };
    private final String[][] ANSWERS = {
            {"8437", "28327", "9121", "8297"},
            {"Vienna", "Washington D.C.", "London", "Stockholm"},
            {"10", "10x^2", "0", "1"},
            {"Tomato", "Sweet Potato", "Cabbage", "Onion"},
            {"39208", "38208", "39508", "35508"},
            {"1914", "1900", "1918", "1939"},
            {"59x", "0", "59", "-59x"},
            {"Abraham Lincoln", "George Washington", "Joe Biden", "Lebron James"},
            {"2421.72", "2343.6", "2,734.2", "2343.2"},
            {"Taylor Swift", "Ariana Grande", "Coldplay", "Metallica"}
    };
    private static final String[] CORRECT_ANSWERS = {
            "8437",
            "Vienna",
            "10",
            "Tomato",
            "39208",
            "1914",
            "59x",
            "Abraham Lincoln",
            "2421.72",
            "Taylor Swift"
    };

    private final int totalQuestions = QUESTIONS.length;

    private Question [] questionArray = new Question[QUESTIONS.length];

    private int currentQuestion = 0;

    private int correctAnswers = 0;

    /**
     * initializes Exam according to the number of questions in the QUESTIONS array
     */
    public Exam()
    {
        for(int i = 0; i < QUESTIONS.length; i++)
        {
            questionArray[i] = new Question(QUESTIONS[i], ANSWERS[i], CORRECT_ANSWERS[i]);
        }
    }

    public int getCorrectAnswers()
    {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void incrementCorrectAnswers()
    {
        correctAnswers++;
    }

    public void resetCorrectAnswers()
    {
        correctAnswers = 0;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public String getQuestion() {
        return QUESTIONS[currentQuestion];
    }


    /**
     * increments currentQuestion if there are more questions in the exam
     * @return true if there are more questions in the exam, false otherwise
     */
    public boolean nextQuestion()
    {
        if(QUESTIONS.length-1 > currentQuestion)
        {
            currentQuestion++;
            return true;
        } else return false;
    }

    /**
     * restarts the exam
     */
    public void retake()
    {
        currentQuestion = 0;
    }

    /**
     * returns 1 out of 4 questions for the question based on answerNumber
     * @param answerNumber the answer number(0-3)
     * @return a string containing one of the answers for the question
     */
    public String getAnswer(int answerNumber)
    {
        if(answerNumber <= 3)
            return questionArray[currentQuestion].getAnswer(answerNumber);
        else return null; // this shouldnt happen so i wont take care of this scenario, just safety measure
    }

    /**
     * checks if answer is the correct answer to the question
     * @param answer - answer to be compared to correctAnswer
     * @return true if answer is the correct answer, false otherwise
     */
    public boolean checkAnswer(String answer)
    {
        return questionArray[currentQuestion].checkAnswer(answer);
    }

    /**
     * shuffles the answers for the current question
     */
    public void shuffle()
    {
        questionArray[currentQuestion].shuffle();
    }
}
