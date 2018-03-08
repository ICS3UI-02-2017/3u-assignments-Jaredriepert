/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author riepj9547
 */
public class RegularExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
//            System.out.println("Enter regex pattern:"); 
            //what am i looking for?
            Pattern pattern = Pattern.compile("[aeiou]");
            System.out.println("");
            System.out.println("Enter text:");

            String word = input.nextLine();
            //where am I looking for it?
            Matcher matcher = pattern.matcher(word);
            boolean found = false;
            while (matcher.find()) {
                System.out.println("starting at "
                        + matcher.start() + " and ending at index " + matcher.end());
                System.out.println(word.replaceAll(matcher.group(), "ub" + matcher.group()));
                found = true;
            }
            if (!found) {
                System.out.println("No match found.");
            }
        }
    }
}
