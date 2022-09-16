package L02Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        super.setArea(this.width * this.height);
        return super.getArea();
        // return this.width * this.height;
    }

    @Override
    public double calculatePerimeter() {
        super.setPerimeter(2 * this.width + 2 * this.height);
        return super.getPerimeter();
        // return 2 * this.width + 2 * this.height;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
