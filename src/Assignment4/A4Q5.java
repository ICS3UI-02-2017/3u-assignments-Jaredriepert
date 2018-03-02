/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask fo name
        System.out.print("Please enter your name:");
        //record name
        Scanner input = new Scanner(System.in);
        
        String name = input.nextLine();
        
        System.out.print("What was the first test out of? :");
        
        double test1Out = input.nextDouble();
        
        System.out.print("What mark did you get? :");
        
        double test1In = input.nextDouble();
        
        System.out.print("What was the second test out of? :");
        
        double test2Out = input.nextDouble();
        
        System.out.print("What mark did you get? :");
        
        double test2In = input.nextDouble();
        
        System.out.print("What was the third test out of? :");
        
        double test3Out = input.nextDouble();
        
        System.out.print("What mark did you get? :");
        
        double test3In = input.nextDouble();
        
        System.out.print("What was the fourth test out of? :");
        
        double test4Out = input.nextDouble();
        
        System.out.print("What mark did you get? :");
        
        double test4In = input.nextDouble();
        
        System.out.print("What was the fith test out of? :");
        
        double test5Out = input.nextDouble();
        
        System.out.print("What mark did you get? :");
        
        double test5In = input.nextDouble();
        
        //blank line
        System.out.println();
        System.out.println("Test scores for "+name);
        
        //blank line
        System.out.println();
        //determin each test percentage and round it to 2 decimal places        
        double mark1=(test1In/test1Out*100);
        mark1 = mark1*100;
        mark1 = Math.round(mark1);
        mark1 = mark1/100;
        
        double mark2=(test2In/test2Out*100);
        mark2 = mark2*100;
        mark2 = Math.round(mark2);
        mark2 = mark2/100;
        
        double mark3=(test3In/test3Out*100);
        mark3 = mark3*100;
        mark3 = Math.round(mark3);
        mark3 = mark3/100;
        
        double mark4=(test4In/test4Out*100);
        mark4 = mark4*100;
        mark4 = Math.round(mark4);
        mark4 = mark4/100;
        
        double mark5=(test5In/test5Out*100);
        mark5 = mark5*100;
        mark5 = Math.round(mark5);
        mark5 = mark5/100;
        
        //present the test marks 
        System.out.println("Test 1: " +mark1+"%");
        System.out.println("Test 2: " +mark2+"%");
        System.out.println("Test 3: " +mark3+"%");
        System.out.println("Test 4: " +mark4+"%");
        System.out.println("Test 5: " +mark5+"%");
        
        //blank line
        System.out.println();
        
        System.out.println("Average: "+(mark1+mark2+mark3+mark4+mark5)/5+"%");
    }
}
