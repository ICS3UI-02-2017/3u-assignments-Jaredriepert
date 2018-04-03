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
public class A6Q2 {

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        // create array
        Scanner input = new Scanner(System.in);
        System.out.println("How many people are you measuring?");
        int[] height = new int[input.nextInt()];
        //record the heights
        System.out.println("Please enter the heights in centimeters");
        for (int i = 0; i < height.length; i++) {
            height[i]=input.nextInt();
        }
        //find the average
        int average = 0;
        for (int i = 0; i < height.length; i++) {
            average = average +height[i];
        }
        average = average/ height.length;
        //go through to find if the height is above average or not
        
        for (int i = 0; i < height.length; i++) {
            //if it above average tell them
            if (height[i]>average) {
                System.out.println("Person "+height[i]+" is above average");
                //if it is not also tell them
            }else{
                System.out.println("Person "+height[i]+" is not above average");
            }
        }
    }
}
