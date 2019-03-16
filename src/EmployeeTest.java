//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    Employee employee = new Employee("John", "Doe", 10, 40.0);

    @Test
    public void getFirstName() {
        String output = employee.getFirstName();
        Assertions.assertEquals(output, "John");
    }

    @Test
    public void getLastName() {
        String output = employee.getLastName();
        Assertions.assertEquals(output, "Doe");
    }

    @Test
    public void getWageTest() {
        Double output = employee.getWage();
        Assertions.assertEquals(output, 10.0, 0.001);
    }

    @Test
    public void getHoursWorkedTest() {
        double hoursWorked = employee.getHoursWorked();
        assertEquals(40.0, hoursWorked, 0.001);
    }

    @Test
    public void getFullNameTest() {
        String fullName = employee.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void toStringTest() {
        String output = "John" + " " + "Doe" + "  Wages: " + 10.0;
        assertEquals(output, employee.toString());
    }

    @Test
    public void getWeeklyPayTest() {
        double output = employee.getWeeklyPay();
        assertEquals(400.0, output, 0.001);
    }

    @Test
    public void toFileTest() {
        String expected = "W John Doe 10.0";
        String output = employee.toFile();
        assertEquals(expected, output);
    }
}