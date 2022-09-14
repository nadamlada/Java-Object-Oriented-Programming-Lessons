package L01SortByNameAndAge;

/*
Create a class Person, which should have private fields for:
•	firstName: String
•	lastName: String
•	age: int
•	toString() - override
 */

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        //Сравни първо по име, после по години
        /*
           int result = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (result == 0) {
                result = Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }

            return result;
         */

        Collections.sort(people, Comparator.comparing(Person::getFirstName)
                .thenComparingInt(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}