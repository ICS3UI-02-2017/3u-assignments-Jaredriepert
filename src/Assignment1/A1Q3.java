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
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create city
                City town = new City();

        //put robot into city
        RobotSE buddy = new RobotSE(town, 3, 0, Direction.EAST);

        //set colour
        buddy.setColor(Color.black);
        //create walls
        new Wall(town, 3, 2, Direction.NORTH);
        new Wall(town, 3, 2, Direction.WEST);
        new Wall(town, 2, 3, Direction.WEST);
        new Wall(town, 1, 3, Direction.WEST);
        new Wall(town, 1, 3, Direction.NORTH);
        new Wall(town, 1, 3, Direction.EAST);
        new Wall(town, 2, 4, Direction.NORTH);
        new Wall(town, 2, 4, Direction.EAST);
        new Wall(town, 3, 4, Direction.EAST);
        
        //create flag
        new Thing(town, 3, 1);
        //move buddy to flag
        buddy.move();
        //pick up flag
        buddy.pickThing();
        //move buddy up hill
        buddy.turnLeft();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.move(2);
        buddy.turnRight();
        buddy.move();
        //drop falg at top of mountain
        buddy.putThing();
        //move buddy down the mountain the other way
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.move();
        buddy.turnRight();
        buddy.move(2);
        buddy.turnLeft();
        //all done
    }
}
