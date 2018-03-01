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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask them for the cost of each event and record each answer seperatly 
        System.out.print("How much does the food for prom cost? :");
        
        Scanner input = new Scanner(System.in);
        
        double food = input.nextDouble();
        
        System.out.print("How much does the DJ cost? :");
        
        double dj = input.nextDouble();
        
        System.out.print("How much does it cost to rent the hall? :");
        
        double hall = input.nextDouble();
        
        System.out.print("How much does decorations cost? : ");
        
        double decoration = input.nextDouble();
        
        System.out.print("How much does it cost for staff? :");
        
        double staff = input.nextDouble();
        
        System.out.print("How much for miscellaneous costs? :");
        
        double mis = input.nextDouble();
        
        //print blank line
        System.out.println();
        
        //add up the total cost
        double total = food+dj+hall+decoration+staff+mis;
        
        //tell the user the total cost and how many tickets to sell
        System.out.println("The total cost is $"+total+". You will need to sell "+Math.ceil(total/35)+" to break even.");
    }
}
