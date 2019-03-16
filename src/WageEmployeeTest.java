//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;

public class WageEmployeeTest {

    Employee wageEmployee = new WageEmployee("John", "Doe", 10, 40.0);

    @Test
    public void getFirstName() {
        String output = wageEmployee.getFirstName();
        Assertions.assertEquals(output, "John");
    }

    @Test
    public void getLastName() {
        String output = wageEmployee.getLastName();
        Assertions.assertEquals(output, "Doe");
    }

    @Test
    public void getWageTest() {
        Double output = wageEmployee.getWage();
        Assertions.assertEquals(output, 10.0, 0.001);
    }

    @Test
    public void getHoursWorkedTest() {
        double hoursWorked = wageEmployee.getHoursWorked();
        assertEquals(40.0, hoursWorked, 0.001);
    }

    @Test
    public void getFullNameTest() {
        String fullName = wageEmployee.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void toStringTest() {
        String output = "WageEmployee(firstName='John', ";
               output += "lastName='Doe', ";
               output += "wage=10.0, ";
               output += "hoursWorked=40.0)";
        assertEquals(output, wageEmployee.toString());
    }

    @Test
    public void getWeeklyPayTest() {
        double output = wageEmployee.getWeeklyPay();
        assertEquals(400.0, output, 0.001);
    }

    @Test
    public void toFileTest() {
        String expected = "W John Doe 10.0";
        String output = wageEmployee.toFile();
        assertEquals(expected, output);
    }
}