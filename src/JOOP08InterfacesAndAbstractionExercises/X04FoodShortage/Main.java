package X04FoodShortage;

/*
Your totalitarian dystopian society suffers a shortage of food, so many rebels appear. Extend the code from your previous (Problem 2. Multiple Implementation) tasks with new functionality to solve this task.
Define a class Rebel which has a name, age, and group (String), names are unique - there will never be 2 Rebels/Citizens or a Rebel and Citizen with the same name. Define an interface Buyer which defines the methods buyFood() and a getFood(). Implement the Buyer interface in the Citizen and Rebel class, both Rebels and Citizens start with 0 food, when a Rebel buys food his food increases by 5, when a Citizen buys food his food increases by 10.
On the first line of the input you will receive an integer N - the number of people, on each of the next N lines you will receive information in one of the following formats "{name} {age} {id} {birthdate}" for a Citizen or
"{name} {age}{group}" for a Rebel. After the N lines, until the command "End" is received, you will receive names of people who bought food, each on a new line. Note that not all names may be valid, in the case of an incorrect name - nothing should happen.
On the only line of output, you should print the total amount of food purchased.

<<Interface>>
Buyer
+	buyFood(): void
+	getFood(): int

<<Interface>>
Identifiable
+	getId(): String

<<Interface>>
Person
+	getName(): String
+	getAge(): int

Citizen
-	name: String
-	age: int
-	id: String
-	birthDate: String
-	food: int
+	Citizen(String, int, String, String)
+	getName(): String
+	getAge(): int
+	getId(): String
+	getFood(): int
+	buyFood(): void

Rebel
-	name: String
-	age: int
-	group: String
-	food: int
+	Rebel(String, int, String)
+	getName(): String
+	getAge(): int
+	getGroup(): String
+	getFood(): int
+	buyFood(): void
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();

        while (num-- > 0) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            String name = data[0];
            Buyer buyer = null;

            switch (data.length) {
                case 3:
                    buyer = new Rebel(name);
                    break;

                case 4:
                    buyer = new Citizen(name);
                    break;
            }

            buyers.put(name, buyer);
        }

        String buyerName = scanner.nextLine();

        while (!"End".equals(buyerName)) {
            Buyer buyer = buyers.get(buyerName);

            if (buyer != null) {
                buyer.buyFood();
            }

            buyerName = scanner.nextLine();
        }

        int totalSum = buyers.values()
                .stream()
                .mapToInt(e -> e.getFood())
                .sum();

        System.out.println(totalSum);
    }
}
