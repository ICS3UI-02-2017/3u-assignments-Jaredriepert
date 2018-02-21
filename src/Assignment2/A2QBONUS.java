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

        //create buddy and his friend
        final RobotSE buddy = new RobotSE(town, 0, 2, Direction.SOUTH);
        final RobotSE friend = new RobotSE(town, 0, 2, Direction.SOUTH);

        //create ALL THE WALLS
        Random rand = new Random();

        for (int i = 10; i > 0; i = i - 1) {
            new Wall(town, i - 1, 0, Direction.WEST);
            new Wall(town, i - 1, 1, Direction.EAST);
        }
        new Wall(town, 0, 2, Direction.NORTH);
        new Wall(town, 0, 6, Direction.EAST);
        new Wall(town, 3, 2, Direction.EAST);
        new Wall(town, 5, 2, Direction.EAST);
        new Wall(town, 6, 2, Direction.EAST);
        new Wall(town, 9, 2, Direction.EAST);
        new Wall(town, 9, 2, Direction.SOUTH);

        new Wall(town, 0, 3, Direction.NORTH);
        new Wall(town, 0, 4, Direction.NORTH);
        new Wall(town, 0, 5, Direction.NORTH);
        new Wall(town, 0, 6, Direction.NORTH);

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
        //while buddy is on street, turn left and look for driveway
        //if driveway found go into it, otherwise keep moving down the street looking for a driveway
        new Thread() {
            public void run() {
                while (buddy.getStreet()!=9) {
                    while (friend.frontIsClear()) {
                        if (friend.canPickThing()) {
                            friend.pickAllThings();
                        }
                        friend.move();
                    }
                    if (friend.frontIsClear() == false) {
                        friend.turnAround();
                    }
                }
            }
        }.start();

        while (buddy.getStreet() != 9) {
            while (buddy.getAvenue() == 2) {

                if (buddy.isFacingSouth()) {
                    buddy.turnLeft();
                    if (buddy.canPickThing()) {
                        buddy.pickAllThings();
                    }
                    if (buddy.countThingsInBackpack() > 0) {
                        buddy.putAllThings();
                    }
                    if (buddy.frontIsClear()) {
                        buddy.move(1);

                        //pick everything up if can
                        if (buddy.canPickThing()) {
                            buddy.pickAllThings();
                        }

                    } else if (buddy.isFacingEast() && buddy.getStreet() != 9) {
                        buddy.turnRight();
                        buddy.move(1);
                    }

                    //while buddy is in a driveway go until he hits the end of it picking everything up on the way
                    while (buddy.getAvenue() != 2) {
                        while (buddy.frontIsClear()) {
                            if (buddy.canPickThing()) {
                                buddy.pickAllThings();
                            }
                            buddy.move();

                        }
                        while (buddy.frontIsClear() == false && buddy.getAvenue() != 2) {
                            buddy.turnRight();
                            if (buddy.canPickThing()) {
                                buddy.pickAllThings();
                            }
                            if (buddy.frontIsClear()) {
                                buddy.move();
                                buddy.turnRight();
                                if (buddy.canPickThing()) {
                                    buddy.pickAllThings();
                                }
                            } else {
                                buddy.turnRight();

                            }
                        }
                        //if buddy is at end of drive way move to the left back dow nthe street looking for more driveways
                        while (buddy.frontIsClear() == false && buddy.getAvenue() == 2 && buddy.isFacingWest()) {
                            if (buddy.canPickThing()) {
                                buddy.pickAllThings();
                            }
                            buddy.turnLeft();
                            buddy.move(1);

                        }
                    }
                }
            }
        }

    }
}
