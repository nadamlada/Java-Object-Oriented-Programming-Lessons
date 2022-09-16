package L03Animals;

/*
Create a class Animal, which holds two fields:
•	name: String
•	favouriteFood: String
The Animal has one abstract method explainSelf(): String.
You should add two new classes - Cat and Dog. Override the explainSelf() method by adding concrete animal sound on a new line. (Look at examples below)
You should be able to use the class like this:
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}