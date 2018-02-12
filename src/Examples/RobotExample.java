/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *Learning how to use robots
 * @author riepj9547
 */
public class RobotExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Create a City for our robot
        City town = new City();
        
        //put a robot in town
        RobotSE buddy = new RobotSE(town, 2, 3, Direction.EAST);
        
        //create a wall
        new Wall(town, 3, 5, Direction.WEST);
                
        //create a thing
        new Thing(town, 2, 4);
        
        //set colour
        buddy.setColor(Color.black);
                
         
        //move robot forward x space(s)
        while(buddy.frontIsClear()){
        if(buddy.canPickThing())
        {buddy.pickThing();
        }else{
            buddy.move(1);
            }
        }    
    
        
        
        
                          
       }

}
