package christmasRaces.repositories.interfaces;

import christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> raceRepository;

    public RaceRepository() {
        this.raceRepository = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        return raceRepository.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(raceRepository);
    }

    @Override
    public void add(Race model) {
        raceRepository.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return raceRepository.remove(model);
    }
}