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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask for 4 numbers
        System.out.println("Please enter 4 numbers on seperate lines...");
        
        //record their answer
        Scanner input = new Scanner(System.in);
        
        double number1 = input.nextDouble();
        
                
        double number2 = input.nextDouble();
                
        
        double number3 = input.nextDouble();
                
        
        double number4 = input.nextDouble();
        
        System.out.println("Okay so your numbers were "+number1+ ", "+number2+", "+number3+" and "+number4);
        
    }
}
