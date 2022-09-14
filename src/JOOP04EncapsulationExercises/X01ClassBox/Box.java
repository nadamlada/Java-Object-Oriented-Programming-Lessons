package X01ClassBox;

public class Box {

    private double length;
    private double width;
    private double height;

    //конструктор когато имаме валидация
    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    //валидации, в мейна с try - catch я хващаме
    private void setLength(double length) {
        checkIllegalArgument(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkIllegalArgument(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkIllegalArgument(height, "Height");
        this.height = height;
    }

    private void checkIllegalArgument(double height, String argumentType) {
        if (height <= 0) {
            throw new IllegalArgumentException(argumentType + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * length * height + 2 * width * height+ 2 * length * width;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return width * height * length;
    }
}
