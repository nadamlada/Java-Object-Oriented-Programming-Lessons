package L02SalaryIncrease;

/*
Read person with their names, age, and salary. Read percent bonus to every person salary. People younger than 30 get a half bonus. Expand Person from the previous task. Add salary field and getter and setter with proper access.
New fields and methods
•	salary: double
•	increaseSalary(double bonus)
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

            Person person = new Person(firstName, lastName, age, salary);
            people.add(person);
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}