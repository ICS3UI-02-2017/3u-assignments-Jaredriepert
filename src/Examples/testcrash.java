/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples;

/**
 *
 * @author riepj9547
 */
public class testcrash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double num = 1;
        while (true) {
            num = num * (num);
            System.out.println(num);
            num = num / 3.14159265359;
            System.out.println(num);
            if (num==0.0) {
                num=num/0;
                System.out.println(num);
                num++;
            }
        }
    }
}
