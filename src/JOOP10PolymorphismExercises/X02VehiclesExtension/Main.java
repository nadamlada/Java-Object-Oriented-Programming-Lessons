package X02VehiclesExtension;

/*
Use your solution to the previous task for a starting point and add more functionality. Add new vehicle – Bus. Now every vehicle has tank capacity and fuel quantity cannot fall (set) below 0 (If fuel quantity becomes less than 0 print on the console "Fuel must be a positive number").
The vehicles cannot be filled with fuel more than their tank capacity. If you try to put more fuel in the tank than the available space, print on the console "Cannot fit fuel in tank" and do not add any fuel to the vehicle's tank.
Add new command for the bus. The bus can drive with or without people. If the bus is driving with people, the air-conditioner is turned on and its fuel consumption per kilometer is increased by 1.4 liters. If there are no people on the bus when driving the air-conditioner is turned off and does not increase the fuel consumption.
Input
•	On the first three lines you will receive information about the vehicles in the format:
Vehicle {initial fuel quantity} {liters per km} {tank capacity}
•	On the fourth line - a number of commands N will be given on the next N lines.
•	On the next N lines – commands in format:
o	Drive Car {distance}
o	Drive Truck {distance}
o	Drive Bus {distance}
o	DriveEmpty Bus {distance}
o	Refuel Car {liters}
o	Refuel Truck {liters}
o	Refuel Bus {liters}
Output
•	After each Drive command print whether the Car/Truck was able to travel a given distance in format if it’s successful: "Car/Truck/Bus travelled {distance} km".
•	If the command is invalid - do nothing.
•	Or if it is not: "Car/Truck/Bus needs refueling".
•	If given fuel is ≤ 0 print: "Fuel must be a positive number".
•	If given fuel cannot fit in car or bus tank print: "Cannot fit fuel in tank".
•	Finally, print the remaining fuel for a car, truck and bus rounded 2 digits after a floating point in the format:
"Car: {liters}
Truck: {liters}
Bus: {liters}"
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        Vehicle car = createVehicle(data);

        input = scanner.nextLine();
        data = input.split(" ");

        Vehicle truck = createVehicle(data);

        input = scanner.nextLine();
        data = input.split(" ");

        Vehicle bus = createVehicle(data);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        while (n-- > 0) {
            input = scanner.nextLine();
            data = input.split(" ");
            String vehicleType = data[1];

            switch (data[0]) {
                case "Drive":
                    double distance = Double.parseDouble(data[2]);
                    Vehicle vehicle = vehicles.get(vehicleType);

                    if (vehicle instanceof Bus) {
                        //По-адекватно е да си имаме в буса празен ли e, или не е празен
                        //и въз основа на това като го пълним или изпразваме да си слагаме или махаме гориво
                        bus.setFuelConsumption(bus.getFuelConsumption() + Bus.ADDITIONAL_BUS_CONSUMPTION);
                        System.out.println(bus.drive(distance));
                        bus.setFuelConsumption(bus.getFuelConsumption() - Bus.ADDITIONAL_BUS_CONSUMPTION);
                        continue;
                    }

                    String driveMessage = vehicle.drive(distance);
                    System.out.println(driveMessage);
                    break;

                case "Refuel":
                    double fuelAmount = Double.parseDouble(data[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;

                case "DriveEmpty":
                    double driveEmptyDistance = Double.parseDouble(data[2]);
                     String driveEmptyMessage = bus.drive(driveEmptyDistance);
                    System.out.println(driveEmptyMessage);
            }
        }

        vehicles.values().stream().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] data) {
        String vehicleType = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);
        double tankCapacity = Double.parseDouble(data[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);

            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);

            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }

        return null;
    }
}