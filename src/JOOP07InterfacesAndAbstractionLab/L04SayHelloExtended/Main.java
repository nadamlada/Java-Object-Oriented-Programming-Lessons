package L04SayHelloExtended;

/*
Build hierarchy from classes and interfaces for this UML diagram:

<<Person>>
+getName(): String
+sayHello(): String

Bulgarian
-name: String
+sayHello(): String

European
-name: String

Chinese
-name: String
+sayHello(): String

Your hierarchy has to be used with this code:
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
