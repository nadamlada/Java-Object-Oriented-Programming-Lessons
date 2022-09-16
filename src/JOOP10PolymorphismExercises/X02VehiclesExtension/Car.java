package X02VehiclesExtension;

public class Car extends Vehicle {
    private static final double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        //ако във Vehicle полетата са protected - >
        this.fuelConsumption +=ADDITIONAL_AC_CONSUMPTION;

        //ако във Vehicle полетата са private ->
        //super.setFuelConsumption(super .getFuelConsumption() + ADDITIONAL_AC_CONSUMPTION);
    }
}
