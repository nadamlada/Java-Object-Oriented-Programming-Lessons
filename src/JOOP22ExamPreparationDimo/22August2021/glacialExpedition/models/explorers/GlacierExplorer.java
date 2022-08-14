package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    public static final double GLACIER_EXPLORER_INITIAL_ENERGY = 40;

    protected GlacierExplorer(String name) {
        super(name, GLACIER_EXPLORER_INITIAL_ENERGY);
    }
}
