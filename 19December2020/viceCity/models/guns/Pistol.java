package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        //1. проверяваме дали има патрони в барел
        //2. ако имаме ги намаляваме с 1
        //3. ако нямаме, презареждаме -> пълним барела от тотала

        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            //презареждаме
            setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
            setBulletsPerBarrel(BULLETS_PER_BARREL);
        }

        if (getBulletsPerBarrel() > 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_SHOT);
        }

        return BULLETS_SHOT;
    }
}