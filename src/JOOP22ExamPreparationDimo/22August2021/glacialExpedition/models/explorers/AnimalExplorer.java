package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    public static final double ANIMAL_EXPLORER_INITIAL_ENERGY = 100;

    protected AnimalExplorer(String name) {
        super(name, ANIMAL_EXPLORER_INITIAL_ENERGY);
    }
}
