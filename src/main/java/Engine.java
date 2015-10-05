/**
 * Created by falkz on 9/28/2015.
 */
public abstract class Engine
{
    protected double rpm;
    protected boolean running;

    /**
     * start the vehicle
     * @return running
     */
    public abstract boolean start();

    /**
     * stop the vehicle
     * @return running
     */
    public abstract boolean stop();

    /**
     * drive the vehicle
     * @return rpm
     */
    public abstract double drive ();

    public double getRpm()
    {
        return rpm;
    }

    protected void pumpFuel()
    {
        System.out.println("fuel");
    }

    protected void crankStarter()
    {
        System.out.println("starter cranking, compression");
    }

    protected void throttle()
    {

    }

    public boolean isRunning()
    {
        return running;
    }
}

class NullEngine extends Engine
{
    @Override
    public boolean start() {
        System.out.println("You cannot start a Null engine");
        return false;
    }

    @Override
    public boolean stop() {
        return true;
    }

    @Override
    public double drive() {
        System.out.println("You cannot drive a Null engine");
        return 0;
    }

    public String toString()
    {
        return "null";
    }
}

class GasEngine extends Engine
{
    @Override
    public boolean start()
    {
        spark();
        pumpFuel();
        crankStarter();
        running = true;
        return running;
    }

    @Override
    public boolean stop()
    {
        running = false;
        return running;
    }

    @Override
    public double drive()
    {
        pumpFuel();
        spark();
        throttle();
        rpm = 7000;
        return rpm;
    }

    private void spark()
    {
        System.out.println("ignition");
    }

    public String toString()
    {
        return "gas";
    }
}

class DieselEngine extends Engine
{
    @Override
    public boolean start()
    {
        pumpFuel();
        crankStarter();
        running = true;
        return running;
    }

    @Override
    public boolean stop()
    {
        running = false;
        return running;
    }

    @Override
    public double drive()
    {
        pumpFuel();
        throttle();
        rpm = 5000;
        return rpm;
    }

    public String toString()
    {
        return "diesel";
    }
}
