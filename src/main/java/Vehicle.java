/**
 * Created by falkz on 9/28/2015.
 */
public abstract class Vehicle
{
    protected boolean running;
    protected int numberOfDoors = 4;
    protected int numberOfWheels = 4;

    protected Engine engine;
    protected Transmission transmission;
    protected TransferCase transferCase;
    protected Axel frontAxel;
    protected Axel rearAxel;

    protected Stats stats;

    /**
     * inject the dependent objects at run time
     * @param engine Engine
     * @param transmission Transmission
     * @param transferCase TransferCase
     * @param frontAxel Axel
     * @param rearAxel Axel
     */
    Vehicle(
            Engine engine,
            Transmission transmission,
            TransferCase transferCase,
            Axel frontAxel,
            Axel rearAxel
    )
    {
        this.engine = engine;
        this.transmission = transmission;
        this.transferCase = transferCase;
        this.frontAxel = frontAxel;
        this.rearAxel = rearAxel;
    }

    /**
     * get the number of doors the vehicle has
     * @return int numberOfDoors
     */
    public int getNumberOfDoors()
    {
        return numberOfDoors;
    }

    /**
     * set the number of doors that the vehicle has
     * @param numberOfDoors int
     */
    public void setNumberOfDoors(int numberOfDoors)
    {
        numberOfDoors = numberOfDoors;
    }

    /**
     * get the number of wheels
     * @return int numberOfWheels
     */
    public int getNumberOfWheels()
    {
        return numberOfWheels;
    }

    /**
     * set the number of wheels
     * @param numberOfWheels int
     */
    public void setNumberOfWheels(int numberOfWheels)
    {
        numberOfWheels = numberOfWheels;
    }

    /**
     *  start the vehicle
     */
    public boolean start()
    {
        System.out.println("Vehicle is running");
        running = engine.start() && transmission.start();
        return running;
    }

    public boolean stop()
    {
        System.out.println("Vehicle is stopped");
        //test exposed need for the !  cause they're awesome like that!!!!
        running = !engine.stop() && transmission.stop();
        return running;
    }

    /**
     * drive the vehicle
     */
    public void drive()
    {
        /*
        potential to add modified chain of responsabiliyty to handle ratio reduction from engine to wheels
         */
        System.out.println("Vroom vroom vehicle is driving!");
        transmission.drive();
        engine.drive();
    }

    /**
     * return a string describing the vehicle
     * @return String
     */
    public String describe()
    {
        return "A "+ this + " with\na " +
                engine +" engine,\na " +
                transmission + " transmission,\na " +
                transferCase + " transfer case,\na " +
                frontAxel + " front axel,\nand a " +
                rearAxel + " rear axel\n";
    }

    public boolean isRunning()
    {
        return running;
    }
}

/**
 * A null vehicle object, dictate null behavior
 */
class NullVehicle extends Vehicle
{
    /**
     * construct a null vehicle
     */
    public NullVehicle()
    {
        super(new NullEngine(), new NullTransmission(), new NullTransferCase(), new NullAxel(), new NullAxel());
    }

    /**
     * overide the default constructor
     */
    public NullVehicle(Engine engine, Transmission transmission, TransferCase transferCase, Axel frontAxel, Axel rearAxel)
    {
        super(new NullEngine(), new NullTransmission(), new NullTransferCase(), new NullAxel(), new NullAxel());
    }

    /**
     * you can't drive a null vehicle friend
     */
    public void drive()
    {
        System.out.println("You can't drive a null Vehicle.");
    }


    public String toString()
    {
        return "null";
    }
}

/**
 * passenger car
 */
class Car extends Vehicle
{
    public Car(Engine engine, Transmission transmission, TransferCase transferCase, Axel frontAxel, Axel rearAxel)
    {
        super(engine, transmission, transferCase, frontAxel, rearAxel);
        setNumberOfDoors(4);
    }

    public String toString()
    {
        return "car";
    }
}

/**
 * truck
 */
class Truck extends Vehicle
{
    public Truck(Engine engine, Transmission transmission, TransferCase transferCase, Axel frontAxel, Axel rearAxel)
    {
        super(engine, transmission, transferCase, frontAxel, rearAxel);
        setNumberOfDoors(2);
    }

    public String toString()
    {
        return "truck";
    }
}

/**
 * cargo or passanger van
 */
class Van extends Vehicle
{

    public Van(Engine engine, Transmission transmission, TransferCase transferCase, Axel frontAxel, Axel rearAxel)
    {
        super(engine, transmission, transferCase, frontAxel, rearAxel);
        setNumberOfDoors(5);
    }

    public String toString()
    {
        return "van";
    }
}
