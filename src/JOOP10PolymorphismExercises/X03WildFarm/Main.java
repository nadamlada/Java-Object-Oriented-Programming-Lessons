package X03WildFarm;

/*
Your task is to create a class hierarchy like the picture below. All the classes except Vegetable, Meat, Mouse, Tiger, Cat & Zebra should be abstract.
Input should be read from the console. Every even line will contain information about the Animal in following format:
"{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}".
If the animal is a cat: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".
On the odd lines, you will receive information about the food that you should give to the Animal. The line will consist of FoodType and quantity separated by whitespace.
You should build the logic to determine if the animal is going to eat the provided food. The Mouse and Zebra should check if the food is Vegetable. If it is they will eat it. Otherwise, you should print a message in the format:
"{AnimalType} are not eating that type of food!". AnimalType to be in the plural.
Cats eat any kind of food, but Tigers accept only Meat. If a Vegetable is provided to a tiger message like the one above should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method of the current animal and then feed it. In the end, print the whole object in the format:
"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
If the animal is a cat: "{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
Proceed to read information about the next animal/food. The input will continue until you receive "End".
Print all AnimalWeight with two digits after the decimal separator. Use the DecimalFormat class.
Note: consider overriding toString() method.

https://www.youtube.com/watch?v=-rc6uQuVg18&t=8617s
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String animalInput = scanner.nextLine();

        while (!"End".equals(animalInput)) {
            String[] data = animalInput.split(" ");
            Animal animal = createAnimal(data);
            animals.add(animal);

            String foodInput = scanner.nextLine();
            Food food = getFood(foodInput.split(" "));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animalInput = scanner.nextLine();
        }

        animals.forEach(System.out::println );
    }

    public static Animal createAnimal(String[] data) {
        String animalType = data[0];
        String animalName = data[1];
        Double animalWeight = Double.parseDouble(data[2]);
        String animalLivingRegion = data[3];

        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);

            case "Cat":
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, data[4]);

            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);

            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
        }

        throw new IllegalArgumentException("No such animal");
    }

    public static Food getFood(String[] data) {
        String type = data[0];
        Integer quantity = Integer.parseInt(data[1]);

        if ("Meat".equals(type)) {
            return new Meat(quantity);
        } else return new Vegetable(quantity);
    }
}

