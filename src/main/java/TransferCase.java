/**
 * Created by falkz on 9/28/2015.
 */
public class TransferCase
{
    protected double rearRatio;
    protected boolean engaged;
//    protected int gear;

    TransferCase()
    {
        rearRatio = 0.6;
    }

    public void engage()
    {
        engaged = true;
    }

    public void disengage()
    {
        engaged = false;
    }

    public double getOutputSpeedRear(double inputSpeed)
    {
        return inputSpeed * this.rearRatio;
    }

    public double getOutputSpeedFront(double inputSpeed)
    {
        return inputSpeed * (1 - rearRatio);
    }

    public String toString()
    {
        return "4x4";
    }
}

class NullTransferCase extends TransferCase
{
    @Override
    public void engage() {
        System.out.println("You can't engage a Null Transfer Case");
    }

    @Override
    public double getOutputSpeedFront(double inputSpeed) {
        return 0.0;
    }

    @Override
    public double getOutputSpeedRear(double inputSpeed) {
        return inputSpeed * 1.0;
    }
}

class AWDTransferCase extends TransferCase
{
    AWDTransferCase()
    {
        rearRatio = 0.5;
    }

    @Override
    public void engage() {
        super.engage();
    }

    @Override
    public void disengage() {
        engaged = true;
    }

    public String toString()
    {
        return "AWD";
    }
}
