package L01SingleInheritance;

/*
Create two classes named Animal and Dog.
Animal with a single public method eat() that prints: "eating…"
Dog with a single public method bark() that prints: "barking…"
The Dog should inherit from the Animal.
Hints
Use the extends keyword to build a hierarchy.
 */

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
