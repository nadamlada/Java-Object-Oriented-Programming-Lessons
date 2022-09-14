package L05StackOfStrings;

/*
Create a class Stack that can store only strings and has the following functionality:
•	Private field: data: ArrayList<String>
•	Public method: push(String item): void
•	Public method: pop(): String
•	Public method: peek(): String
•	Public method: isEmpty(): boolean
Use composition/delegation to have a field in which to store the stack's data.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner (System.in);
        StackOfStrings customStack = new StackOfStrings();
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");

        System.out.println(customStack.isEmpty());
        System.out.println(customStack.peek());

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
