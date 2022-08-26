package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public static final double NATURAL_EXPLORER_INITIAL_ENERGY = 60;
    public static final double DECREASE_ENERGY = 7;

    protected NaturalExplorer(String name) {
        super(name, NATURAL_EXPLORER_INITIAL_ENERGY);
    }

    @Override
    public void search() {
       double currentEnergy = getEnergy() - DECREASE_ENERGY;

       if(currentEnergy < 0) {
           currentEnergy = 0;
       }

       setEnergy(currentEnergy);
    }
}
