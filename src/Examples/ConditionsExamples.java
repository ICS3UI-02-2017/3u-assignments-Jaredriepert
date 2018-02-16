/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class ConditionsExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //create a city
        City town = new City();
        
        //create a robot
        RobotSE buddy = new RobotSE(town, 2, 1, Direction.EAST);
        
        //create a wall
        new Wall(town, 2, 5, Direction.EAST);
        new Wall(town, 2, 0, Direction.WEST);
        
        //create things
        new Thing(town, 2, 2);
        new Thing(town, 2, 4);
        
        //move while the front is clear
        while(buddy.frontIsClear()){
            //if front is clear move buddy
            buddy.move();        
            //check for things to pick up
            if(buddy.canPickThing()){
                //if there is a thing pick it up
                buddy.pickThing();
            }
            if(buddy.countThingsInBackpack()>2&&buddy.countThingsInBackpack()<5){
            buddy.setColor(Color.black);
        }else if(buddy.countThingsInBackpack()>4){
            buddy.setColor(Color.yellow);
          
        }
            while(!buddy.frontIsClear()){
                 //if front is not clear turn right
        buddy.turnAround();
        new Thing(town, 2, 2);
        new Thing(town, 2, 4);
            }
        }
       
        
        
            
        }
        
        
    }
    

