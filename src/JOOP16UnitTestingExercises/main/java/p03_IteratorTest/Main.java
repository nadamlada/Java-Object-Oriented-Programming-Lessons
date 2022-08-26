package main.java.p03_IteratorTest;

/*
You are given a simple class "ListIterator", it should receive the collection (Strings) which it will iterate, through its constructor. You should store the elements in a List and get them initially through its constructor. If there is a null passed to the constructor, throw a new OperationNotSupportedException. The class should have three main functions:
•	Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
•	HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
•	Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".
Command	Return Type	Description
Move	boolean	This command should move the internal index to the next index.
Print	void	This command should return the element at the current internal index.
HasNext	boolean	Returns whether the collection has a next element.
Test
Create tests, so you are sure all methods in the class ListIterator are working as intended.
Constraints
•	There will always be only 1 Create command and it will always be the first command passed.
•	The last command will always be the only END command.
 */

public class Main {
}
