package JOOP07InterfacesAndAbstractionLab.L03SayHello;

/*
<<Person>>
+getName(): String
+sayHello(): String
(Abstract)

BasePerson
-name: String
#BasePerson(name)
+getName(): String
-setName(): void

European
+European(name)
+sayHello(): String

Chinese
+Chinese(name)
+sayHello(): String

Bulgarian
+Bulgarian(name)
+sayHello(): String
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
