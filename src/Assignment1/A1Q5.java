/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author riepj9547
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City town = new City();

        //put both robots into city
        final RobotSE buddy = new RobotSE(town, 3, 3, Direction.EAST);
        RobotSE dummy = new RobotSE(town,0, 1, Direction.WEST);
        //give robots labels
        buddy.setLabel("B");
        dummy.setLabel("D");
        
        //create walls
        new Wall(town, 2, 3, Direction.WEST);
        new Wall(town, 2, 3, Direction.NORTH);
        new Wall(town, 2, 3, Direction.EAST);
        new Wall(town, 3, 3, Direction.EAST);
        new Wall(town, 3, 3, Direction.SOUTH);
        
        //create things
        new Thing(town, 0, 0);
        new Thing(town, 1, 0);
        new Thing(town, 1, 1);
        new Thing(town, 1, 2);
        new Thing(town, 2, 2);
        //start moving buddy and pick up all objects on the way
        new Thread(){
            public void run(){
                buddy.turnAround();
                buddy.move();
                buddy.turnRight();
                buddy.move();
                buddy.pickThing();
                buddy.move();
                buddy.pickThing();
                buddy.turnLeft();
            }
        }.start();
        //also start moving dummy and pick up all objects on the way
        dummy.move();
        dummy.pickThing();
        dummy.turnLeft();
        dummy.move();
        dummy.pickThing();
        dummy.turnLeft();
        dummy.move();
        dummy.pickThing();
        //all done
    }
}
