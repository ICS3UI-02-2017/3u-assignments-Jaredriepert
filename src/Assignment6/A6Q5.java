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
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create array
        Scanner input = new Scanner(System.in);
        System.out.println("How many marks are there?");
        int[] marks = new int[input.nextInt()];
        //fill the array with the marks
        System.out.println("Please enter these marks");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = input.nextInt();
        }
        //begin sorting
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
        //print out all the numbers in the new order
        System.out.print("The marks in order are... ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.print("The median of the marks is... ");
        //if the length of the array is even take the two middle numbers and find the average
        if (marks.length % 2 == 0 ) {
            int firstMed = (marks.length) / 2;
            int secondMed = (marks.length / 2) - 1;
            int newMed = (marks[firstMed] + marks[secondMed]) / 2;            
            System.out.println(newMed);
            //if the length is odd just take the middle number
        } else if (marks.length != 2) {
            System.out.print(marks[marks.length / 2]);
            
        }
    }
}
