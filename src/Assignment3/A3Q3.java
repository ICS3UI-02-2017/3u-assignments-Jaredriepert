/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;

/**
 *
 * @author riepj9547
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create city
        City town = new City();

        //create buddy... WITH ITEAMS
        RobotSE buddy = new RobotSE(town, 1, 1, Direction.EAST, 20);

        //create a counter for his row
        int row = 5;
        //while buddy has iteams do the following
        while (buddy.countThingsInBackpack() > 0) {
            //move buddy along his 4 by 5 grid planting his seeds                           
            buddy.putThing();
            buddy.move();
            row -= 1;
            //once buddy has completed a row, move onto the next one
            if (buddy.isFacingWest() && row == 0) {
                buddy.turnLeft();
                buddy.move();
                buddy.turnLeft();
                buddy.move();
                row = 5;
            }
            if (buddy.isFacingEast() && row == 0) {
                buddy.turnRight();
                buddy.move();
                buddy.turnRight();
                buddy.move();
                row = 5;
            }

        }       
    }
}
