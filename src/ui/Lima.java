/*
* Lima Encryption Software by Iskra#0332. Project began in December of 2018.
*
* The main class is fairly short at the moment and the ComTree class attemps to handle
* as much of the command line work as possible before being sent to a cipher file.
*
* If you understand the Lima and ComTree class before you jump into a cipher file, it could
* help in understanding a cipher file and why it was made the way it was.
*
*/



package ui;

import java.util.Scanner;
import ciphers.*;

public class Lima {

    public static final Scanner sc = new Scanner(System.in);
    public static boolean invalid = false;

    public static void main(String[] args) {

        boolean welcomeDisplayed = false;
        String choice = "y";

        while (choice.equalsIgnoreCase("y")) {

            if (welcomeDisplayed == true) {
                System.out.print("\n" + "Command: ");
            }
            else {
                Help.welcomeMessage();
                welcomeDisplayed = true;
            }

            String command = sc.nextLine();

            ComTree action = new ComTree(command);

            action.execute();

            if (invalid == true) {
                invalid = false;
                continue;
            }

            System.out.print("\n" + "Would you like to continue? (y/n): ");

            choice = sc.nextLine();
        }

        System.out.println("\n" + "Program terminated.");
        sc.close();
    }
}
