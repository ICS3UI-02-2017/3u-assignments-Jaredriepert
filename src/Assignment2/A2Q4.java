/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;

/**
 *
 * @author riepj9547
 */
public class A2Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a city
        City town = new City();
        
        //create my buddy
        RobotSE buddy = new RobotSE(town, 1, 2, Direction.SOUTH);
        
        //create the castle towers
        new Wall(town, 1, 1, Direction.NORTH);
        new Wall(town, 1, 1, Direction.WEST);
        new Wall(town, 1, 1, Direction.SOUTH);
        new Wall(town, 1, 1, Direction.EAST);
        //create the castle towers
        new Wall(town, 1, 4, Direction.NORTH);
        new Wall(town, 1, 4, Direction.WEST);
        new Wall(town, 1, 4, Direction.SOUTH);
        new Wall(town, 1, 4, Direction.EAST);
        //create the castle towers
        new Wall(town, 4, 1, Direction.NORTH);
        new Wall(town, 4, 1, Direction.WEST);
        new Wall(town, 4, 1, Direction.SOUTH);
        new Wall(town, 4, 1, Direction.EAST);
        //create the castle towers
        new Wall(town, 4, 4, Direction.NORTH);
        new Wall(town, 4, 4, Direction.WEST);
        new Wall(town, 4, 4, Direction.SOUTH);
        new Wall(town, 4, 4, Direction.EAST);
        //create the castle core
        new Wall(town, 2, 2, Direction.NORTH);
        new Wall(town, 2, 2, Direction.WEST);
        new Wall(town, 2, 3, Direction.NORTH);
        new Wall(town, 2, 3, Direction.EAST);
        new Wall(town, 3, 2, Direction.SOUTH);
        new Wall(town, 3, 2, Direction.WEST);
        new Wall(town, 3, 3, Direction.SOUTH);
        new Wall(town, 3, 3, Direction.EAST);
        
        //move buddy around a tower if he sees a wall, repeat
        while(buddy.frontIsClear()==false){
            buddy.turnLeft();
            buddy.move();
            buddy.turnLeft();
            buddy.move();
            buddy.turnRight();
            buddy.move(2);
            buddy.turnRight();
            buddy.move(2);
            buddy.turnRight();
            buddy.move();
        }
    }
}
