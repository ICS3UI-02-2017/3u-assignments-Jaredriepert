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
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask the user for their name
        System.out.println("Please enter your name...");
        
        Scanner input = new Scanner(System.in);
        
        //record their answer
        String name = input.nextLine();
        
        //greet them 
        System.out.println("Hello "+name+", how are you today?");
    }
}
