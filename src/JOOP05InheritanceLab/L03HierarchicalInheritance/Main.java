package L03HierarchicalInheritance;

/*
Create three classes named Animal, Dog, and Cat.
Animal with a single public method eat() that prints: "eating…"
Dog with a single public method bark() that prints: "barking…"
Cat with a single public method meow() that prints: "meowing…"
Dog and Cat should inherit from Animal.
 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.meow();
        cat.eat();

        Dog dog = new Dog();
        dog.bark();
        dog.eat();
    }
}
