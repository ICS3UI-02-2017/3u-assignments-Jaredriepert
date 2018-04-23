/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Random;

/**
 *
 * @author riepj9547
 */
public class CCC2015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create first array
        Random rand = new Random();
        int[] amount = new int[rand.nextInt(20) + 3];
        int chance = 0;
        //create the numbers and zeros
        for (int i = 0; i < amount.length; i++) {
            amount[i] = rand.nextInt(10) + 1;
            chance = rand.nextInt(4) + 1;
            if ((chance == 2) && (i != 0)) {
                amount[i] = 0;
            }
            System.out.println(amount[i]);
        }
        System.out.println();
        //create new array to transfer the numbers to
        int[] sum = new int[amount.length];
        int x = 0;
        for (int i = 0; i < amount.length; i++) {
            //if the number at spot x is not 0 move it to the sum array and move forward
            if (amount[i] != 0) {
                sum[x] = amount[i];
                x++;
                //if the number is 0 then move back one and set that number to 0
            } else if(x>0){
                x--;
                sum[x] = 0;
            }
        }
        int sumNum = 0;
        //add all the sum numbers together to get the total
        for (int i = 0; i < sum.length; i++) {
            sumNum = sumNum + sum[i];
            System.out.println(sum[i]);
        }
        System.out.println("The sum of these numbers are...");
        System.out.println(sumNum);
    }
}
