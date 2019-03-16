//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

public class SalaryEmployeeTest {

    Employee salaryEmployee = new SalaryEmployee("John", "Doe", 52000, 40.0);

    @org.junit.Test
    public void getFirstName() {
        String output = salaryEmployee.getFirstName();
        assertEquals(output, "John");
    }

    @org.junit.Test
    public void getLastName() {
        String output = salaryEmployee.getLastName();
        assertEquals(output, "Doe");
    }

    @org.junit.Test
    public void getWageTest() {
        Double output = salaryEmployee.getWage();
        assertEquals(output, 52000.0, 0.001);
    }

    @org.junit.Test
    public void getHoursWorkedTest() {
        double hoursWorked = salaryEmployee.getHoursWorked();
        assertEquals(40.0, hoursWorked, 0.001);
    }

    @org.junit.Test
    public void getFullNameTest() {
        String fullName = salaryEmployee.getFullName();
        assertEquals("John Doe", fullName);
    }

    @org.junit.Test
    public void toStringTest() {
        String output = "SalaryEmployee(firstName='John', ";
        output += "lastName='Doe', ";
        output += "wage=52000.0, ";
        output += "hoursWorked=40.0)";
        assertEquals(output, salaryEmployee.toString());
    }

    @org.junit.Test
    public void getWeeklyPayTest() {
        double output = salaryEmployee.getWeeklyPay();
        assertEquals(1000.0, output, 0.001);
    }

    @org.junit.Test
    public void toFileTest() {
        String expected = "S John Doe 52000.0";
        String output = salaryEmployee.toFile();
        assertEquals(expected, output);
    }
}