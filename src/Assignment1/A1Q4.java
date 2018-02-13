/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Wall;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         //make city
        City town = new City();

        //put both robots into city
        final RobotSE buddy = new RobotSE(town, 0, 0, Direction.SOUTH);
        RobotSE dummy = new RobotSE(town,0, 1, Direction.SOUTH);

        //create walls
        new Wall(town, 0, 1, Direction.WEST);
        new Wall(town, 1, 1, Direction.WEST);
        new Wall(town, 1, 1, Direction.SOUTH);
        //start moving buddy 
        new Thread(){
            public void run(){
                buddy.move(1);
                buddy.move();
                buddy.turnLeft();
                buddy.move();
            }
        }.start();
        //now also move dummy
        dummy.move(1);
        dummy.turnLeft();
        dummy.move();
        dummy.turnRight();
        dummy.move();
        dummy.turnRight();
        dummy.move();
        //all done
            
    }
}
