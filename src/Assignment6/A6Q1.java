/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create an array with the number of students
        Scanner input = new Scanner(System.in);
        System.out.println("How many students are in the class?");
        double[] marks = new double[input.nextInt()];
        //get the marks
        System.out.println("Please enter in the marks");
        //enter the marks into serprate sections
        for (int i = 0; i < marks.length; i++) {
            marks[i]=input.nextDouble();
        }
        double average = 0;
        //add the marks up
        for (int i = 0; i < marks.length; i++) {
            average = average + marks[i];
        }
        //round to 2 decimals
        average = average/marks.length;        
        average = Math.round(average*100);
        average = average/100;
        //print it out
        System.out.println("The class average is "+average +"%");
    }
}
