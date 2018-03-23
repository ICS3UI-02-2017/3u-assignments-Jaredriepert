/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author riepj9547
 */
public class A5Regex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Please enter text to be translated:");
            //what is the text you want to translate?
            CharSequence text = input.nextLine();
            //the regex pattern
            Pattern p = Pattern.compile("(?i)[aeiou]+");
            Matcher m = p.matcher(text);
            //some crazy stuff
            StringBuffer bufStr = new StringBuffer();
            boolean flag = false;
            //while it finds the regex pattern replace it with "ub" followed up by the pattern it just found
            while (flag = m.find()) {
                String rep = m.group();
                m.appendReplacement(bufStr, "ub" + m.group());
            }
            m.appendTail(bufStr);
            String result = bufStr.toString();
            System.out.println(result);
            System.out.println("Would you like to translate it back to English?  Yes or No?");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                text = result;
                p = Pattern.compile("ub([aieou])");
                m = p.matcher(text);
                bufStr = new StringBuffer();
                flag = false;
                while (flag = m.find()) {
                    String rep = m.group();
                    m.appendReplacement(bufStr, "" + m.group(1));
                }
                m.appendTail(bufStr);
                result = bufStr.toString();
                System.out.println(result);
            }
        }

    }
}