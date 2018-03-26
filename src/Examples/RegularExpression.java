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
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Please enter email adress:");
            //what is the text you want to translate?
            CharSequence text = input.nextLine();
            //the regex pattern
            Pattern p = Pattern.compile("[\\w]+(@)[a-z]+[.](com||ca)");
            Matcher m = p.matcher(text);
            //some crazy stuff            
            boolean flag = false;
            //while it finds the regex pattern replace it with "ub" followed up by the pattern it just found
            while (flag = m.find()) {
                String rep = m.group();
                System.out.println("Found valid email adress");;
            }
            if (!m.matches()) {
                System.out.println("Did not find email adress");
            }
        }
    }
}