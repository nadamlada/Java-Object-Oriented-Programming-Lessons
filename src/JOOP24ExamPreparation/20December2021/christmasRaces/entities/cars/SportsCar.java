package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    private static final int CUBIC_CENTIMETERS = 3000;
    private static final int MINIMUM_HORSE_POWER = 250;
    private static final int MAXIMUM_HORSE_POWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
        this.setHorsePower(horsePower);
    }

    @Override
    public void setHorsePower(int horsePower) {

        if (horsePower < MINIMUM_HORSE_POWER || horsePower > MAXIMUM_HORSE_POWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        super.setHorsePower(horsePower);
    }
}
