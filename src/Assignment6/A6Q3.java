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
            numbers[i]=input.nextInt();
        }
        //check if the first one is bigger or smaller than the second one
        //first create a buffer int
        int replace = 0;
        if (numbers[0]>numbers[1]){
            replace=numbers[1];
            numbers[1]=numbers[0];
            numbers[0]=replace;
            System.out.println("The numbers in ascending order is "+numbers[0]+", "+numbers[1]);
        }
    }
}
