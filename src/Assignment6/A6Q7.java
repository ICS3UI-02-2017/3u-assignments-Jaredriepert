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
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array        
        boolean[] numbers = new boolean[1001];
        //set each number as a prime or true for default
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=true;
        }        
        //go through every number that is a multiple of the prime number and make it not a prime or false
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] == true) {
                System.out.println(i+" is a prime");
                for (int n = i; n < numbers.length; n = n + i) {
                    numbers[n] = false;
                }
                //once at the end of all the multiples move onto the next prime number and continue
            }
        }
    }
}