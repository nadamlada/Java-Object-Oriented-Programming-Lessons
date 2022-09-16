package X02VehiclesExtension;

public class Bus extends Vehicle {
    public static final double ADDITIONAL_BUS_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }
}
