/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

import java.util.Scanner;

/**
 *
 * @author riepj9547
 */
public class StringStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text...");
        String origword = input.nextLine();
        int length = origword.length();
        String vowels = "aeiou";
        String newWord = "";
        for (int i = 0; i < length; i++) {
            if (vowels.indexOf(origword.charAt(i)) != -1) {
                if (i!=0&&vowels.indexOf(origword.charAt(i-1)) == -1) {
                    newWord = newWord + "ub" + origword.charAt(i);
                }else if(i!=0){
                    newWord=newWord+origword.charAt(i);
                }else if(i==0){
                    newWord = newWord + "ub" + origword.charAt(i);
                }

            } else {
                newWord = newWord + origword.charAt(i);
            }
        }
        System.out.println(newWord);
    }
}
