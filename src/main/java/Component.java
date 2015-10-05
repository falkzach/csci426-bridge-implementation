/**
 * Created by falkz on 10/4/2015.
 */
public abstract class Component
{
    protected Stats stats;

    public Stats getStats()
    {
        return this.stats;
    }

    public void setStats(Stats stats)
    {
        this.stats = stats;
    }
}
