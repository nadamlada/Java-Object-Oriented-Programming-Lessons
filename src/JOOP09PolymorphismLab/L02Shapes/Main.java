package L02Shapes;

/*
Create class hierarchy, starting with abstract class Shape:
•	Fields:
o	perimeter: Double
o	area: Double
•	Encapsulation for these fields
•	Abstract methods:
o	calculatePerimeter()
o	calculateArea()
Extend Shape class with two children:
•	Rectangle
•	Circle
Each of them needs to have:
•	Fields:
For Rectangle
o	height: Double
o	width: Double
For Circle
o	radius: Double
•	Encapsulation for these fields
•	Public constructor
•	Concrete methods for calculations (perimeter and area)
3.	Animals
Create a class Animal, which holds two fields:
•	name: String
•	favouriteFood: String
The Animal has one abstract method explainSelf(): String.
You should add two new classes - Cat and Dog. Override the explainSelf() method by adding concrete animal sound on a new line. (Look at examples below)
You should be able to use the class like this:
 */

public class Main {
    public static void main(String[] args) {
      Shape shape = new Rectangle(4.0,6.2);
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());

       shape = new Circle(10d);
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());
    }
}
