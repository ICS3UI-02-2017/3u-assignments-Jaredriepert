/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author riepj9547
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create my city
        City town = new City();

        //turn on thing count
        town.showThingCounts(true);

        //create buddy
        RobotSE buddy = new RobotSE(town, 2, 2, Direction.EAST);

        //create 10 things ontop of buddy
        for (int objects = 10; objects > 0; objects -= 1) {
            new Thing(town, 2, 2);
        }
        //pick up one thing and move it to the right once and move back ecactly 10 times
        for(int turns = 10; turns > 0; turns -= 1){
            buddy.pickThing();
            buddy.move();
            buddy.putThing();
            buddy.turnAround();
            buddy.move();
            buddy.turnAround();
        }
        //once all things have been move finish by moving onto the new pile
        buddy. move();
    }
}
