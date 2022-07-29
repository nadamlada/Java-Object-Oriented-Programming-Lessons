public class Main {
/*
Part I: Unit Testing Basics
1.	Create Maven Project
Maven is build automation tool that takes care of dependencies for your project. Before you can make one, make sure that you enable the plugin in IntelliJ [File  Settings  Plugins  Maven]
Now, you can create a Maven project.
First, you give a name and location to your project. Group Id should be separated by dots, Artifact Id should be separated by hyphens:
If everything is ok, you should see the following project structure:
Copy the files provided and place them in a package inside src/main/java folder

2.	Test Axe
In the test/java folder, create a package called rpg_tests.
Create a class AxeTests.
Create the following tests:
•	Test if the weapon loses durability after each attack;
•	Test attacking with a broken weapon.

3.	Test Dummy
Create a class DummyTests.
Create the following tests:
•	Dummy loses health if attacked.
•	Dead Dummy throws an exception if attacked.
•	Dead Dummy can give XP.
•	Alive Dummy can't give XP.
Hints
Follow the logic of the previous problem.

4.	Refactor Tests
Refactor the tests for Axe and Dummy classes.
Make sure that:
•	Names of test methods are descriptive.
•	You use appropriate assertions (assert equals vs assert true).
•	You use assertion messages.
•	There are no magic numbers.
•	There is no code duplication (Don’t Repeat Yourself).
Hints
Extract constants and private fields for Axe class:
Create a method that executes before each test:
Make use of constants and private fields, as well as add assertion messages:
Follow the same logic for other test methods and TestDummy class.

Part II: Dependencies
5.	Fake Axe and Dummy
Test if the hero gains XP when a target dies.
To do this, you need to:
•	Make Hero class testable (use Dependency Injection).
•	Introduce Interfaces for Axe and Dummy:
o	Interface Weapon
o	Interface Target
Create a fake Weapon and fake Dummy for the test.

6.	Mocking
Include Mockito in the project dependencies, then:
1.	Mock fakes from the previous problem.
2.	Implement Hero Inventory, holding unequipped weapons:
a.	method - Iterable<Weapon> getInventory()
3.	Implement Target giving random weapons upon death:
a.	field - private List<Weapon> possibleLoot
4.	Test Hero killing a target getting loot in his inventory.
*/
}
