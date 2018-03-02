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
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //get player 1 and 2's names
        System.out.print("Enter Player 1's name:");
        Scanner input = new Scanner(System.in);
        String p1 = input.nextLine();
        System.out.print("Enter Player 2's name:");
        String p2 = input.nextLine();

        //while it is player ones turn he/she will role the dice
        int turn = 1;
        int p1Spot = 1;
        int p2Spot = 1;
        while (true) {
            while (turn == 1) {
                System.out.print(p1 + " enter dice count: ");
                int diceCount = input.nextInt();
                if (diceCount == 0) {
                    //terminate
                } else if (diceCount == 1 || diceCount > 12) {
                    System.out.print("Invalid number, please try again:");
                    diceCount = input.nextInt();
                } else if (diceCount >= 2 && diceCount <= 12) {
                    p1Spot = p1Spot + diceCount;
                    if(p1Spot==9){
                        p1Spot=34;                        
                    }
                    System.out.println(p1 + " is now on space " + p1Spot);
                    System.out.println(p2 + " is on space " + p2Spot);
                }               
                turn = 2;
            }
            while (turn == 2) {
                System.out.print(p2 + " enter dice count: ");
                int diceCount = input.nextInt();
                if (diceCount == 0) {
                    //terminate
                } else if (diceCount == 1 || diceCount > 12) {
                    System.out.print("Invalid number, please try again:");
                    diceCount = input.nextInt();
                } else if (diceCount >= 2 && diceCount <= 12) {
                    p2Spot = p2Spot + diceCount;
                    System.out.println(p2 + " is now on space " + p2Spot);
                    System.out.println(p1 + " is on space " + p1Spot);
                }
                turn = 1;
            }

        }
    }
}
