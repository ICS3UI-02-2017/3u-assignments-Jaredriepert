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
    
    //method for finding the area of a circle using the radius
    public static double circleArea(double radius) {
        //find the answer to radius^2
        double r = Math.pow(radius, 2);
        //find the area
        double area = Math.PI * r;
        return area;
    }
    
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
    
    //method to find the new balance after an amount of years with a certain intrest rate
    public static double compoundInterest (double p, double r, int n){
        double amount = (1+r);
        double b = p*Math.pow(amount, n);
        return b;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //send a radius number to find the area of the circle        
        double area = circleArea(5.0);
        System.out.println(area);

        //space between questions
        System.out.println("----------------------");

        //send mark to find out the grade
        examGrade(81);

        //space between questions
        System.out.println("----------------------");

        //send a number to be factored 
        factor(90);
        
        //space between questions
        System.out.println("----------------------");
        
        //send the initial principal, the interest rate, and how many years it has been
        double balance = compoundInterest(500.0, 0.03, 5);
        //take my balance and round it to 2 decimal places
        balance = Math.round(balance*100);
        balance = balance/100;
        System.out.println("Your new balance is $"+ balance);
        
        //space between questions
        System.out.println("----------------------");
        
        
        
    }
}
