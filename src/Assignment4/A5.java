/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class A5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        text.replaceAll("[aeiou]","ub");
        System.out.println(text);
    }
}
