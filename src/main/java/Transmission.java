/**
 * Created by falkz on 9/28/2015.
 */
public abstract class Transmission
{
    /**
     * -1 reverse, 0 neutural, 1,2... forward gears
     *
    **/
//    protected int gears;
//    protected double[] ratios;
    protected int currentGear;
    public abstract void shift(int gearId);

//    public double getOutputSpeed(double inputSpeed)
//    {
//        return inputSpeed * ratios[currentGear];
//    }

    public boolean start()
    {
        shift(0);
        return true;
    }

    public boolean stop()
    {
    shift(0);
    return false;
    }

    public void drive()
    {
        shift(1);
    }
}

class NullTransmission extends Transmission
{
    @Override
    public void shift(int gearId)
    {
        System.out.println("You cannot shift a Null Transmission");
    }

//    @Override
//    public double getOutputSpeed(double inputSpeed) {
//        return 0.0;
//    }
}

class AutomaticTransmission extends Transmission
{
    @Override
    public void shift(int gearId)
    {
        crazyElvinMagic();
        currentGear = gearId;
    }

    private void crazyElvinMagic()
    {

    }

    public String toString()
    {
        return "automatic";
    }
}

class ManualTransmission extends Transmission
{
    @Override
    public void shift(int gearId)
    {
        depressClutch();
        setGear(gearId);
        releaseClutch();
    }

    private void depressClutch()
    {

    }

    private void setGear(int gearId)
    {
        currentGear = gearId;
    }

    private void releaseClutch()
    {

    }

    public String toString()
    {
        return "manual";
    }
}
