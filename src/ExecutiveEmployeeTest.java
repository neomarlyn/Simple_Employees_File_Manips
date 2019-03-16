//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;

public class ExecutiveEmployeeTest {

    Employee executiveEmployee = new ExecutiveEmployee("John", "Doe", 52000, 40.0);

    @Test
    public void getFirstName() {
        String output = executiveEmployee.getFirstName();
        Assertions.assertEquals(output, "John");
    }

    @Test
    public void getLastName() {
        String output = executiveEmployee.getLastName();
        Assertions.assertEquals(output, "Doe");
    }

    @Test
    public void getWageTest() {
        Double output = executiveEmployee.getWage();
        Assertions.assertEquals(output, 52000.0, 0.001);
    }

    @Test
    public void getHoursWorkedTest() {
        double hoursWorked = executiveEmployee.getHoursWorked();
        assertEquals(40.0, hoursWorked, 0.001);
    }

    @Test
    public void getFullNameTest() {
        String fullName = executiveEmployee.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void toStringTest() {
        String output = "ExecutiveEmployee(firstName='John', ";
        output += "lastName='Doe', ";
        output += "wage=52000.0, ";
        output += "hoursWorked=40.0)";
        assertEquals(output, executiveEmployee.toString());
    }

    @Test
    public void getWeeklyPayTest() {
        double output = executiveEmployee.getWeeklyPay();
        assertEquals(2000.0, output, 0.001);
    }

    @Test
    public void toFileTest() {
        String expected = "E John Doe 52000.0";
        String output = executiveEmployee.toFile();
        assertEquals(expected, output);
    }
}