package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {

    /*
•	Explorers cannot go on expeditions if their energy is below 0.
•	They leave the station and start collecting exhibits one by one.
•	If they find an exhibit, their energy is decreased.
•	They add the exhibit to their carton. The exhibit should then be removed from the state.
     */

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
         //Взимаме изследователите един по един
         //Започват да намират експонати
         //Докато имаме експонати, докато изследователя има енергия

        Collection<String> stateExhibits = state.getExhibits();

        for (Explorer currentExplorer : explorers) {

            while (currentExplorer.canSearch() && stateExhibits.iterator().hasNext()) {
                currentExplorer.search();
                String currentExhibit = stateExhibits.iterator().next();
                currentExplorer.getSuitcase().getExhibits().add(currentExhibit);
                stateExhibits.remove(currentExhibit);
            }
        }
    }
}
