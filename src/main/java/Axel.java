/**
 * Created by falkz on 9/28/2015.
 */

/**
 *
 */
public abstract class Axel
{
    protected double ratio;
//    private double wheelSize;
    public double getRatio()
    {
        return ratio;
    }
}

class NullAxel extends Axel
{
    NullAxel()
    {
        ratio = 0.0;
    }

    public String toString()
    {
        return "none";
    }
}

class SolidAxel extends Axel
{
    SolidAxel()
    {
        ratio = 4.10;
    }


    public String toString()
    {
        return "solid";
    }
}

class IndependentAxel extends Axel
{
    IndependentAxel()
    {
        ratio = 3.73;
    }

    public String toString()
    {
        return "independent";
    }
}
