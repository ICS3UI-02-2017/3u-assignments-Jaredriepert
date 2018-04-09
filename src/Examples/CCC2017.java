/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class CCC2017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create arrays
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int[] swifts = new int[input.nextInt()];
        int[] semaphores = new int[swifts.length];
        int num = 0;
        for (int i = 0; i < swifts.length; i++) {
            int chance = rand.nextInt(100) + 0;
            if (chance <= 82) {
                num = rand.nextInt(11) + 0;
            } else {
                num = rand.nextInt(10) + 11;
            }

            swifts[i] = num;
            System.out.print(swifts[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < swifts.length; i++) {
            int chance = rand.nextInt(100) + 0;
            if (chance <= 82) {
                num = rand.nextInt(11) + 0;
            } else {
                num = rand.nextInt(10) + 11;
            }
            semaphores[i] = rand.nextInt(20) + 0;
            System.out.print(semaphores[i] + " ");
        }
        System.out.println();
        int sum1=0;
        int sum2=0;
        for (int i = 0; i < swifts.length; i++) {
            sum1 = sum1+swifts[i];
            sum2 = sum2+semaphores[i];
            if (sum1==sum2) {
                System.out.println("Game "+(i+1)+" they had the same points");
                
            }
        }
    }
}
