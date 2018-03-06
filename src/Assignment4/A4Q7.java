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
        int winner = 0;
        
        while (winner==0) {
            //when it is players one turn let him/her role
            while (turn == 1) {
                System.out.print(p1 + " enter dice count: ");
                int diceCount = input.nextInt();
                if (diceCount == 0) {
                    //terminate
                    System.out.println("You Quit!");
                    System.exit(0);
                }
                if (diceCount == 1 || diceCount > 12) {
                    System.out.print("Invalid number, please try again:");
                    diceCount = input.nextInt();
                }
                if (diceCount >= 2 && diceCount <= 12) {
                    p1Spot = p1Spot + diceCount;
                    //if you land on a latter go up
                    if (p1Spot == 9) {
                        p1Spot = 34;
                        System.out.println("Yay! A ladder!");
                    } else if (p1Spot == 40) {
                        p1Spot = 64;
                        System.out.println("Yay! A ladder!");
                    } else if (p1Spot == 67) {
                        p1Spot = 86;
                        System.out.println("Yay! A ladder!");
                        //if you land on a snake go down
                    } else if (p1Spot == 99) {
                        p1Spot = 77;
                        System.out.println("Oh no! A snake!");
                    } else if (p1Spot == 90) {
                        p1Spot = 48;
                        System.out.println("Oh no! A snake!");
                    } else if (p1Spot == 54) {
                        p1Spot = 19;
                        System.out.println("Oh no! A snake!");
                    } else if (p1Spot > 100) {
                        p1Spot = p1Spot - diceCount;
                        System.out.println("Oops looks like you can't move");
                        //if you are on spot 100 you win
                    }
                    if (p1Spot == 100) {
                        System.out.println(p1 + " Wins! ");
                        System.out.println(p2 + " lost on space " + p2Spot);
                        winner=1;
                    } else {
                        System.out.println(p1 + " is now on space " + p1Spot);
                        System.out.println(p2 + " is on space " + p2Spot);
                        System.out.println("------------------------------");
                        System.out.println("");
                    }
                }
                turn = 2;
            }
            while (turn == 2) {
                System.out.print(p2 + " enter dice count: ");
                int diceCount = input.nextInt();
                if (diceCount == 0) {
                    //terminate
                    System.out.println("You Quit!");
                    System.exit(0);
                }
                if (diceCount == 1 || diceCount > 12) {
                    System.out.print("Invalid number, please try again:");
                    diceCount = input.nextInt();
                }
                if (diceCount >= 2 && diceCount <= 12) {
                    p2Spot = p2Spot + diceCount;
                    //if you land on a ladder go up
                    if (p2Spot == 9) {
                        p2Spot = 34;
                        System.out.println("Yay! A ladder!");
                    } else if (p2Spot == 40) {
                        p2Spot = 64;
                        System.out.println("Yay! A ladder!");
                    } else if (p2Spot == 67) {
                        p2Spot = 86;
                        System.out.println("Yay! A ladder!");
                        //if you land on a snake go down
                    } else if (p2Spot == 99) {
                        p2Spot = 77;
                        System.out.println("Oh no! A snake!");
                    } else if (p2Spot == 90) {
                        p2Spot = 48;
                        System.out.println("Oh no! A snake!");
                    } else if (p2Spot == 54) {
                        p2Spot = 19;
                        System.out.println("Oh no! A snake!");
                    } else if (p2Spot > 100) {
                        p2Spot = p2Spot - diceCount;
                        System.out.println("Oops looks like you can't move");
                        //if they are on spot 100 they win
                    }
                    if (p2Spot == 100) {
                        System.out.println(p2 + " Wins! ");
                        System.out.println(p1 + " lost on space " + p1Spot);
                        winner=1;
                    } else {
                        System.out.println(p2 + " is now on space " + p2Spot);
                        System.out.println(p1 + " is on space " + p1Spot);
                        System.out.println("------------------------------");
                        System.out.println("");
                        
                    }
                }
                turn = 1;
            }

        }
    }
}
