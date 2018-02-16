/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import java.util.Random;

/**
 *
 * @author riepj9547
 */
public class A2Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a city
        City town = new City();

        //create a random int
        Random rand = new Random();

        //create buddy somewhere randomly 
        RobotSE buddy = new RobotSE(town, rand.nextInt(25) + 1, rand.nextInt(25) + 1, Direction.EAST);

        //Move buddy West first until he hits Avenue 0
        while (buddy.getAvenue()!= 0) {
            //turn buddy towards the West
            if (buddy.isFacingEast()) {
                buddy.turnLeft(2);
            } else if (buddy.isFacingNorth()) {
                buddy.turnLeft(1);
            } else if (buddy.isFacingSouth()) {
                buddy.turnRight(1);

            }
            buddy.move();
        }
        //Now move buddy North until he hits street 0
        while(buddy.getStreet()!=0&&buddy.getAvenue()==0){
            if(buddy.isFacingWest()){
                buddy.turnRight();
            }
            buddy.move();
        }
        //he is now at 0,0 :)
    }
}

