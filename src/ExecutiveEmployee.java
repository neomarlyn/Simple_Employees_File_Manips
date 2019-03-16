import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecutiveEmployee extends Employee{

    private static Logger logger = LogManager.getLogger(ExecutiveEmployee.class);

    ExecutiveEmployee(String fname, String lname, double wages, double hours){
        firstName = fname;
        lastName = lname;
        wage = wages;
        hoursWorked = hours;
    }

    @Override
    public double getWeeklyPay() {
        return wage / 52.0 + 1000.0;
    }

    @Override//unfamiliar with this syntax, what does at sign do and why override things?
    public String toString() {
        String output = "";
        output += "ExecutiveEmployee(firstName='" + firstName + "', ";
        output += "lastName='" + lastName + "', ";
        output += "wage=" + wage + ", ";
        output += "hoursWorked=" + hoursWorked + ")";
        return output;
    }

    @Override
    public String toFile() {
        return "E " + firstName + " " + lastName + " " + wage;
    }//how does it know which file?
}
