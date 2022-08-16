package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_SHOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        //1. проверяваме дали има патрони в барел
        //2. ако имаме ги намаляваме с 5
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
