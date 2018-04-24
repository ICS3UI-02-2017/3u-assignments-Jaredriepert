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
public class MethodExample {
    //the hello world method to say hello
    public static void helloWorld(){
        System.out.println("Hello World");
    }
    
    public static void sayHello (String name){
        System.out.println("Hello "+name);
    }
    //calculate the right root (positive)
    public static double[] quadForm(double a, double b, double c){
        double roots[] = new double[2]; 
        double discrim = b*b-4*a*c;
         roots[0] = (-b + Math.sqrt(discrim))/(2*a);
        roots[1] = (-b - Math.sqrt(discrim))/(2*a);
        //send back the root
        return roots;
    }
    
    //calculate the right root (positive)
    public static double posQuadForm(double a, double b, double c){
        
        double[] roots = quadForm(a,b,c);
        //send back the root
        return roots[0];
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //call the helloWorld method
        helloWorld();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name...");
        String name = input.nextLine();
        sayHello(name);
        
        //calculate the positive root of this 
        double pRoot = posQuadForm(1, -5, -50);
        System.out.println("The postive root is "+pRoot);
        double[] roots = quadForm(1, -5, -50);
        System.out.println("The roots are "+roots[0]+ " and at "+ roots[1]);
            
        }
    }

