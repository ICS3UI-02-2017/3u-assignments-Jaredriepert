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
    public static void main(String[] args){
    
        Scanner input=new Scanner(System.in);  
        while (true) {    
            System.out.println("Enter regex pattern:"); 
            //what am i looking for?
            Pattern pattern = Pattern.compile(input.nextLine());    
            System.out.println("Enter text:");  
            //where am I looking for it?
            Matcher matcher = pattern.matcher(input.nextLine());    
            boolean found = false;    
            while (matcher.find()) {    
                System.out.println("I found the text "+matcher.group()+" starting at index "+    
                 matcher.start()+" and ending at index "+matcher.end());    
                found = true;    
            }    
            if(!found){    
                System.out.println("No match found.");    
            }    
        }    
    }    
}    


