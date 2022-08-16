package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.NAME_NULL;
import static viceCity.common.ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    protected void setName(String name) {
        //TODO: All names are unique
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }

        this.name = name;
    }

    protected void setLifePoints(int lifePoints) {

        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }

        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int pointsTaken) {
        this.lifePoints = this.lifePoints - pointsTaken;

        if(this.lifePoints < 0) {
            this.lifePoints = 0;
        }

       // this.lifePoints = Math.max(0, this.lifePoints - pointsTaken);
    }
}
