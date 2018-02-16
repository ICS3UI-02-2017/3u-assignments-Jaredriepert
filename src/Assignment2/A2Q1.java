/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author riepj9547
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a new city
        City town = new City();
        
        //create our robot
        RobotSE buddy = new RobotSE(town, 1, 1, Direction.EAST);
        
        //create 10 things in a row infront of the robot
        for(int i = 0; i < 10; i = i + 1){
        new Thing(town,1, i+2);
    }
        //move buddy forward and pick up only 7 things      
        while(buddy.getAvenue()<12){
            buddy.move();
        while(buddy.canPickThing()&&buddy.countThingsInBackpack()<7){          
           buddy.pickThing();
         }
        }
    }
}
