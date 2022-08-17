package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        ArrayDeque<String> items = new ArrayDeque<>(planet.getItems());
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && !items.isEmpty()) {
                String item = items.poll();
                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                planet.getItems().remove(item);
            }
            if (items.isEmpty()) {
                break;
            }
        }

        //това не работи на макс
//        for (Astronaut astronaut : astronauts) {
//            if (!astronaut.canBreath()) {
//                break;
//            }
//
//            //start going out into open space one by one
//            for (String item : planet.getItems()) {
//
//                //astronaut lands on a planet and starts collecting its items one by one.
//                astronaut.getBag().getItems().add(item);
//
//                //He finds an item and he takes a breath.
//                astronaut.breath();
//
//                //He adds the item to his backpack
//                //and respectively the item must be removed from the planet.
//                planet.getItems().remove(item);
//
//                //Astronauts can't keep collecting items if their oxygen becomes 0.
//                //If it (кво е тва ит, тъпанарщина) becomes 0, the next astronaut starts exploring
//                if (!astronaut.canBreath()) {
//                    astronauts.remove(astronaut);
//                    break;
//                }
//            }
//        }
    }
}
