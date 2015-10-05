/**
 * Created by falkz on 10/4/2015.
 */

import java.util.Scanner;

/*
a full abstract factory implementation would be useful here
this is a lazy implementation that gets user input
 */
public class VehicleFactory
{
    Scanner in;

    public VehicleFactory()
    {
        in = new Scanner(System.in);
    }

    /**
     * build a vehicle based on user input
     * @return Vehicle
     */
    public Vehicle getVehicle()
    {
        System.out.println("Select a vehicle type");
        System.out.println("1.)Car\n2.)Truck\n3.)Van");
        String vehicleTypeId = in.nextLine();

        Vehicle vehicle;
        System.out.println("Select an engine");
        Engine engine = this.getEngine();
        System.out.println("Select a transmission");
        Transmission transmission = this.getTransmission();
        System.out.println("Select a transfer case");
        TransferCase transferCase = this.getTransferCase();
        System.out.println("Select a front axel");
        Axel frontAxel = this.getAxel();
        System.out.println("Select a rear axel");
        Axel rearAxel = this.getAxel();

        switch(vehicleTypeId)
        {
            case "1":
                vehicle = new Car(engine, transmission, transferCase, frontAxel, rearAxel);
                break;
            case "2":
                vehicle = new Truck(engine, transmission, transferCase, frontAxel, rearAxel);
                break;
            case "3":
                vehicle = new Van(engine, transmission, transferCase, frontAxel, rearAxel);
                break;
            default:
                vehicle = new NullVehicle();
                break;
        }
        return vehicle;
    }

    /**
     * get an engine based on user input
     * @return Engine
     */
    public Engine getEngine()
    {
        System.out.println("1.)Gas\n2.)Diesel\n");
        String id = in.nextLine();
        switch(id)
        {
            case "1":
                return new GasEngine();
            case "2":
                return new DieselEngine();
            default:
                return new NullEngine();
        }
    }

    /**
     * get a transmission based on user input
     * @return Transmission
     */
    public Transmission getTransmission()
    {
        System.out.println("1.)Manual\n2.)Automatic\n");
        String id = in.nextLine();
        switch(id)
        {
            case "1":
                return new ManualTransmission();
            case "2":
                return new AutomaticTransmission();
            default:
                return new NullTransmission();
        }
    }

    /**
     * get a transfer case based on user input
     * @return TransferCase
     */
    public TransferCase getTransferCase()
    {
        System.out.println("1.)None(2wd)\n2.)4x4\n3.)AWD");
        String id = in.nextLine();
        switch(id)
        {
            case "1":
                return new NullTransferCase();
            case "2":
                return new TransferCase();
            case "3":
                return new AWDTransferCase();
            default:
                return new NullTransferCase();
        }
    }

    /**
     * get an axel based on user input
     * @return Axel
     */
    public Axel getAxel()
    {
        System.out.println("1.)Solid\n2.)Independent\n");
        String id = in.nextLine();
        switch(id)
        {
            case "1":
                return new SolidAxel();
            case "2":
                return new IndependentAxel();
            default:
                return new NullAxel();
        }
    }
}
