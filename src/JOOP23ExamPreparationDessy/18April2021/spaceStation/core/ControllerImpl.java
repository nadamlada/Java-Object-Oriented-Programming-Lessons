package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private int counterExploredPlanets = 0;

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;

    //TODO: The constructor of ControllerImpl does not take any arguments

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        //Creates an astronaut with the given name of the given type. If the astronaut is invalid, throw an IllegalArgumentException with a message:
        //"Astronaut type doesn't exists!"
        //The method should return the following message:
        //•	"Successfully added {astronautType}: {astronautName}!"

        Astronaut astronaut;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;

            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;

            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;

            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        //Creates a planet with the provided items and name.
        //The method should return the following message:
        //•	"Successfully added Planet: {planetName}!"

//        List<String> itemsList = Arrays.asList(items);
//        Planet planet = new PlanetImpl(planetName);
//        planet.getItems().addAll(itemsList);

        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }

        this.planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        //Retires the astronaut from the space station by removing it from its repository. If an astronaut with that name doesn't exist, throw IllegalArgumentException with the following message:
        //•	"Astronaut {astronautName} doesn't exists!"
        // If an astronaut is successfully retired, remove it from the repository and return the following message:
        //•	"Astronaut {astronautName} was retired!"

        Astronaut searchedAstronaut = this.astronautRepository.findByName(astronautName);

//        if(this.astronautRepository.getModels().stream().noneMatch(a -> a.getName().equals(astronautName)))

        if (searchedAstronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            this.astronautRepository.remove(searchedAstronaut);
            return String.format(ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        //When the explore command is called, the action happens. You should start exploring the given planet, by sending the astronauts that are most suitable for the mission:
        //•	You call each of the astronauts and pick only the ones that have oxygen above 60 units.
        //•	You send suitable astronauts on a mission to explore the planet.
        //•	If you don't have any suitable astronauts, throw IllegalArgumentException with the following message: "You need at least one astronaut to explore the planet!"
        //•	After a mission, you must return the following message, with the name of the explored planet and the count of the astronauts that had given their lives for the mission:
        //"Planet: {planetName} was explored! Exploration finished with {deadAstronauts} dead astronauts!"


        Planet searchedPlanet = this.planetRepository.findByName(planetName);

        List<Astronaut> suitableForMissionAstronauts = this.astronautRepository.getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());

        int countBeforeMission = suitableForMissionAstronauts.size();

        Mission mission = new MissionImpl();

        mission.explore(searchedPlanet, suitableForMissionAstronauts);
        int counterAfterMission = suitableForMissionAstronauts.size();
        counterExploredPlanets++;

        if (suitableForMissionAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        return String.format(PLANET_EXPLORED,
                searchedPlanet.getName(), countBeforeMission - counterAfterMission);
    }

    @Override
    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, counterExploredPlanets));
        sb.append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());


        for (Astronaut model : astronautRepository.getModels()) {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()));
            sb.append(System.lineSeparator());

            if (model.getBag().getItems().size() == 0) {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"));
                sb.append(System.lineSeparator());
            } else {
                Collection<String> items = model.getBag().getItems();
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(", ", items)));
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
