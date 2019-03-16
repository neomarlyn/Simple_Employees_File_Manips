import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class KeyboardUtils {

    private static Logger logger = LogManager.getLogger(KeyboardUtils.class);

    private Scanner keyboard;

    KeyboardUtils() {
        logger.debug("Inside KeyboardUtils Constructor");
        keyboard = new Scanner(System.in);
    }//why not declare type for keyboard such as Scanner keyboard?


    public int getMainMenu() {
        logger.debug("Inside KeyboardUtils.getMainMenu()");
        int input = 0;
        while (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
            //Only accepts input that is the numbers 1-5
            System.out.println();
            System.out.print("Enter an action: (1) Add Employee, (2) Calc Weekly Pay, (3) Save Employees, (4) Display Employees, (5) Quit: ");
            //Get input
            try {
                input = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                logger.debug("KeyboardUtils.getMainMenu() - Caught Exception: " + e);
                input = 0;
            }
            if(input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
                logger.debug("KeyboardUtils.getMainMenu() - Invalid data supplied");
                System.out.println("Please enter a value between 1 and 5.");
                input = 0;
            }
        }
        return input;
    }

    public String getEmployeeType() {
        logger.debug("Inside KeyboardUtils.getEmployeeType()");
        String input = "";
        while (!input.equals("W") && !input.equals("S") && !input.equals("E")) {
            //Only accepts input that is the numbers 1-5
            System.out.print("Enter the employee type (S/Salary, W/Wage, E/Executive): ");
            //Get input
            input = keyboard.nextLine().toUpperCase();
        }
        return input;
        //Gets employee type, valid entries are E, W, S
    }

    public String getString(String prompt) {
        String input = "";
        while (input.equals("")) {
            System.out.print(prompt);//prompt passed in from method declare
            input = keyboard.nextLine();
        }
        return input;
    }

    public double getDouble(String prompt) {
        double input = -1.0;
        while (input == -1.0) {//what if a wage is actually 0? maybe a silly question  Will accept 0 as a valid number
            System.out.print(prompt);
            try {
                input = Double.parseDouble(keyboard.nextLine());
            } catch (Exception e) {
                input = -1.0;
            }
        }
        return input;
    }

}
