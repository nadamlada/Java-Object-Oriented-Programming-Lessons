package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;


    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        //TODO:
        //?this.canFire = canFire;
    }

    protected void setName(String name) {
        //TODO: All names are unique -> map

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }

        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        //TODO: The initial BulletsInBarrel count is the actual capacity of the barrel!

        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }

        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        //these are bullets out of barrel

        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }

        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return (this.totalBullets > 0 || this.bulletsPerBarrel > 0);
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }
}
