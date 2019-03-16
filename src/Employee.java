import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee {
    protected String firstName;
    protected String lastName;
    protected double wage;
    protected double hoursWorked;

    private static Logger logger = LogManager.getLogger(Employee.class);


    Employee() {//why initialize to a record?
        logger.debug("Inside Employee Constructor");
        firstName = "John";
        lastName = "Doe";
        wage = 0.0;
        hoursWorked = 0.0;
    }
    //is this constructor redundant? it was throwing an error that Employee was never used.

    Employee(String fname, String lname, double wages, double hours){
        logger.debug("Inside Employee 4-arg Constructor");
        firstName = fname;
        lastName = lname;
        wage = wages;
        hoursWorked = hours;
    }

    public String getFirstName() {//getters because vars are protected, why not used?
        logger.debug("Employee.getFirstName()");
        return firstName;
    }
    public String getLastName() {
        logger.debug("Employee.getLastName()");
        return lastName;
    }
    public double getWage() {
        logger.debug("Employee.getWage()");
        return wage;
    }
    public double getHoursWorked() {
        logger.debug("Employee.getHoursWorked()");
        return hoursWorked;
    }

    public String getFullName() {
        logger.debug("Employee.getFullName()");
        return firstName + " " + lastName;
    }

    public void setFirstName(String fname) {
        logger.debug("Employee.setFirstName()");
        firstName = fname;
    }

    public void setLastName(String lname) {
        logger.debug("Employee.setLastName()");
        lastName = lname;
    }

    public void setWage(double wages) {
        logger.debug("Employee.setWage()");
        wage = wages;
    }

    public void setHoursWorked(double hours) {
        logger.debug("Employee.setHoursWorked()");
        hoursWorked = hours;
    }

    public String toString() {
        logger.debug("Employee.toString()");
        return firstName + " " + lastName + "  Wages: " + wage;
    }

    public void display() {
        logger.debug("Employee.display()");
        System.out.println(toString());
    }

    public double getWeeklyPay() {
        logger.debug("Employee.getWeeklyPay()");
        return wage * hoursWorked;
    }

    public String toFile() {
        return "W " + firstName + " " + lastName + " " + wage;
    }
}
