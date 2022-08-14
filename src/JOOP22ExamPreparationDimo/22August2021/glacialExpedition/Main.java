package glacialExpedition;

/*
1.	Overview
The missions in Antarctica are very interesting and you have been chosen to go on a special one. Your mission is to design a station in Antarctica to navigate the missions of polar explorers. The station has researchers with different professional specialties and their ability to survive the cold varies depending on their basic needs, such as the need for a variety of food and heat. Your task is to send them on missions and collect exhibits from the different expeditions.
2.	Setup
•	Upload a zip containing only the glacialExpedition package as a solution to every problem except for the Unit Testing problem.
•	Do not modify the provided interfaces or their packages.
•	Use strong cohesion and loose coupling.
•	Use inheritance and the provided interfaces wherever possible.
•	This includes constructors, method parameters, and return types.
•	Do not violate your interface implementational structure by adding more public methods in the classes than the interfaces have defined.
•	Make sure you have no public fields anywhere.
3.	Task 1: Structure (50 points)
You are given 4 interfaces and you must implement their functionalities in the correct classes.
There are 4 types of entities in the application: Explorer, Suitcase, Mission, State. There are also 2 repositories: an ExplorerRepository and a StateRepository.
Explorer
BaseExplorer is a base class or any type of explorer and should not be instantiated.
Data
•	name – String
o	If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Explorer name cannot be null or empty."
o	The values of the names are unique.
•	energy –  double
o	The energy of аn explorer
o	If the energy is a negative number, throw an IllegalArgumentException with the following message: "Cannot create Explorer with negative energy."
•	suitcase – Suitcase
o	A Suitcase field type
Behavior
void search()
The search() method decreases the explorer's energy. Keep in mind that some Explorer types can implement the method differently.
•	The method decreases the explorer's energy by 15 units.
•	The energy value should not drop below zero.
•	Set the value to be zero if the energy value goes below zero.
boolean canSearch()
The canSearch() method returns boolean. Tell us if the energy is more than zero.
Constructor
A BaseExplorer should take the following values upon initialization:
String name, double energy
Child Classes
There are several concrete types of BaseExplorer:
NaturalExplorer
Has 60 initial units of energy.
The search() method should decrease the explorer's energy by 7 units.
The constructor should take the following values upon an initialization:
String name
GlacierExplorer
Has 40 initial units of energy.
The constructor should take the following values upon an initialization:
String name
AnimalExplorer
Has initial 100 units of energy.
The constructor should take the following values upon an initialization:
String name
Suitcase
The Carton class holds a collection of exhibits. It should be instantiated.
Data
•	exhibits – a collection of Strings
Constructor
The constructor should not take any values upon an initialization.
State
The StateImpl class holds information about the exhibits that can be found and explored. It should be instantiated.
Data
•	name – String
o	If the value of the name is either null or empty (containing only whitespaces), throw a NullPointerException with the following message: "Invalid name!"
•	exhibits – a collection of Strings
Constructor
The constructor should take the following values upon initialization:
String name
Mission
The MissionImpl class holds the main action, which is the explore method.
Behavior
void explore(State state, Collection<Explorer> explorers)
Here is how the explore method works:
•	Explorers cannot go on expeditions if their energy is below 0.
•	They leave the station and start collecting exhibits one by one.
•	If they find an exhibit, their energy is decreased.
•	They add the exhibit to their carton. The exhibit should then be removed from the state.
•	Explorers cannot continue collecting exhibits if their energy drops to 0.
o	If their energy drops to 0, the next explorer starts exploring.
ExplorerRepository
The ExplorerRepository class is a repository for the explorers.
Data
•	explorers – a collection of explorers
Behavior
void add(Explorer explorer)
•	Adds an explorer to the station.
•	Every explorer is unique in the collection.
o	It is guaranteed that there will not be an explorer with the same name.
boolean remove(Explorer explorer)
•	Removes an explorer from the collection. Returns true if the deletion was successful.
Explorer byName(String name)
•	Returns an explorer with that name.
•	If the explorer is not in the collection, return null.
Collection<Explorer> getCollection()
•	Returns an unmodifiable collection of explorers.
StateRepository
The StateRepository class is a repository for the unexplored states.
Data
•	states – a collection of states
Behavior
void add(State state)
•	Adds a state for exploration.
•	Every state is unique in the collection.
o	It is guaranteed that there will not be a state with the same name.
boolean remove(State state)
•	Removes a state from the collection. Returns true if the deletion was successful.
State byName(String name)
•	Returns a state with that name.
•	If the state is not in the collection, return null.
Collection<State> getCollection()
•	Returns an unmodifiable collection of states.
 */

import glacialExpedition.core.Controller;
import glacialExpedition.core.ControllerImpl;
import glacialExpedition.core.Engine;
import glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
