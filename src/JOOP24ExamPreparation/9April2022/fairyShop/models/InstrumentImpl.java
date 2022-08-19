package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {
    //The InstrumentImpl is a class that represents the tool, which a Helper uses to craft Present.

    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    public void setPower(int power) {

        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {

        // if (this.power - 10 < 0) {
        //            this.power = 0;
        //        } else {
        //            this.power -= 10;
        //        }

        this.power -= 10;

        if (this.power < 0) {
            this.power = 0;
        }
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
