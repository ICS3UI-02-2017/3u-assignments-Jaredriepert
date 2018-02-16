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
        RobotSE buddy = new RobotSE(town, 0, 2, Direction.SOUTH);
        
        //create ALL THE WALLS
        Random rand = new Random();
        
        for(int i = 10; i > 0; i = i - 1){
            new Wall(town, i-1, 0, Direction.WEST);
            new Wall(town, i-1, 1, Direction.EAST);
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
        new Thing(town, rand.nextInt(15) + 0, rand.nextInt(15) + 0);
       
    }
}
