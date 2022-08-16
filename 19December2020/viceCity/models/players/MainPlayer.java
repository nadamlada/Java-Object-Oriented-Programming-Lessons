package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final int TOMMY_INITIAL_POINTS = 100;
    private static final String NAME = "Tommy Vercetti";

    public MainPlayer() {
        super(NAME, TOMMY_INITIAL_POINTS);
    }
}
