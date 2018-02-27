/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author riepj9547
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create world
        City town = new City();

        //create buddy
        RobotSE buddy = new RobotSE(town, 3, 3, Direction.SOUTH);

        //create all the walls
        new Wall(town, 1, 1, Direction.NORTH);
        new Wall(town, 1, 1, Direction.WEST);
        new Wall(town, 1, 2, Direction.NORTH);
        new Wall(town, 1, 2, Direction.EAST);
        new Wall(town, 2, 1, Direction.WEST);
        new Wall(town, 2, 1, Direction.SOUTH);
        new Wall(town, 2, 2, Direction.EAST);
        new Wall(town, 2, 2, Direction.SOUTH);

        new Wall(town, 1, 4, Direction.NORTH);
        new Wall(town, 1, 4, Direction.WEST);
        new Wall(town, 1, 5, Direction.NORTH);
        new Wall(town, 1, 5, Direction.EAST);
        new Wall(town, 2, 4, Direction.WEST);
        new Wall(town, 2, 4, Direction.SOUTH);
        new Wall(town, 2, 5, Direction.EAST);
        new Wall(town, 2, 5, Direction.SOUTH);

        new Wall(town, 4, 1, Direction.NORTH);
        new Wall(town, 4, 1, Direction.WEST);
        new Wall(town, 4, 2, Direction.NORTH);
        new Wall(town, 4, 2, Direction.EAST);
        new Wall(town, 5, 1, Direction.WEST);
        new Wall(town, 5, 1, Direction.SOUTH);
        new Wall(town, 5, 2, Direction.EAST);
        new Wall(town, 5, 2, Direction.SOUTH);

        new Wall(town, 4, 4, Direction.NORTH);
        new Wall(town, 4, 4, Direction.WEST);
        new Wall(town, 4, 5, Direction.NORTH);
        new Wall(town, 4, 5, Direction.EAST);
        new Wall(town, 5, 4, Direction.WEST);
        new Wall(town, 5, 4, Direction.SOUTH);
        new Wall(town, 5, 5, Direction.EAST);
        new Wall(town, 5, 5, Direction.SOUTH);

        //move buddy around each square in a pattern that will end him up where he started
        //set up the move counter and the round counter
        int moves = 4;
        //move buddy around a square and remove one from moves once done, only allow him to move around 4 sqaures
        for (moves = moves; moves > 0; moves -= 1) {
            buddy.move(3);
            buddy.turnLeft();
            buddy.move(3);
            buddy.turnLeft();
            buddy.move(3);
            buddy.turnLeft();
            buddy.move(3);
        }
    }
}
