/**
 * Created by falkz on 10/4/2015.
 */

import junit.framework.TestCase;

public class DieselEngineTest extends TestCase
{
    public void testStart() throws Exception
    {
        System.out.println("Testing Diesel Engine Start");
        Engine testEngine = new DieselEngine();
        Boolean running = testEngine.start();
        assertTrue(running);
    }

    public void testStop() throws Exception
    {
        System.out.println("Testing Diesel Engine Stop");
        Engine testEngine = new DieselEngine();
        Boolean running = testEngine.stop();
        assertFalse(running);
    }

    public void testDrive() throws Exception {
        System.out.println("Testing Diesel Engine Drive");
        Engine testEngine = new DieselEngine();
        double rpm = testEngine.drive();
        assertTrue((rpm > 0));
    }
}