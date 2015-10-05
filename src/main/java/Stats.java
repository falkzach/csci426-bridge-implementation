/**
 * Created by falkz on 10/4/2015.
 */

/**
 * POJO stats class
 */
public class Stats {
    private double cost;
    private double power;
    private double torque;
    private double weight;
    private double handling;

    /**
     *
     * @param cost double
     * @param power double
     * @param torque double
     * @param weight double
     * @param handling double
     */
    public Stats(double cost, double power, double torque, double weight, double handling)
    {
        this.cost = cost;
        this.power = power;
        this.torque = torque;
        this.weight = weight;
        this.handling = handling;
    }

    public double getCost()
    {
        return cost;
    }

    public double getPower()
    {
        return power;
    }

    public double getTorque()
    {
        return torque;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getHandling()
    {
        return handling;
    }

    /**
     * would be a good place for a Composite pattern
     * @param stats Array
     */
    public void accumulateStats(Stats[] stats)
    {
        //TODO implement accumulate, maybe move to vehicle stats subclass
    }
}
