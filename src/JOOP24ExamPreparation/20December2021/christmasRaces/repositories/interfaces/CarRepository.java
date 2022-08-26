package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {

    private Collection<Car> carRepository;

    public CarRepository() {
        this.carRepository = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return carRepository.stream()
                .filter(s -> s.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(carRepository);
    }

    @Override
    public void add(Car model) {
        carRepository.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return carRepository.remove(model);
    }

}

