/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 12/12/2023
 *  Class Name: main
 */

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        try{

            Scanner keyboard = new Scanner(System.in);
            int powerInput;
            double coefficientInput = 0;
            int polyNumber = 0; //used to indicate which polynomial we are now receiving inputs for

            ArrayList<Integer>[] polyPower = new ArrayList[2];
            ArrayList<Double>[] polyCoefficient = new ArrayList[2];

            for(int i = 0; i < polyPower.length; i++) { //initialize both lists
                polyPower[i] = new ArrayList<>();
                polyCoefficient[i] = new ArrayList<>();
            }

            System.out.println("This program requires you to write two polynomials, after you write the polynomials, the program will print their derivatives and the result of addition and subtraction" +
                    "\nThe power of an element can only be natural numbers\nPlease type in -1 once you're done with the each polynomial\n");

            do {
                System.out.println("Please type in the power");

                powerInput = keyboard.nextInt();

                if(powerInput == -1) {
                    //when indicated that the user is done with a polynomial we check if were done receiving inputs or moving to the second polynomial
                    if(polyNumber == 0)
                    {
                        polyNumber++;
                        continue;
                    }
                    break;
                }
                else if(powerInput < -1)
                {
                    System.out.println("Negatives powers are not allowed, type -1 to finish input");
                    continue;
                }

                polyPower[polyNumber].add(powerInput);

                do {
                    System.out.println("Please type in the coefficient");
                    coefficientInput = keyboard.nextDouble();
                }while(coefficientInput == 0);

                polyCoefficient[polyNumber].add(coefficientInput);

            }while(true);

            Polynom poly = new Polynom(polyPower[0],polyCoefficient[0]);
            Polynom poly1 = new Polynom(polyPower[1],polyCoefficient[1]);

            System.out.println("The first polynomial is: " + poly);
            System.out.println("The second polynomial is: " + poly1);
            System.out.println("The result of addition between the two polynomials is: (" + poly + ") + ("+ poly1 + ") = " + poly.plus(poly1));
            System.out.println("The result of subtraction between the two polynomials is: (" + poly + ") - ("+ poly1 + ") = " + poly.minus(poly1));
            System.out.println("The derivative of polynomial 1 is: " + "(" + poly + ")' = " + poly.derive());
            System.out.println("The derivative of polynomial 2 is: " + "(" + poly1 + ")' = " + poly1.derive());
            System.out.println("The result of comparison between the two polynomials is: " + poly.equals(poly1));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
