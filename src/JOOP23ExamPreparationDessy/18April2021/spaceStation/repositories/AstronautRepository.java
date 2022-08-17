package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut astronaut) {
        this.astronauts.put(astronaut.getName(), astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        return this.astronauts.remove(astronaut.getName()) != null;
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }
}
