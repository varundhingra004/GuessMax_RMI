/**
 * Classical: UserInterface.java
 *
 * @version   $Id: UserInterface.java,v 1.1 11/11/2015 20:46:36 $
 *
 * @author Varun Dhingra
 */

import java.util.Scanner;


//THIS IS THE VIEW LAYER

public class UserInterface {
    Scanner scan = new Scanner(System.in);

    /**
     * User will give the name and this will be posted to the Control layer
     * @return
     */
    public String getInputFromUser()
    {
        System.out.println("Enter player name");
        String name = scan.nextLine();
        return name;
    }

    /**
     * This function prints the value by first getting it from View layer via Controller
     * @param str
     */
    public void displayResultToUser(String str){
        System.out.println(str);
    }

}
