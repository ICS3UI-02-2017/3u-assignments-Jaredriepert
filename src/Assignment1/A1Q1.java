/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //make city
        City town = new City();

        //put robot into city
        RobotSE buddy = new RobotSE(town, 0, 2, Direction.WEST);

        //create walls
        new Wall(town, 1, 1, Direction.NORTH);

        new Wall(town, 1, 1, Direction.WEST);

        new Wall(town, 1, 2, Direction.NORTH);

        new Wall(town, 1, 2, Direction.EAST);

        new Wall(town, 2, 1, Direction.WEST);

        new Wall(town, 2, 1, Direction.SOUTH);

        new Wall(town, 2, 2, Direction.EAST);

        new Wall(town, 2, 2, Direction.SOUTH);

      //make buddy black
        buddy.setColor(Color.black);

        //check if there is a wall, if no wall move forward, if wall turn right and repeat
        for (int i = 0; i < 8; i = i + 1) {
            buddy.move(1);
            buddy.turnLeft(1);
            if (buddy.frontIsClear()) {
                buddy.move(1);
            } else {
                buddy.turnRight(1);
                
            }
        }
        
    }
}
