package glacialExpedition.models.explorers;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {

    public static final double EXPLORER_LOSES_ENERGY = 15;

    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    protected void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    protected void setEnergy(double energy) {

        if (energy <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }

        this.energy = energy;
    }

    @Override
    public void search() {
        this.energy -= EXPLORER_LOSES_ENERGY;

        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }
}
