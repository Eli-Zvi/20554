/**
 Student Name: Ilay Zvi
 ID: 324125657
 Date: 12/12/2023
 Class Name:ChosenWord
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChosenWord {

    /**
    chosenWord stores a word from WordBank
    userGuess stores the user's progress of guessing the word
    charBank stores the list of letters that were not guessed
    matches stores the number of letters that were matched in the word
     */
    private String chosenWord;
    private char[] userGuess;
    private ArrayList<Character> charBank = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
    private int matches;

    /**
     * initialize chosenWord and userGuess, initialize object of type ChosenWord
     */
    public ChosenWord()
    {
        chosenWord = WordBank.getWord();

        if(chosenWord == null) /* if there are no words left in the word bank, the program will close */
            return;

        userGuess = new char[chosenWord.length()]; /* initialize the user's guess to be a string of '_' */
        for (int i = 0; i < chosenWord.length(); i++)
            userGuess[i] = '_';

        matches = 0;
    }

    public String getWord()
    {
        if(chosenWord != null)
         return new String(chosenWord);
        return null;
    }

    public String getUserGuess()
    {
        return new String(userGuess);
    }

    public List<Character> getCharBank()
    {
        return charBank;
    }

    public int getMatches()
    {
        return matches;
    }

    /**
     * Checks if the letter picked by user is present in the word, replaces the letter in every position with a '_'
     @param letter guessed letter by user
     @return 0 when the letter has been picked in a previous attempt, 1 when the first attempt is made
     */
    public int removePickedLetter(char letter)
    {
        if(!charBank.remove(new Character(letter))) /* check if the letter is present in the list */
            return 0;  // letter was already removed before

        for(int i = 0; i < chosenWord.length(); i++) /* search for all places where the letter is present in the word */
        {
            if(chosenWord.charAt(i) == letter)
            {
                userGuess[i] = letter;
                matches++;
            }
        }

        if(matches == chosenWord.length()) /* if the number of matches is equal to the length of the word, the word has been found */
            return 2; // game is over

        return 1; //valid guess was made
    }
}
