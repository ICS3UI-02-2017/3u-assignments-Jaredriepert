/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[2];
        System.out.println("Please enter the two numbers");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        //check if the first one is bigger or smaller than the second one
        //first create a buffer int
        int replace = 0;
        //go through the array
        for (int i = 0; i < numbers.length; i++) {
            //as long as you are not at the end of the array check to see if the spot is bigger or smaller than the one after it
            if (i < numbers.length - 1) {
                //if it is bigger switch places
                if (numbers[i] > numbers[i + 1]) {
                    replace = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = replace;
                    System.out.println("The numbers in ascending order is " + numbers[0]+", "+numbers[1]);
                    //if it is smaller dont switch places
                } else {
                    System.out.println("The numbers in ascending order is " + numbers[0]+", "+numbers[1] );
                    
                }
            }
        }
    }
}
