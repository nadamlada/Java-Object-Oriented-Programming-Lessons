package JOOP04EncapsulationExercises.X05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isRemoved = players.removeIf(p -> p.getName().equals(playerName));

        if (!isRemoved) {
            String exception = String.format("Player %s is not in %s team.", playerName, name);
            throw new IllegalArgumentException(exception);
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(p -> p.overallSkillLevel()).average().orElse(0);
    }
}
