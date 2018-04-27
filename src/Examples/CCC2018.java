/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class CCC2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        //get the grid size
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a width value...");
        int x = input.nextInt();
        System.out.println("Please enter a height value...");
        int y = input.nextInt();
        // create array
        int grid[][] = new int[x][y];
        //create the refernce array
        int bufgrid[][] = new int[x][y];
        //create the walls around the grid
        for (int i = 0; i < y; i++) {
            grid[0][i] = 1;
            grid[x - 1][i] = 1;
        }
        for (int i = 0; i < x; i++) {
            grid[i][0] = 1;
            grid[i][y - 1] = 1;
        }

        //choose where to put the starting spot
        int sX = rand.nextInt(x - 2) + 1;
        int sY = rand.nextInt(y - 2) + 1;
        grid[sX][sY] = 7;

        //choose where to put the random Conveyors
        int cons = rand.nextInt(((x - 2) * (y - 2)) / 3) + 1;
        int conX = 0;
        int conY = 0;
        int conType = 0;
        for (int i = 0; i < cons; i++) {
            conType = rand.nextInt(4) + 1;
            conX = rand.nextInt(x - 2) + 1;
            conY = rand.nextInt(y - 2) + 1;
            if (sX != conX && sY != conY) {
                if (conType == 1) {
                    grid[conX][conY] = 3;
                } else if (conType == 2) {
                    grid[conX][conY] = 4;
                } else if (conType == 3) {
                    grid[conX][conY] = 5;
                } else if (conType == 4) {
                    grid[conX][conY] = 6;
                }
            }
        }

        //choose where to put random cameras
        int cams = rand.nextInt(((x - 2) * (y - 2)) / 3) + 1;
        int camX = 0;
        int camY = 0;
        for (int i = 0; i < cams; i++) {
            camX = rand.nextInt(x - 2) + 1;
            camY = rand.nextInt(y - 2) + 1;
            if (sX != camX && sY != camY) {
                grid[camX][camY] = 2;
            }
        }

        //Choose where to put random walls
        int walls = rand.nextInt(((x - 2) * (y - 2)) / 2) + 2;
        int wallX = 0;
        int wallY = 0;
        for (int i = 0; i < walls; i++) {
            wallX = rand.nextInt(x - 2) + 1;
            wallY = rand.nextInt(y - 2) + 1;
            if (sX != wallX && sY != wallY) {
                grid[wallX][wallY] = 1;
            }
        }

        //choose where to put the finish spot
        int fX = rand.nextInt(x - 2) + 1;
        int fY = rand.nextInt(y - 2) + 1;
        grid[fX][fY] = 8;

        //print out the grid 
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[j][i] == 0) {
                    System.out.print(". ");
                } else if (grid[j][i] == 1) {
                    System.out.print("W ");
                } else if (grid[j][i] == 2) {
                    System.out.print("C ");
                } else if (grid[j][i] == 3) {
                    System.out.print("U ");
                } else if (grid[j][i] == 4) {
                    System.out.print("D ");
                } else if (grid[j][i] == 5) {
                    System.out.print("L ");
                } else if (grid[j][i] == 6) {
                    System.out.print("R ");
                } else if (grid[j][i] == 7) {
                    System.out.print("S ");
                } else if (grid[j][i] == 8) {
                    System.out.print("F ");
                }

            }
            System.out.println("\n");
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.println(moveGrid[i][j] + "");
            }
            System.out.println("");
        }
        int targetX = sX;
        int targetY = sY;




    }

    public static int[][] checkspot(int targetX, int targetY, int x, int y) {
        int moves = 0;
        int[][] moveGrid = new int[x][y];
        Point[] selected = new Point[x * y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                moveGrid[i][j] = 999;
            }
        }
        moveGrid[targetX][targetY] = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(moveGrid[i][j] == moves){
                    for(int k = 0; k < 4; k++){
                        if(k==0){
                            targetX = i;
                            targetY = j;
                            
                        }
                    }
                }
            }
        }
        if (i == 1) {
            //if the spot above the starting space is empty check if its possible
            if (grid[targetX][targetY - 1] == 0) {
                targetX = targetX;
                targetY = targetY - 1;
                //if all spots next to this spot is not a camera then it is possible
                if (grid[targetX][targetY - 1] != 2 && grid[targetX - 1][targetY] != 2 && grid[targetX + 1][targetY] != 2) {
                    bufgrid[targetX][targetY] = 1;
                    bufgrid[targetX][targetY] = moves;
                }
            }
        }



        return moveGrid;
    }
}
