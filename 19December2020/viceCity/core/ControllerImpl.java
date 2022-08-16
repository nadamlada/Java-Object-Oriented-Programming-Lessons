package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static final int CIVIL__INITIAL_POINTS = 50;
    private static final int TOMMY__INITIAL_POINTS = 100;

    //тези полета ги няма в условието, аз си ги създавам по мое усмотрение
    private Player mainPlayer;
    private Map<String, Player> civilPlayerMap;
    private ArrayDeque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayerMap = new HashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        //Creates a civil player with the given name.
        //The method should return the following message:
        //•	"Successfully added civil player: {player name}!"

        CivilPlayer civilPlayer = new CivilPlayer(name);
        this.civilPlayerMap.put(name, civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        //Creates a gun with the provided type and name.
        //If the gun type is invalid, the method should return the following message:
        //•	"Invalid gun type!"
        //If the gun type is correct, keep the gun and return the following message:
        //•	"Successfully added {gun name} of type: {gun type}"

        Gun gun;

        switch (type) {
            case "Pistol ":
                gun = new Pistol(name);
                break;

            case "Rifle":
                gun = new Rifle(name);
                break;

            default:
                return GUN_TYPE_INVALID;
        }

        this.guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String playersName) {
        //Adds the first added gun to the player's gun repository.
        //•	If there are no guns in the queue, return the following message:
        //"There are no guns in the queue!"
        //•	If the name of the player is "Vercetti", you need to add the gun to the main player's repository and return the following message:
        //"Successfully added {gun name} to the Main Player: Tommy Vercetti"
        //•	If you receive a name that doesn't exist, you should return the following message:
        //"Civil player with that name doesn't exists!"
        //•	If everything is successful, you should add the gun to the player's repository and return the following message:
        //"Successfully added {gun name} to the Civil Player: {player name}"

        Gun currentGun = guns.poll();

//        if (currentGun == null) {
//            return GUN_QUEUE_IS_EMPTY;
//        }

        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (playersName.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(currentGun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, currentGun.getName(), playersName);
        }

        if (!civilPlayerMap.containsKey(playersName)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civilPlayerMap.get(playersName).getGunRepository().add(currentGun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, currentGun, playersName);
    }

    @Override
    public String fight() {
        //When the fight command is called, the action happens. You should start the action between the main player and all the civil players. When a civil player is killed, it should be removed from the repository.
        //•	If the main player still has all of his points and no one is dead or harmed by the civil players, you should return the following messages:
        //"Everything is okay!"
        //•	If any of the players have different life points, you should return the following message:
        //"A fight happened:
        //Tommy live points: {main player life points}!
        //Tommy has killed: {dead civil players} players!
        //Left Civil Players: {civil players count}!"

        neighbourhood.action(mainPlayer, civilPlayerMap.values());

        if (mainPlayer.getLifePoints() == TOMMY__INITIAL_POINTS) {

            boolean allCivilsAreAlive = true;

            // civilPlayerMap.values().stream().allMatch(player -> player.getLifePoints() == CIVIL_INITIAL_POINTS);

            for (Player civilPlayer : civilPlayerMap.values()) {

                if (civilPlayer.getLifePoints() != CIVIL__INITIAL_POINTS) {
                    allCivilsAreAlive = false;
                }
            }

            if (allCivilsAreAlive) {
                return FIGHT_HOT_HAPPENED;
            }
        }

        List<Player> deadPlayers = civilPlayerMap.values()
                .stream()
                .filter(player -> !player.isAlive())
                .collect(Collectors.toList());


        //A fight happened:
        //Tommy live points: {main player life points}!
        //Tommy has killed: {dead civil players} players!
        //Left Civil Players: {civil players count}!"

        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED);
        sb.append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()));
        sb.append(System.lineSeparator());

        int allLeftCivilPlayers = civilPlayerMap.size() - deadPlayers.size();
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, allLeftCivilPlayers));

        for (Player deadPlayer : deadPlayers) {
            civilPlayerMap.remove(deadPlayer);
        }

        return sb.toString().trim();
    }
}
