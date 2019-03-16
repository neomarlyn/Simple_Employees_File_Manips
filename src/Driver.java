import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;



public class Driver {

    private static Logger logger = LogManager.getLogger(Driver.class);

    public static void main (String args[]) throws IOException
    {
        logger.debug("DRIVER - Inside Driver - public static void main");
        EmployeeManager em = new EmployeeManager("employee_list.txt");
        /*
        System.out.println("Hello world!");
        Employee newguy = new WageEmployee("Andy", "Rock", 5000, 40);
        System.out.println(newguy.getFullName());
        */
        em.run();
    }
}
