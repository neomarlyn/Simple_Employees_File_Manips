import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    private static Logger logger = LogManager.getLogger(EmployeeManager.class);

    //private static Logger logger = LogManager.getLogger(EmployeeManager.class);
    private static String DEFAULT_FILE = "employee_list.txt";
    private Scanner fin;//never used
    private Scanner cin;//never used
    private String filename;
    private ArrayList<Employee> employees;

    private String employeeType;
    private String firstName;
    private String lastName;
    private double wage;
    KeyboardUtils kb = new KeyboardUtils();//kb is the identifier of the object of class keyboardutils, wherein
    //there is a scanner object called keyboard



    EmployeeManager() throws IOException {//why the redundant constructors?
        employees = new ArrayList<Employee>();//Employee already cast to elements in arraylist
        filename = DEFAULT_FILE;
        readEmployeesFromFile();
    }

    EmployeeManager(String infile) throws IOException {
        logger.debug("EmployeeManager constructor ");
        employees = new ArrayList<Employee>();
        filename = infile;//because this is a constructor, infile is passed in object declaration
        readEmployeesFromFile();
    }

    public void run() throws FileNotFoundException {
        //Calls on keyboard utils to get input
        //Then switch statements to the appropriate option
        processMenu();//can we do a try-catch here to use exception?
    }

    private void displayEmployees() {
        System.out.println();
        for (Employee j : employees) {
            j.display();
        }

    }

    private void processMenu() {
        //System.out.print("Enter an action: (1) Add Employee, (2) Calc Weekly Pay, (3) Save Employees, (4) Display Employees, (5) Quit: ");
        logger.debug("EmployeeManager.processMenu");
        int menuOption = 4;
        while (menuOption != 5)
        {
            switch (menuOption) {
                case 1:
                    //Add Employee
                    promptForEmployeeInfo();
                    break;
                case 2:
                    // Calc Weekly Pay
                    calcEmployeePay();
                    break;
                case 3:
                    //Save Employees to file
                    try {
                        saveEmployeesToFile();
                    } catch (IOException e) {
                        System.out.println("Error writing to file");
                    }
                    break;
                case 4:
                    displayEmployees();
                    break;
                    //default to 5?
                //default:
                    //System.out.println("Please enter a value between 1 and 5.");
            }
            menuOption = kb.getMainMenu();//kb is a keyboardutils object, wherein there is keyboard which is a scanning object
        }
    }
    //should the following be in keyboardutils?
    private void calcEmployeePay() {
        logger.debug("EmployeeManager.calcEmployeePay");
        promptForHoursPayInfo();
        displayEmployeePay();

    }
    private void displayEmployeePay() {
        logger.debug("EmployeeManager.displayEmployeePay");
        System.out.println();
        System.out.println("Employee weekly pay: ");
        for (Employee e : employees) {
            System.out.println("Weekly pay for " + e.getFullName() + ": " + String.format("%.2f", e.getWeeklyPay()));
        }
        System.out.println();
    }

    private void promptForHoursPayInfo() {
        logger.debug("EmployeeManager.promptForHoursPayInfo");
        //Loops through the employees array list and prompts user to enter hours worked.
        System.out.println("Enter Weekly Hours for Employees: ");
        for (Employee e : employees) {
            e.display();//will this display all info in employees? seems to display the tostring in employee
            //which would also display wage?
            double hoursWorked = kb.getDouble("Enter weekly hours for " + e.getFullName() + ": ");
            e.setHoursWorked(hoursWorked);
        }
    }

    private void promptForEmployeeInfo() {
        logger.debug("EmployeeManager.promptForEmployeeInfo");
        String eType = kb.getEmployeeType();
        String fName = kb.getString("Enter the employee first name: ");
        String lName = kb.getString("Enter the employee last name: ");
        double wage =  kb.getDouble("Enter the employee wage: ");
        addEmployee(eType, fName, lName, wage);//where is this method coming from? is it a method? was it imported?
    }

    private void readEmployeesFromFile() throws IOException {
        logger.debug("EmployeeManager.readEmployeesFromFile");
        File input_file = new File(filename);
        if(!input_file.exists()) {//basic question: what does the . character do in theory? seems to subdirect to a method within a class?
            throw new IOException("File not found");
        } else {
            BufferedReader in = new BufferedReader(new FileReader(input_file));
            String line;
            while ((line = in.readLine()) != null) {//assigns whatever is read to line, then operates boolean if line is not null
                logger.debug("EmployeeManager.readEmployeesFromFile() - Read Line - " + line);
                //System.out.println(line);
                //Parse each string, add it to our employee list.
                String[] employee = line.split(" ");//adding spaces between inputs?
                if (employee.length == 4) {//does this check if four inputs were given?
                    addEmployee(employee[0], employee[1], employee[2], Double.parseDouble(employee[3]) );//where is add employee coming from?
                    //how does addEmployee work here? is it an array and this passes elements into each index?
                    //addemployee method declared later in empman
                    //does parse convert double to string? keep data type consistent in array?
                    //addEmployee takes arguments from an array of strings, parseDouble converts the string into a double
                } else {
                    logger.debug("EmployeeManager.readEmployeesFromFile() - Read Line with != 4 parts");
                }
            }
            in.close();
        }
    }

    private void saveEmployeesToFile() throws IOException {
        logger.debug("EmployeeManager.saveEmployeesToFile");
        FileWriter output_file = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(output_file);
        for (Employee e : employees) {
            out.write(e.toFile() + "\r\n");//why r and n, not just r or n?
        }
        out.close();
    }//this method permanently saves into ascii



    private void addEmployee(String employeeType, String firstName, String lastName,
                               double wage) {
        logger.debug("EmployeeManager.addEmployee");
        if (employeeType.equals("S")) {
            employees.add(new SalaryEmployee(firstName, lastName, wage, 0));
        }
        else if (employeeType.equals("E")) {
            employees.add(new ExecutiveEmployee(firstName, lastName, wage, 0));
        }
        else if (employeeType.equals("W")) {
            employees.add(new WageEmployee(firstName, lastName, wage, 0));
        }

    }

}
