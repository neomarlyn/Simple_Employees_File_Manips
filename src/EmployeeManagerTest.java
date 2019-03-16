import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;


public class EmployeeManagerTest {

    EmployeeManager em;

    @Test
    public void test() {
        try {
            em = new EmployeeManager();
            assertNotNull(em);
        } catch (Exception e)
        {
            //Error reading file
        }
    }

}