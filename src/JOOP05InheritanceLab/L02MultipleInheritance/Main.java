package L02MultipleInheritance;
/*
Create three classes named Animal, Dog, and Puppy.
Animal with a single public method eat() that prints: "eating…"
Dog with a single public method bark() that prints: "barking…"
Puppy with a single public method weep() that prints: "weeping…"
The Dog should inherit from the Animal. The Puppy should inherit from Dog.
 */

public class Main {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();
        puppy.weep();
    }
}
