package JOOP04EncapsulationExercises.X05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkStat(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkStat(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkStat(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkStat(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkStat(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        //average of the stats
        return ((this.endurance +
                this.sprint +
                this.dribble +
                this.passing +
                this.shooting) / 5.0
        );
    }

    private void checkStat(int stat, String argument) {

        if (stat < 0 || stat > 100) {
            String exception = String.format("%s should be between 0 and 100.", argument);
            throw new IllegalArgumentException(exception);
        }
    }
}
