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
        
        System.out.println("Test 1: " +test1In/test1Out*100+"%");
        System.out.println("Test 2: " +test2In/test2Out*100+"%");
        System.out.println("Test 3: " +test3In/test3Out*100+"%");
        System.out.println("Test 4: " +test4In/test4Out*100+"%");
        System.out.println("Test 5: " +test5In/test5Out*100+"%");
        
        //blank line
        System.out.println();
        
        System.out.println("Average: "+(test1In+test2In+test3In+test4In+test5In)/(test1Out+test2Out+test3Out+test4Out+test5Out)*100+"%");
    }
}
