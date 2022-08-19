package fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(super.getEnergy() - 15);

        if (super.getEnergy() < 0) {
            super.setEnergy(0);
        }
    }

    //Вариант 2
    //private int energy;
    //    public Sleepy(String name) {
    //        super(name, 50);
    //    }
    //
    //    @Override
    //    public void work() {
    //        if (this.energy - 15 < 0) {
    //            this.energy = 0;
    //        } else {
    //            this.energy -= 15;
    //        }
    //    }
}
