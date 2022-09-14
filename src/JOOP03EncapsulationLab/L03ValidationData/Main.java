package L03ValidationData;

/*
Expand Person with proper validation for every field:
•	Names must be at least 3 symbols
•	Age must not be zero or negative
•	Salary can't be less than 460.0
Print proper message to end-user (look at an example for messages).
Don't use System.out.println() in Person class.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            //Печатане на статуса на ексепшъните на конзолата
            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException exeption){
                System.out.println(exeption.getMessage());
            }
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}