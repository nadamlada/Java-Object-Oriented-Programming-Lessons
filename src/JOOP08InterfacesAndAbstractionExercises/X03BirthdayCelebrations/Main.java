package X03BirthdayCelebrations;

/*
It is a well-known fact that people celebrate birthdays, it is also known that some people also celebrate their pet's birthdays. Extend the program from your last task to add birthdates to citizens and include a class Pet, pets have a name and a birthdate. Also, create a class Robot that has an id and model. Encompass repeated functionality into interfaces and implement them in your classes.
You will receive from the console an unknown amount of lines until the command "End" is received,  each line will contain information in one of the following formats "Citizen {name} {age} {id} {birthdate}" for citizens,
"Robot {model} {id}" for robots or "Pet {name} {birthdate}" for pets. After the end command on the next line, you will receive a single number representing a specific year, your task is to print all birthdates (of both citizens and pets) in that year in the format "{day}/{month}/{year}" (the order of printing doesn’t matter).

<<Interface>>
Identifiable
+	getId(): String

<<Interface>>
Birthable
+	getBirthDate(): String

Citizen
-	name: String
-	age: int
-	id: String
-	birthDate: String
+	Citizen(String, int, String, String)
+	getName(): String
+	getAge(): int
+	getId(): String

Robot
-	id: String
-	model: String
+	Robot(String, String)
+	getId(): String
+	getModel(): String

Pet
-	name: String
-	birthDate: String
+	Pet(String, String)
+	getName(): String
+	getBirthDate(): String
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> citizensAndPets = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");

            switch (data[0]) {
                case "Citizen":
                    String citizenName = data[1];
                    int citizenAge = Integer.parseInt(data[2]);
                    String citizenId = data[3];
                    String citizenBirthDate = data[4];

                    Birthable citizen = new Citizen(
                            citizenName, citizenAge, citizenId, citizenBirthDate);
                    citizensAndPets.add(citizen);
                    break;

                case "Pet":
                    String petName = data[1];
                    String petBirthDate = data[2];

                    Birthable pet = new Pet(petName, petBirthDate);
                    citizensAndPets.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String searchedYear = scanner.nextLine();

        for (Birthable birthable : citizensAndPets) {

            if (birthable.getBirthDate().endsWith(searchedYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}

