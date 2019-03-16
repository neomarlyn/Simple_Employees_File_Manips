import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class KeyboardUtilsTest {

    @Test
    public void getMainMenu() {
        ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());  //Create simulated keyboard input
        System.setIn(in);  //Change the way system handles input from keyboard to our new simulated input
        KeyboardUtils kb = new KeyboardUtils(); //Creates a new KeyboardUtils object, (which internally makes a new scanner)
        int output = kb.getMainMenu(); //Runs the getMainMenu method, which grabs input, but we make it read from our fake
        System.setIn(System.in); //Return input back to the real keyboard
        assertEquals(4, output); //Assert our expected output.
    }

    @Test
    public void getEmployeeType() {
        ByteArrayInputStream in = new ByteArrayInputStream("e\n".getBytes());
        System.setIn(in);
        KeyboardUtils kb = new KeyboardUtils();
        String output = kb.getEmployeeType();
        System.setIn(System.in);
        assertEquals("E", output);
    }

    @Test
    public void getString() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello world\n".getBytes());
        System.setIn(in);
        KeyboardUtils kb = new KeyboardUtils();
        String output = kb.getString("Test");
        System.setIn(System.in);
        assertEquals("hello world", output);
    }

    @Test
    public void getDouble() {
        ByteArrayInputStream in = new ByteArrayInputStream("300.5\n".getBytes());
        System.setIn(in);
        KeyboardUtils kb = new KeyboardUtils();
        double output = kb.getDouble("Test");
        System.setIn(System.in);
        assertEquals(300.5, output, 0.001);
    }
}