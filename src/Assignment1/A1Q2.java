/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create city
        City town = new City();

        //put robot into city
        RobotSE buddy = new RobotSE(town, 1, 2, Direction.SOUTH);

        //set colour
        buddy.setColor(Color.black);
        //create walls
        new Wall(town, 1, 1, Direction.NORTH);
        new Wall(town, 1, 1, Direction.WEST);
        new Wall(town, 1, 2, Direction.NORTH);
        new Wall(town, 1, 2, Direction.EAST);
        new Wall(town, 1, 2, Direction.SOUTH);
        new Wall(town, 2, 1, Direction.SOUTH);
        new Wall(town, 2, 1, Direction.WEST);
        //create a newspaper
        new Thing(town, 2, 2); 
        //move buddy outside
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.move();
        buddy.turnLeft();
        buddy.move();
        //pick up newspaper
        buddy.pickThing();
        //return to bed
        buddy.turnAround();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnRight();
        //all done
        }
    
}
