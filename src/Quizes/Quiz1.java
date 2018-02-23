/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Quizes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author riepj9547
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create my city
        City town = new City();

        //create my robot
        RobotSE buddy = new RobotSE(town, 4, 0, Direction.EAST);

        //create the staircase
        new Wall(town, 4, 2, Direction.WEST);
        new Wall(town, 4, 2, Direction.NORTH);
        new Wall(town, 3, 3, Direction.WEST);
        new Wall(town, 3, 3, Direction.NORTH);
        new Wall(town, 2, 4, Direction.WEST);
        new Wall(town, 2, 4, Direction.NORTH);

        new Wall(town, 4, 7, Direction.EAST);
        new Wall(town, 4, 7, Direction.NORTH);
        new Wall(town, 3, 6, Direction.EAST);
        new Wall(town, 3, 6, Direction.NORTH);
        new Wall(town, 2, 5, Direction.EAST);
        new Wall(town, 2, 5, Direction.NORTH);

        //create the lights (on the wrong side of course)
        new Thing(town, 4, 1);
        new Thing(town, 3, 2);
        new Thing(town, 2, 3);
        new Thing(town, 1, 4);

        //move buddy up the stairs picking all the lights up on the way and stop once he is at the top
        while (buddy.frontIsClear()&&buddy.getAvenue()<5) {
            buddy.move();
            if (buddy.canPickThing()) {
                buddy.pickAllThings();
            }
            if (buddy.frontIsClear() == false) {
                buddy.turnLeft();
                buddy.move();
                buddy.turnRight();
            }

        }
        //buddy is at the top of the stairs, now go down placing one light on every step
        buddy.putThing();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.putThing();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.putThing();
        buddy.move();
        buddy.turnRight();
        buddy.move();
        buddy.turnLeft();
        buddy.putThing();
        buddy.move();
        
        //buddy has now moved all the lights
    }
}
