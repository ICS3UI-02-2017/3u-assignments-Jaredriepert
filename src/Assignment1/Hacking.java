/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import java.util.Random;

/**
 *
 * @author riepj9547
 */
public class Hacking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create a city
        City town = new City();
        //create a robot
        RobotSE buddy = new RobotSE(town, 0, 0, Direction.SOUTH);
        //create a random something
        Random rand = new Random();
            //create a random number of things at a random spot
        for(int i=rand.nextInt(10)+1; i>0; i=i-1){
    Thing rock = new Thing(town, rand.nextInt(10) + 1, rand.nextInt(10) + 1);
        }
    }
}
