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
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask for their measurement
        System.out.print("Hello user please enter your measurement in inches:");

        //record their answer
        Scanner input = new Scanner(System.in);

        double inches = input.nextDouble();

        while (true) {
            //convert to cm
            double cm = inches * 2.54;

            System.out.println(inches + " is the same as " + cm + " cm");

            //ask them if they want to do it again
            System.out.print("You may enter another conversion:");

            inches = input.nextDouble();
        }

    }
}
