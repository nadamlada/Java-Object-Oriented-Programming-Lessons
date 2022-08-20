package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverRepository implements Repository<Driver> {
    private Collection<Driver> driverRepository;

    public DriverRepository() {
        this.driverRepository = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
        return driverRepository.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(driverRepository);
    }

    @Override
    public void add(Driver model) {
        driverRepository.add(model);
    }

    @Override
    public boolean remove(Driver model) {
        return driverRepository.remove(model);
    }
}
