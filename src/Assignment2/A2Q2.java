/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.util.Random;

/**
 *
 * @author riepj9547
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create city
        City town = new City();

        //create buddy
        RobotSE buddy = new RobotSE(town, 1, 1, Direction.EAST);

        //create a random int
        Random rand = new Random();
        //create the race, first make the floor, then make a wall but only as many as can fit in the track

        for (int i = rand.nextInt(10) + 5; i > 0; i = i - 1) {
            new Wall(town, 1, i, Direction.SOUTH);
            if (rand.nextInt(3) + 1 == 1) {
                new Wall(town, 1, i, Direction.EAST);
            }
        }

    }
}
