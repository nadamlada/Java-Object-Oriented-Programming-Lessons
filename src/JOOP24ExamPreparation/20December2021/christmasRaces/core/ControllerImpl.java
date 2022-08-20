package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        //Creates a Driver with the given name and adds it to the appropriate repository.
        //The method should return the following message:
        //"Driver {name} is created."
        //If a driver with the given name already exists in the driver repository, throw an IllegalArgumentException with a message:
        //"Driver {name} is already created."

        if (this.driverRepository.getByName(driverName) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driverName));
        }

        Driver createdDriver = new DriverImpl(driverName);

        this.driverRepository.add(createdDriver);

        return String.format(DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        //Create a Car with the provided model and horsepower and add it to the repository. There are two types of Car: "MuscleCar" and "SportsCar".
        //The command will be in the following format: "CreateCar {"Muscle"/"Sports"} {model} {name}".
        //If the Car already exists in the appropriate repository throw an IllegalArgumentException with the following message:
        //"Car {model} is already created."
        //If the Car is successfully created, the method should return the following message:
        //"{"MuscleCar"/ "SportsCar"} {model} is created."

        Car car = null;
        String typeForPrint = null;

        if (this.carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }


        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                typeForPrint = "MuscleCar";
                break;

            case "Sports":
                car = new SportsCar(model, horsePower);
                typeForPrint = "SportsCar";
                break;
        }

        this.carRepository.add(car);

        return String.format(CAR_CREATED, typeForPrint, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        //Gives the Car with a given name to the Driver with a given name (if exists).
        //If the Driver does not exist in the DriverRepository, throw IllegalArgumentException with message
        //•	"Driver {name} could not be found."
        //If the Car does not exist in the CarRepository, throw IllegalArgumentException with message
        //•	"Car {name} could not be found."
        //If everything is successful you should add the Car to the Driver and return the following message:
        //•	"Driver {driver name} received car {car name}."

        Driver driver = this.driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        Car car = this.carRepository.getByName(carModel);

        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driver.addCar(car);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        //Adds a Driver to the Race.
        //If the Race does not exist in the RaceRepository, throw an IllegalArgumentException with a message:
        //•	"Race {name} could not be found."
        //If the Driver does not exist in the DriverRepository, throw an IllegalArgumentException with a message:
        //•	"Driver {name} could not be found."
        //If everything is successful, you should add the Driver to the Race and return the following message:
        //•	"Driver {driver name} added in {race name} race."

        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driver = this.driverRepository.getByName(driverName);

        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        //This method is the big deal. If everything is valid, you should arrange all Drivers and then return the three fastest Drivers. To do this you should sort all Drivers in descending order by the result of CalculateRacePoints method in the Car object. In the end, if everything is valid remove this Race from the race repository.
        //If the Race does not exist in RaceRepository, throw an IllegalArgumentException with a message:
        //•	"Race {name} could not be found."
        //If the participants in the race are less than 3, throw an IllegalArgumentException with a message:
        //•	"Race {race name} cannot start with less than 3 participants."
        //If everything is successful, you should return the following message:
        //•	"Driver {first driver name} wins {race name} race."
        //"Driver {second driver name} is second in {race name} race."
        //"Driver {third driver name} is third in {race name} race."

        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        int driversThatCanParticipate = (int) race.getDrivers()
                .stream()
                .filter(Driver::getCanParticipate)
                .count();

        if (driversThatCanParticipate < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> sortedDrivers = race.getDrivers()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(race.getLaps()),
                        d1.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());

        //TODO: ?? това дали се трие
        this.raceRepository.remove(race);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(DRIVER_FIRST_POSITION, sortedDrivers.get(0).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_SECOND_POSITION, sortedDrivers.get(1).getName(), raceName));
        sb.append(System.lineSeparator());
        sb.append(String.format(DRIVER_THIRD_POSITION, sortedDrivers.get(2).getName(), raceName));

        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        //Creates a Race with the given name and laps and adds it to the RaceRepository.
        //If the Race with the given name already exists, throw an IllegalArgumentException with a message:
        //•	"Race {name} is already created."
        //If everything is successful you should return the following message:
        //•	"Race {name} is created."

        if (this.raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);

        this.raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
