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
public class Input_OutPut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Hello user, please enter your name:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Welcome "+ name +", how old are you?");
        int age = input.nextInt();
        System.out.println("Okay "+ name +" you are "+ age + " years old.");
        int yearborn = 2018 - age;
        System.out.println("Does this mean you were born in " + yearborn + "?");
        input.nextLine(); //clear out all enter spaces
        String yesNo = input.nextLine().toLowerCase();
        if(yesNo.equals("yes")){
             System.out.println("Okay sweet so you were born in "+ yearborn+ " you are "+age+" years old, and your name is "+name);
        }else{
            System.out.println("Oh okay what is it then?");
            yearborn =input.nextInt();
            System.out.println("Got it, you were born in "+ yearborn+ " you are "+age+" years old, and your name is "+name);
        }
    }
}
