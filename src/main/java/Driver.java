/**
 * Created by falkz on 10/4/2015.
 */
public class Driver
{
    /**
     * main run
     * @param args Array
     */
    public static void main(String args[])
    {
        Vehicle myVehicle = Driver.buyVehicle();
        System.out.println(myVehicle.describe());
        Driver.driveVehicle(myVehicle);
    }

    /**
     * get a vehicle from the factory
     * @return Vehicle
     */
    public static Vehicle buyVehicle()
    {
        VehicleFactory vehicleFactory = new VehicleFactory();
        return vehicleFactory.getVehicle();
    }

    /**
     * drive the vehicle
     * @param vehicle Vehicle
     */
    public static void driveVehicle(Vehicle vehicle)
    {
        vehicle.drive();
    }
}
