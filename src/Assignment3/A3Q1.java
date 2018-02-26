/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //make city
        City town = new City();

        //put robot into city
        RobotSE buddy = new RobotSE(town, 0, 2, Direction.WEST);

        //create square
        new Wall(town, 1, 1, Direction.NORTH);
        new Wall(town, 1, 1, Direction.WEST);
        new Wall(town, 1, 2, Direction.NORTH);
        new Wall(town, 1, 2, Direction.EAST);
        new Wall(town, 2, 1, Direction.WEST);
        new Wall(town, 2, 1, Direction.SOUTH);
        new Wall(town, 2, 2, Direction.EAST);
        new Wall(town, 2, 2, Direction.SOUTH);
      
        //check if there is a wall, if no wall move forward, if wall turn right and repeat      
        for (int moves = 16; moves > 0; moves -= 1) {
            buddy.move();
            buddy.turnLeft();
            if(buddy.frontIsClear()){
                buddy.move();                
            }else{
                buddy.turnRight();
            }
        }
        
    }
}

