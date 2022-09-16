package X01Vehicles;

public class Truck extends Vehicle {
    private static final double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private static final double TRUCK_REFUEL_CORRECTION_PERCENTAGE = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption += ADDITIONAL_AC_CONSUMPTION;
    }

    @Override
    public void refuel(double liters) {
        liters *= TRUCK_REFUEL_CORRECTION_PERCENTAGE;
        // this.fuelQuantity += liters;
        super.refuel(liters);
    }
}
