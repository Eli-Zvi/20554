/**
 * Student Name: Ilay Zvi
 *  Date: 5/2/2023
 *  Class Name: main
 */

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {

    /**
     * Prompts a user to input a number >= min
     * @param s Scanner instance
     * @param msg - msg to be displayed to user
     * @param min the minimum legal integer input
     * @return user input
     */
    public static int getInput(Scanner s, String msg,int min)
    {
        int temp = 0;
        while(temp < min)
        {
            System.out.println(msg);
            temp = s.nextInt();
        }
        return temp;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        findPrime primes = new findPrime(getInput(keyboard,"Please type in a range(number needs to be bigger than 1)",2));

        ExecutorService exec = Executors.newFixedThreadPool(
                getInput(keyboard,"Please type in the number of threads to be used(number should be bigger than 0)",1));


        while(primes.getCount() < primes.getRange()) { //run until all numbers have been checked
            exec.execute(primes); //start threads
        }
        exec.shutdown(); //shutdown threads

        /*
         print primes
         */
        for(int i = 2; i <= primes.getRange(); i++)
        {
            if(primes.isPrime(i)) {
                System.out.println(i);
            }
        }

    }
}
