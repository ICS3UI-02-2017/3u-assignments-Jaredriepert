/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class A7 {
    //question 1
    //method for finding the area of a circle using the radius

    public static double circleArea(double radius) {
        //find the answer to radius^2
        double r = Math.pow(radius, 2);
        //find the area
        double area = Math.PI * r;
        return area;
    }

    //question 2
    //method to find grade
    public static void examGrade(double mark) {
        //if the grade is between certain marks send out the respective grade
        if (mark < 50) {
            System.out.println("F");
        } else if (mark > 50 && mark < 60) {
            System.out.println("D");
        } else if (mark >= 60 && mark < 70) {
            System.out.println("C");
        } else if (mark >= 70 && mark < 80) {
            System.out.println("B");
        } else if (mark >= 80) {
            System.out.println("A");
        }
    }

    //question 3
    //method to find all the numbers that go into the number passed in
    public static void factor(int num) {
        //go through every number between 1 and the number given to find if it goes into the number with no remainders
        for (int i = num; i > 0; i--) {
            //if it does go in with no remainders print it out
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }

    //question 4
    //method to find the new balance after an amount of years with a certain intrest rate
    public static double compoundInterest(double p, double r, int n) {
        double amount = (1 + r);
        double b = p * Math.pow(amount, n);
        return b;
    }

    //question 5
    //method to print out random amount of asterisks in a set amount of lines
    public static void asterisks(int lines) {
        //repeat for every line 
        for (int i = 0; i < lines; i++) {
            //create an asterisck for every random numbers
            int randNum = (int) (Math.random() * (5)) + 1;
            for (int j = 0; j < randNum; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    //question 6
    //method to print out the last digit in series of numbers
    public static void lastDigit(int number) {
        int lastdig = number % 10;
        //if the number is negative make it a positive
        if (lastdig < 0) {
            lastdig = lastdig * -1;
        }
        System.out.println(lastdig);
    }

    //question 7
    //method to print out the last digit in series of numbers
    public static void firstDigit(int number) {
        while (number > 9) {
            number = number / 10;
        }
        //if the number is negative make it a positive
        if (number < 0) {
            number = number * -1;
        }
        System.out.println(number);
    }

    //question 8 
    public static boolean allDigitsOdd(int number) {
        //create a different interger that is the last digget in the series of numbers
        int dig = number % 10;
        //check that number if it is odd or not
        while (number > 0) {            
            //if it is even send back that the series of numbers are not odd
            if (dig == 0 || dig == 2 || dig == 4 || dig == 6 || dig == 8) {
                return false;
            } else {
                //if it is odd continue to the next digit
                number = number / 10;
                dig = number % 10;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //question 1
        //send a radius number to find the area of the circle         
        double area = circleArea(5.0);
        System.out.println(area);

        //space between questions
        System.out.println("----------------------");

        //question 2
        //send mark to find out the grade       
        examGrade(81);


        //space between questions
        System.out.println("----------------------");

        //question 3
        //send a number to be factored 
        factor(90);

        //space between questions
        System.out.println("----------------------");

        //question 4
        //send the initial principal, the interest rate, and how many years it has been
        double balance = compoundInterest(500.0, 0.03, 5);
        //take my balance and round it to 2 decimal places
        balance = Math.round(balance * 100);
        balance = balance / 100;
        System.out.println("Your new balance is $" + balance);

        //space between questions
        System.out.println("----------------------");

        //question 5
        //send a set amount of lines to have random astericks on them
        asterisks(5);

        //space between questions
        System.out.println("----------------------");

        //question 6
        //send a number to be picked apart
        lastDigit(567);

        //space between questions
        System.out.println("----------------------");

        //question 7
        //send a number to be picked apart
        firstDigit(384);

        //space between questions
        System.out.println("----------------------");

        //question 8
        //send a number to find out if it is all odd or not
        int num = 87931;
        boolean oddNum = allDigitsOdd(87931);        
        System.out.println(num + " is odd? " + oddNum);





    }
}
