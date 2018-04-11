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
        int[] amount = new int[rand.nextInt(20)+3];
        int chance = 0;
        //create the numbers and zeros
        for (int i = 0; i < amount.length; i++) {
            amount[i]=rand.nextInt(10)+1;
            chance = rand.nextInt(4)+1;
            if (chance == 2) {
                amount[i]=0;
            }
            System.out.println(amount[i]);
        }
        System.out.println("The sum of these numbers are...");
        //create new array to transfer the numbers to
        int[] sum = new int[amount.length];
        for (int i = 0; i < amount.length; i++) {
            if (amount[i]!=0) {
                sum[i]=amount[i];
            }else if ((amount[i]==0)&&(i!=0)){
                sum[i]=0;
                for (int n = i-1; n > 0; n--) {
                    if (amount[n]!=0) {
                       sum[i-n]=0;
                        System.out.println();
                       break;
                    }
                }                
            }            
        }
        int sumNum = 0;
        for (int i = 0; i < sum.length; i++) {
             sumNum= sumNum +sum[i];
        }
        System.out.println(sumNum);
    }
}
