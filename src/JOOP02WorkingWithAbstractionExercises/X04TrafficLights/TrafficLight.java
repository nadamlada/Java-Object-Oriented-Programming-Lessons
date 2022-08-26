package JOOP02WorkingWithAbstractionExercises.X04TrafficLights;

public class TrafficLight {
    private Color currentColor;

    public TrafficLight(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor() {
        return this.currentColor;
    }

    public void changeColor() {
        switch (this.currentColor) {
            //директно ползваме стойностите на enums в switch
            case RED:
                this.currentColor = Color.GREEN;
                break;

            case GREEN:
                this.currentColor = Color.YELLOW;
                break;

            case YELLOW:
                this.currentColor = Color.RED;
                break;
        }
    }
}