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
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array
        Scanner input = new Scanner(System.in);
        System.out.println("How many students are there in your class?");
        int[] marks = new int[input.nextInt()];
        //fill the array with the marks
        System.out.println("Please enter in all their marks");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = input.nextInt();
        }
        //begin sorting for lostest and highest marks
        int x = 0;
        int y = 1;
        int replace = 0;
        //until I have gone through the whole array search trhough it commparing one spot with every other spot
        while (x < marks.length - 1) {
            for (y = x + 1; y < marks.length; y++) {
                if (marks[y] < marks[x]) {
                    replace = marks[x];
                    marks[x] = marks[y];
                    marks[y] = replace;
                }
            }
            x++;
        }
        //find the average mark
        int average = 0;
        for (int i = 0; i < marks.length; i++) {
            average = average + marks[i];
        }       
        average= average/marks.length;
        //display it all nicely 
        System.out.println("The lowest mark of the class is "+marks[0]);
        System.out.println("the highest mark of the class is "+marks[marks.length-1]);
        System.out.println("The average mark was "+average);
    }
}
