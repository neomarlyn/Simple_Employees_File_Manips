import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tester {
    Employee salaryEmployee = new SalaryEmployee("John", "Doe", 52000, 40.0);
    Employee wageEmployee = new WageEmployee("Jane", "Doe", 10.0, 40.0);
    Employee executiveEmployee = new ExecutiveEmployee("Billy", "Joel", 52000, 0.0);


    @Test
    public void employeeToStringTest() {
        String salaryString = salaryEmployee.toString();
        String wageString = wageEmployee.toString();
        String executiveString = executiveEmployee.toString();
        assertEquals(salaryString, "SalaryEmployee(firstName='John', lastName='Doe', wage=52000.0, hoursWorked=40.0)");
        assertEquals(wageString, "WageEmployee(firstName='Jane', lastName='Doe', wage=10.0, hoursWorked=40.0)");
        assertEquals(executiveString, "ExecutiveEmployee(firstName='Billy', lastName='Joel', wage=52000.0, hoursWorked=0.0)");
    }

}
