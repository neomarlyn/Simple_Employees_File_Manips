public class WageEmployee extends Employee {
    WageEmployee(String fname, String lname, double wages, double hours){
        firstName = fname;
        lastName = lname;
        wage = wages;
        hoursWorked = hours;
    }

    @Override
    public double getWeeklyPay() {
        return wage * hoursWorked;
    }

    @Override
    public String toString() {
        String output = "";
        output += "WageEmployee(firstName='" + firstName + "', ";
        output += "lastName='" + lastName + "', ";
        output += "wage=" + wage + ", ";
        output += "hoursWorked=" + hoursWorked + ")";
        return output;
    }

    @Override
    public String toFile() {
        return "W " + firstName + " " + lastName + " " + wage;
    }
}
