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
public class A5String {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a text...");
            //take the text to be translated
            String origword = input.nextLine();
            origword = origword.toLowerCase();
            int length = origword.length();
            //the string to check for what is in the tex above
            String pattern = "aeiou";
            //The new string everything will be printed to
            String newWord = "";
            for (int i = 0; i < length; i++) {
                //if the original text contains any of the vowels and there is not a vowel before it
                //even if it is the first letter of the word, print everything up to the vowel into the new text and add "ub"
                if (pattern.indexOf(origword.charAt(i)) != -1) {
                    if (i != 0 && pattern.indexOf(origword.charAt(i - 1)) == -1) {
                        newWord = newWord + "ub" + origword.charAt(i);
                    } else if (i != 0) {
                        newWord = newWord + origword.charAt(i);
                    } else if (i == 0) {
                        newWord = newWord + "ub" + origword.charAt(i);
                    }
                    //If it is not a vowel just print it to the new text
                } else {
                    newWord = newWord + origword.charAt(i);
                }
            }
            System.out.println(newWord);
            System.out.println("Would you like to translate this back into English?  Yes or No?");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                pattern = "u";
                String pattern2 = "b";
                origword = newWord;
                length = origword.length();
                newWord = "";
                for (int i = 0; i < length; i++) {
                    //if the original text contains any of the vowels and there is not a vowel before it
                    //even if it is the first letter of the word, print everything up to the vowel into the new text and add "ub"
                    if (pattern.indexOf(origword.charAt(i)) != -1) {
                        if ((pattern.indexOf(origword.charAt(i)) != -1) && pattern2.indexOf(origword.charAt(i + 1)) != -1) {
                            i = i + 2;
                            newWord = newWord + origword.charAt(i);
                        } else {
                            newWord = newWord + origword.charAt(i);
                        }

                    }else{
                        newWord = newWord + origword.charAt(i);
                    }
                }
                System.out.println(newWord);
            }
        }

    }
}