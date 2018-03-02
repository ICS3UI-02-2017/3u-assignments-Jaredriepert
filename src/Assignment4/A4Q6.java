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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ask for information ab the driver and the road
        System.out.print("Enter the speed limit:");

        Scanner input = new Scanner(System.in);

        int speedLimit = input.nextInt();

        System.out.print("Enter the recorded speed of the car:");

        int speedCar = input.nextInt();

        //depending on how much over or under the speed limit they are going, they will recieve a different message
        if (speedCar < speedLimit) {
            System.out.println("Congratulations, you are driving safe!");
        } else if (speedCar > speedLimit && speedCar < speedLimit + 20) {
            System.out.println("Whoa there you are going a little to fast, you will be charged $100!");
        }else if(speedCar > speedLimit && speedCar < speedLimit + 30){
            System.out.println("Okay now you're going fast! You will be charged $270!");
        }else if(speedCar > speedLimit+30){
            System.out.println("I would say you will be charged $500 for going those speeds but you already passed this sign.");
        }
    }
}
