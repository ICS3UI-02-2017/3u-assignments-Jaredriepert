/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.util.Random;

/**
 *
 * @author riepj9547
 */
public class A2QBONUS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create city
        City town = new City();

        //create buddy
        final RobotSE buddy = new RobotSE(town, 0, 2, Direction.SOUTH);

        //create ALL THE WALLS
        Random rand = new Random();

        for (int i = 10; i > 0; i = i - 1) {
            new Wall(town, i - 1, 0, Direction.WEST);
            new Wall(town, i - 1, 1, Direction.EAST);
        }
        new Wall(town, 0, 2, Direction.EAST);
        new Wall(town, 3, 2, Direction.EAST);
        new Wall(town, 5, 2, Direction.EAST);
        new Wall(town, 6, 2, Direction.EAST);
        new Wall(town, 9, 2, Direction.EAST);
        new Wall(town, 9, 2, Direction.SOUTH);

        new Wall(town, 1, 3, Direction.NORTH);
        new Wall(town, 1, 4, Direction.NORTH);
        new Wall(town, 1, 5, Direction.NORTH);
        new Wall(town, 1, 6, Direction.NORTH);

        new Wall(town, 1, 6, Direction.EAST);
        new Wall(town, 2, 6, Direction.EAST);

        new Wall(town, 2, 3, Direction.SOUTH);
        new Wall(town, 2, 4, Direction.SOUTH);
        new Wall(town, 2, 5, Direction.SOUTH);
        new Wall(town, 2, 6, Direction.SOUTH);

        new Wall(town, 4, 3, Direction.SOUTH);
        new Wall(town, 4, 4, Direction.SOUTH);
        new Wall(town, 4, 5, Direction.SOUTH);

        new Wall(town, 4, 5, Direction.EAST);

        new Wall(town, 4, 3, Direction.NORTH);
        new Wall(town, 4, 4, Direction.NORTH);
        new Wall(town, 4, 5, Direction.NORTH);

        new Wall(town, 7, 3, Direction.NORTH);
        new Wall(town, 7, 4, Direction.NORTH);
        new Wall(town, 7, 5, Direction.NORTH);
        new Wall(town, 7, 6, Direction.NORTH);
        new Wall(town, 7, 7, Direction.NORTH);

        new Wall(town, 7, 7, Direction.EAST);
        new Wall(town, 8, 7, Direction.EAST);

        new Wall(town, 8, 3, Direction.SOUTH);
        new Wall(town, 8, 4, Direction.SOUTH);
        new Wall(town, 8, 5, Direction.SOUTH);
        new Wall(town, 8, 6, Direction.SOUTH);
        new Wall(town, 8, 7, Direction.SOUTH);

        //create random amount of things in random places
        for (int i = 50; i > 0; i = i - 1) {
            new Thing(town, rand.nextInt(9) + 0, rand.nextInt(9) + 0);
        }
//while buddy is on the street look for a driveway, if found a driveway go into it other wise keep looking
       new Thread(){
           public void run() {
           while (buddy.getAvenue() == 2) {
            buddy.turnLeft();
            if (buddy.frontIsClear()) {
                buddy.move();
                if (buddy.canPickThing()) {
                    buddy.pickAllThings();
                }
            } else {
                buddy.turnRight();
                buddy.move();
            }
            while (buddy.countThingsInBackpack() > 0) {
                buddy.putAllThings();
            }
        }
       }
       }.start();

//if buddy is on edge of driveway check if there is another row to go down
        new Thread() {            
            public void run() {
                if (buddy.getAvenue() == 3) {
                    //check which direction he is facing
                    if (buddy.isFacingEast() == false) {
                        buddy.turnLeft();
                        //if there is a nother row go down it
                        if (buddy.frontIsClear()) {
                            buddy.move();
                            buddy.turnLeft();
                            if (buddy.frontIsClear()) {
                                buddy.move();
                                if (buddy.canPickThing()) {
                                    buddy.pickAllThings();
                                }
                            }
                            //if no other row go to sidewalk and get ready to move to the next one
                        } else {
                            buddy.turnRight();
                            buddy.move();
                            buddy.turnLeft();
                        }
                        //if buddy is not leaving drivew way keep going
                    } else {
                        buddy.move();
                    }
                }
            }
        }.start();
//while buddy is in a driveway check if there is a wall infront of him
        new Thread() {
            public void run() {
                while (buddy.getAvenue()!= 2 && buddy.getAvenue() != 3) {
                    //if there is no wall move forward and pick up everything on the way
                    if (buddy.frontIsClear()) {
                        buddy.move();
                        if (buddy.canPickThing()) {
                            buddy.pickAllThings();
                        }
                        //if there is a wall turn right a check if it is clear to move 
                    } else {
                        buddy.turnRight();
                        //if clear move and turn right to go down the next row of the driveway
                        if (buddy.frontIsClear()) {
                            buddy.move();
                            buddy.turnRight();
                            //grab anything thats here before moving
                            if (buddy.canPickThing()) {
                                buddy.pickAllThings();
                            }
                            //as long as buddy is still in driveway move 
                            if (buddy.getAvenue() != 3) {
                                buddy.move();
                                //if buddy can ever pick something up pick it up
                                if (buddy.canPickThing()) {
                                    buddy.pickAllThings();
                                }
                            } else {
                                buddy.turnRight();
                                //if no clear turn right and go back down the way you came
                                while (buddy.getAvenue() != 3) {
                                    buddy.move();
                                }
                            }
                        }
                    }

                }
            }
        }.start();
    }
}
