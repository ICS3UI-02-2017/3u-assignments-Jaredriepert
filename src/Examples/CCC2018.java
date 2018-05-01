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
        int moveGrid[][] = new int[x][y];
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
            System.out.println("");
        }
// set all possible move spots to infinit (999)
        int moves = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[j][i] == 0) {
                    moveGrid[j][i] = 999;
                } else {
                    moveGrid[j][i] = -1;
                }
            }
        }
        //set the starting spot at 0 moves
        moveGrid[sX][sY] = 0;
        //call the checkspot function
        moveGrid = checkspot(moveGrid, grid, x, y, 0);

        //print out the move grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(moveGrid[j][i] + " ");
            }
            System.out.println("");
        }

//print out the 3rd grid 
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[j][i] == 0) {
                    if(moveGrid[j][i]<999){
                        System.out.print(moveGrid[j][i]+" ");
                    }else{
                        System.out.print(". ");
                    }
                       
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
            System.out.println("");
        }
    }

    public static int[][] checkspot(int[][] moveGrid, int[][] grid, int x, int y, int moves) {

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (moveGrid[j][i] == moves) {
                    for (int k = 0; k < 4; k++) {
                        if (k == 0) {
                            if (grid[j][i - 1] == 0 && grid[j][i - 2] != 2 && grid[j - 1][i - 1] != 2 && grid[j + 1][i - 1] != 2) {
                                if (moveGrid[j][i - 1] > moves + 1) {
                                    moveGrid[j][i - 1] = moveGrid[j][i] + 1;
                                    
                                }
                            }
                            if (grid[j][i-1]==3 && grid[j][i - 2] != 2 && grid[j - 1][i - 1] != 2 && grid[j + 1][i - 1] != 2){
                                moveGrid[j][i - 2] = moveGrid[j][i] + 1;
                            }
                            if (grid[j][i-1]==4 && grid[j][i - 2] != 2 && grid[j - 1][i - 1] != 2 && grid[j + 1][i - 1] != 2){
                                moveGrid[j][i] = moveGrid[j][i] + 1;
                            }
                            if (grid[j][i-1]==5 && grid[j][i - 2] != 2 && grid[j - 1][i - 1] != 2 && grid[j + 1][i - 1] != 2){
                                moveGrid[j-1][i - 1] = moveGrid[j][i + 1];
                            }
                            if (grid[j][i-1]==6 && grid[j][i - 2] != 2 && grid[j - 1][i - 1] != 2 && grid[j + 1][i - 1] != 2){
                                moveGrid[j+1][i - 1] = moveGrid[j][i] + 1;
                            }
                        }
                        if (k == 1) {
                            if (grid[j + 1][i] == 0 && grid[j + 2][i] != 2 && grid[j + 1][i - 1] != 2 && grid[j + 1][i + 1] != 2) {
                                if (moveGrid[j + 1][i] > moves + 1) {
                                    moveGrid[j + 1][i] = moveGrid[j][i] + 1;
                                    
                                }
                            }
                            if (grid[j + 1][i] == 3 && grid[j + 2][i] != 2 && grid[j + 1][i - 1] != 2 && grid[j + 1][i + 1] != 2) {
                                moveGrid[j + 1][i-1] = moveGrid[j][i] + 1;
                            }
                            if (grid[j + 1][i] == 4 && grid[j + 2][i] != 2 && grid[j + 1][i - 1] != 2 && grid[j + 1][i + 1] != 2) {
                                moveGrid[j + 1][i+1] = moveGrid[j][i] + 1;
                            }
                            if (grid[j + 1][i] == 5 && grid[j + 2][i] != 2 && grid[j + 1][i - 1] != 2 && grid[j + 1][i + 1] != 2) {
                                moveGrid[j ][i] = moveGrid[j][i] + 1;
                            }
                            if (grid[j + 1][i] == 6 && grid[j + 2][i] != 2 && grid[j + 1][i - 1] != 2 && grid[j + 1][i + 1] != 2) {
                                moveGrid[j + 2][i] = moveGrid[j][i] + 1;
                            }
                        }
                        if (k == 2) {
                            if (grid[j][i + 1] == 0 && grid[j][i + 2] != 2 && grid[j + 1][i + 1] != 2 && grid[j - 1][i + 1] != 2) {
                                if (moveGrid[j][i + 1] > moves + 1) {
                                    moveGrid[j][i + 1] = moveGrid[j][i] + 1;
                                    
                                }
                            }
                            if (grid[j][i + 1] == 3 && grid[j][i + 2] != 2 && grid[j + 1][i + 1] != 2 && grid[j - 1][i + 1] != 2) {
                                moveGrid[j][i] = moveGrid[j][i] + 1;
                            }
                            if (grid[j][i + 1] == 4 && grid[j][i + 2] != 2 && grid[j + 1][i + 1] != 2 && grid[j - 1][i + 1] != 2) {
                                moveGrid[j][i + 2] = moveGrid[j][i] + 1;
                            }
                            if (grid[j][i + 1] == 5 && grid[j][i + 2] != 2 && grid[j + 1][i + 1] != 2 && grid[j - 1][i + 1] != 2) {
                                moveGrid[j-1][i + 1] = moveGrid[j][i] + 1;
                            }
                            if (grid[j][i + 1] == 6 && grid[j][i + 2] != 2 && grid[j + 1][i + 1] != 2 && grid[j - 1][i + 1] != 2) {
                                moveGrid[j+1][i + 1] = moveGrid[j][i] + 1;
                            }
                        }
                        if (k == 3) {
                            if (grid[j - 1][i] == 0 && grid[j - 2][i] != 2 && grid[j - 1][i + 1] != 2 && grid[j - 1][i - 1] != 2) {
                                if (moveGrid[j - 1][i] > moves + 1) {
                                    moveGrid[j - 1][i] = moveGrid[j][i] + 1;
                                    
                                }
                            }
                            if (grid[j - 1][i] == 3 && grid[j - 2][i] != 2 && grid[j - 1][i + 1] != 2 && grid[j - 1][i - 1] != 2) {
                                moveGrid[j - 1][i-1] = moveGrid[j][i] + 1;
                            }
                            if (grid[j - 1][i] == 4 && grid[j - 2][i] != 2 && grid[j - 1][i + 1] != 2 && grid[j - 1][i - 1] != 2) {
                                moveGrid[j - 1][i+1] = moveGrid[j][i] + 1;
                            }
                            if (grid[j - 1][i] == 5 && grid[j - 2][i] != 2 && grid[j - 1][i + 1] != 2 && grid[j - 1][i - 1] != 2) {
                                moveGrid[j - 2][i] = moveGrid[j][i] + 1;
                            }
                            if (grid[j - 1][i] == 6 && grid[j - 2][i] != 2 && grid[j - 1][i + 1] != 2 && grid[j - 1][i - 1] != 2) {
                                moveGrid[j][i] = moveGrid[j][i] + 1;
                            }
                        }
                    }
                }
                
            }
            
        }
        if(moves<x*y){
            
            moveGrid = checkspot(moveGrid, grid, x, y, ++moves);
        }
        
        return moveGrid;
    }
}
