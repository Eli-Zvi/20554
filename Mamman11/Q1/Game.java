/**
 Student Name: Ilay Zvi
 ID: 324125657
 Date: 12/12/2023
 Class Name:Game
 */
import java.util.Scanner;

public class Game {

    private ChosenWord word;

    public Game()
    {
        do {
            word = new ChosenWord();/* initialize a new ChosenWord object to start a game */

            if(word.getWord() == null) { /* if there are no more words in the list, end game */
                System.out.println("No more words in the word list");
                return;
            }
        }
        while(gameLoop() == 1); /* continue playing game until player inputs N after a game is over*/
    }

    public int gameLoop()
    {
        int result; /* stores result of user's input */
        int attempts = 0; /* number of attempts made by users, attempts will be incremented only when a proper attempt is made, meaning that there can only be 26 attempts at most */

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the word guessing game\n" + "Lines will display the number of letters left to guess\n" +
                "Under the lines the letters that have not been guessed yet, will be displayed\n");

        while(true)
        {
            System.out.println(word.getUserGuess()); /* display the user's guess */

            for (int i = 0; i < word.getCharBank().size()-1; i++) {
                System.out.print(word.getCharBank().get(i) + ","); /* display letter bank */
            }
            System.out.println(word.getCharBank().get(word.getCharBank().size()-1)); /* last letter to be displayed */

            result = word.removePickedLetter(keyboard.next().charAt(0)); /* only takes first char in the line */

            if(result == 1)/* a valid attempt was made */
            {
                attempts++; /* a valid attempt was made and the number of attempts will be incremented */
            }
            else if(result == 0) /* illegal input was made, either the letter was picked before or an invalid character was given */
            {
                System.out.println("Illegal input, please try again");
            }
            else { /* the user guessed the word */
                attempts++;

                System.out.println("The word was: " + word.getUserGuess() + "\nNumber of attempts made: " + attempts);

                char answer;

                do {
                    System.out.println("Would u like to play again?(Y\\N)"); /* prompt the user to end the game or play another */
                    answer = keyboard.next().charAt(0);
                }
                while(answer != 'Y' && answer != 'N');

                if(answer == 'Y') /* if the user answers Y(yes) continue the game 1 will be returned which will result in a new game, otherwise 0 will be returned and the program will close */
                    return 1;
                else return 0;
            }
        }
    }
}