package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet planet) {
        this.planets.put(planet.getName(), planet);
    }

    @Override
    public boolean remove(Planet planet) {
        return this.planets.remove(planet.getName()) != null;
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
