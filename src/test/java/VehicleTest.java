/**
 * Created by falkz on 10/4/2015.
 */

import junit.framework.TestCase;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

public class VehicleTest extends TestCase
{

    Mockery context = new JUnit4Mockery()
    {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    public void testStart() throws Exception
    {
        System.out.println("Testing Vehicle Start");
        /*
        mock out the dependent objects
         */
        final Engine mockEngine = context.mock(Engine.class);
        final Transmission mockTransmission = context.mock(Transmission.class);
        final TransferCase mockTransferCase = context.mock(TransferCase.class);
        final Axel mockAxel = context.mock(Axel.class);

        context.checking(new Expectations()
        {{
            oneOf (mockTransmission).start(); will(returnValue(true));
            oneOf (mockEngine).start(); will(returnValue(true));
        }});

        /*
        construct our
        */
        Vehicle testVehicle = new Car(mockEngine, mockTransmission, mockTransferCase, mockAxel, mockAxel);

        /*
        call the method we are testing
         */
        testVehicle.start();

        /*
        make assertions
         */
        assertTrue(testVehicle.isRunning());
    }

    public void testStop() throws Exception
    {
        System.out.println("Testing Vehicle Drive");
        /*
        mock out the dependent objects
         */
        final Engine mockEngine = context.mock(Engine.class);
        final Transmission mockTransmission = context.mock(Transmission.class);
        final TransferCase mockTransferCase = context.mock(TransferCase.class);
        final Axel mockAxel = context.mock(Axel.class);

        /*
        define our expected behavior
        this is similar to making asserting, we are asserting our expectations of behavior
         */
        context.checking(new Expectations()
        {{
            oneOf(mockTransmission).stop(); will(returnValue(true));
            oneOf (mockEngine).stop(); will(returnValue(true));
        }});

        /*
        construct our
         */
        Vehicle testVehicle = new Car(mockEngine, mockTransmission, mockTransferCase, mockAxel, mockAxel);

        /*
        call the method we are testing
         */
        testVehicle.stop();//mention exception driven control and unit testing

        /*
        make assertions
         */
        assertFalse(testVehicle.isRunning());
    }

    public void testDrive() throws Exception
    {
        System.out.println("Testing Vehicle Drive");
        /*
        mock out the dependent objects
         */
        final Engine mockEngine = context.mock(Engine.class);
        final Transmission mockTransmission = context.mock(Transmission.class);
        final TransferCase mockTransferCase = context.mock(TransferCase.class);
        final Axel mockAxel = context.mock(Axel.class);

        /*
        define our expected behavior
        this is similar to making asserting, we are asserting our expectations of behavior
         */
        context.checking(new Expectations()
        {{
            oneOf(mockTransmission).drive();
            oneOf (mockEngine).drive();
        }});

        /*
        construct our
         */
        Vehicle testVehicle = new Car(mockEngine, mockTransmission, mockTransferCase, mockAxel, mockAxel);

        /*
        call the method we are testing
         */
        testVehicle.drive();//mention exception driven control and unit testing
        //mention exception driven control and unit testing
    }
}