import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class SalaryEmployee extends Employee
{

    private static Logger logger = LogManager.getLogger(SalaryEmployee.class);

    SalaryEmployee(String fname, String lname, double wages, double hours){//why is this saying typo at fname lname?
        firstName = fname;//does this data get stored as an array with indexes?
        lastName = lname;
        wage = wages;
        hoursWorked = hours;
    }

    @Override//why override and what does it do? is there another getweeklypay that this negates?
    public double getWeeklyPay() {
        return wage / 52.0;
    }

    @Override
    public String toString() {
        String output = "";
        output += "SalaryEmployee(firstName='" + firstName + "', ";
        output += "lastName='" + lastName + "', ";
        output += "wage=" + wage + ", ";
        output += "hoursWorked=" + hoursWorked + ")";
        return output;
    }

    @Override
    public String toFile() {
        return "S " + firstName + " " + lastName + " " + wage;
    }
}
