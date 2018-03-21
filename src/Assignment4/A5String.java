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
        System.out.println("Enter a text...");
        //take the text to be translated
        String origword = input.nextLine();
        origword = origword.toLowerCase();
        int length = origword.length();
        //the string to check for what is in the tex above
        String vowels = "aeiou";
        //The new string everything will be printed to
        String newWord = "";
        for (int i = 0; i < length; i++) {
            //if the original text contains any of the vowels and there is not a vowel before it
            //even if it is the first letter of the word, print everything up to the vowel into the new text and add "ub"
            if (vowels.indexOf(origword.charAt(i)) != -1) {
                if (i!=0&&vowels.indexOf(origword.charAt(i-1)) == -1) {
                    newWord = newWord + "ub" + origword.charAt(i);
                }else if(i!=0){
                    newWord=newWord+origword.charAt(i);
                }else if(i==0){
                    newWord = newWord + "ub" + origword.charAt(i);
                }
            //If it is not a vowel just print it to the new text
            } else {
                newWord = newWord + origword.charAt(i);
            }
        }
        System.out.println(newWord);
    }
}