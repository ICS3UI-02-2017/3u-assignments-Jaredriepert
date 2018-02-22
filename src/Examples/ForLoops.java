/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import java.awt.Color;

/**
 *
 * @author riepj9547
 */
public class ForLoops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City town = new City();
        RobotSE buddy= new RobotSE(town, 1, 1, Direction.EAST);
        
        //cpunted while loop 
        int numberOfMoves = 5;
        
        while(numberOfMoves >0){
            buddy.move();
            numberOfMoves = numberOfMoves -1;
        }
            buddy.turnAround();
            //count the other way
            numberOfMoves = 0;
            while(numberOfMoves<5){
                buddy.move();
                numberOfMoves = numberOfMoves +1;
                
            }
        buddy.turnAround();
        
        //count up with a for loop
        for(int count = 0; count < 5; count++){
            buddy.move();
        }
       int x = 0;
       
       x = x + 5; //add 5
       x += 5; //add 5
       
       x = x - 5; //subtract 5
       x -= 5; //subtract 5
       
       x = x *5; //multiply by 5
       x *=5; //multiply by 5
       
       x = x / 5; //divide by 5
       x /= 5; //divide by 5
       
       //modulus or modulo
       int remainder = 5 % 2;
       
       //compound statments 
       //and
    if(buddy.frontIsClear() && buddy.canPickThing()){
        buddy.setColor(Color.lightGray);
    }
    //or
    if(buddy.frontIsClear() || buddy.canPickThing()){
        buddy.setColor(Color.lightGray);
    }
    }
}
