package X01Vehicles;

/*
Write a program that models 2 vehicles (Car and Truck) and will be able to simulate driving and refueling them in the summer. Car and truck both have fuel quantity, and fuel consumption in liters per km and can be driven given distance and refueled with given liters. But in the summer both vehicles use the air conditioner and their fuel consumption per km is increased by 0.9 liters for the car and 1.6 liters for the truck. Also, the truck has a tiny hole in its tank and when it gets refueled it gets only 95% of the given fuel. The car has no problems when refueling and adds all given fuel to its tank. If the vehicle cannot travel a given distance its fuel does not change.
Input
•	On the first line - information about the car in format "Car {fuel quantity} {liters per km}".
•	On the second line – info about the truck in the format "Truck {fuel quantity} {liters per km}".
•	On the third line - a number of commands N will be given on the next N lines.
•	On the next N lines – commands in the format:
o	Drive Car {distance}
o	Drive Truck {distance}
o	Refuel Car {liters}
o	Refuel Truck {liters}
Output
After each Drive command print whether the Car/Truck was able to travel a given distance in format if it’s successful. Print the distance with two digits after the decimal separator except for trailing zeros. Use the DecimalFormat class:
"Car/Truck travelled {distance} km"
Or if it is not:
"Car/Truck needs refueling"
Finally, print the remaining fuel for both car and truck rounded 2 digits after the floating point in the format:
"Car: {liters}
Truck: {liters}"
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

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        while (n-- > 0) {
            input = scanner.nextLine();
            data = input.split(" ");
            String vehicleType = data[1];

            switch (data[0]) {
                case "Drive":
                    double distance = Double.parseDouble(data[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
                    break;

                case "Refuel":
                    double fuelAmount = Double.parseDouble(data[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;
            }
        }

        vehicles.values().stream().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] data) {
        String vehicleType = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double fuelConsumption = Double.parseDouble(data[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption);

            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption);
        }

        return null;
    }
}

