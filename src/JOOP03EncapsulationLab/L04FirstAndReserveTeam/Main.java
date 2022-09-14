package L04FirstAndReserveTeam;

/*
Create a Team class. Add to this team all people you read. All people younger than 40 go on the first team, others go on the reserve team. At the end print first and reserve team sizes.
The class should have private fields for:
•	name: String
•	firstTeam: List<Person>
•	reserveTeam: List<Person>
The class should have constructors:
•	Team(String name)
The class should also have private method for setName and public methods for:
•	getName(): String
•	addPlayer(Person person): void
•	getFirstTeam(): List<Person> (Collections.unmodifiableList)
•	getReserveTeam(): List<Person> (Collections.unmodifiableList)
You should be able to use the class like this:
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players", team.getReserveTeam().size());
    }
}