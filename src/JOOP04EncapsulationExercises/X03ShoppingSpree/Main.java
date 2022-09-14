package JOOP04EncapsulationExercises.X03ShoppingSpree;

/*
Create two classes: class Person and class Product. Each person should have a name, money, and a bag of products. Each product should have a name and cost. The name cannot be an empty string. Be careful about white space in the name. Money and cost cannot be a negative number.
Person
-	name: String
-	money:  double
-	products:  List<Product>
+ 	Person (String,  double)
-	setName (String): void
-	setMoney (double): void
+	buyProduct (Product): void
+	getName(): String
Product
-	name: String
-	cost: double
+ 	Product (String,  double)
-	setCost (double): void
-	setName (String): void
+	getName(): String
+	getCost (): double

Create a program in which each command corresponds to a person buying a product. If the person can afford a product add it to his bag. If a person doesn’t have enough money, print an appropriate exception message:
"{Person name} can't afford {Product name}"
In the first two lines, you are given all people and all products. After all, purchases print every person in the order of appearance and all products that he has bought also in order of appearance. If nothing is bought, print:
"{Person name} - Nothing bought".
Read commands till you find the line with the "END" command. In case of invalid input (negative money exception message: "Money cannot be negative") or empty name: (empty name exception message "Name cannot be empty") break the program with an appropriate message. See the examples below:
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> productsMap = new LinkedHashMap<>();
        String[] inputPeople = scanner.nextLine().split(";");

        for (String currentPerson : inputPeople) {
            String[] personData = currentPerson.split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(personName, personMoney);
                peopleMap.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] inputProducts = scanner.nextLine().split(";");

        for (String currentProduct : inputProducts) {
            String[] productData = currentProduct.split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(productName, productCost);
                productsMap.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] commandParts = command.split(" ");
            String currentName = commandParts[0];
            String currentProduct = commandParts[1];

            Person buyer = peopleMap.get(currentName);
            Product productToBuy = productsMap.get(currentProduct);

            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n", currentName, currentProduct);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        //ако се override toString -> peopleMap.values().forEach(System.out::println);
        peopleMap.values().forEach(e -> System.out.println(e.toPrint()));
    }
}
