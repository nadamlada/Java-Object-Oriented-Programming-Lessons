package p01_Database;

import main.p01_Database.Database;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    //първо тестваме конструктора
    //1. тестваме Happy path
    //2. невалиден вход повече или по-малко аргументи

    //ako test класа е с throws -> има възможност да хвърли ексепшън
    //test expected = exception -> очакваме да хвърли. ако не хвърли, тестът ни фейлва

    @Test
    public void testConstructorDatabaseHappyPath() throws OperationNotSupportedException {
        //hardcode the array
        //Integer[] numbers = {1, 2, 3, 5, 88, 77};
        Integer[] numbers = new Integer[6];
        Database database = new Database(numbers);
        Integer[] dbElements = database.getElements();

        //в скобите -> първо очавквано, после реално
        //проверяваме дали двата масива са с еднаква дължина
        Assert.assertEquals(numbers.length, dbElements.length);

        //сравняване на двата масива дали са с еднакви елементи. Вар 1
        for (int i = 0; i < numbers.length; i++) {
            Assert.assertEquals(numbers[i], dbElements[i]);
        }

        //сравняване на двата масива дали са с еднакви елементи. Вар 2
        //Assert.assertArrayEquals(numbers, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        Database database = new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigIntegerArray= new Integer[17];
        Database database = new Database(bigIntegerArray);
    }

    //add
    //null -> exception
    //Happy path -> елемента е добавен
    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullArgumentShouldThrow() throws OperationNotSupportedException {
        //инициализацията може в @Before
        Integer[] numbers = new Integer[3];
        Database database = new Database(numbers);
        database.add(null);
    }

    @Test
    public void addSuccessfully() throws OperationNotSupportedException {
        //инициализацията може в @Before
        Integer[] numbers = new Integer[]{1, 2, 3};
        Database database = new Database(numbers);
        database.add(12);

        Integer[] databaseElements = database.getElements();
        int databaseLastElement = databaseElements[databaseElements.length - 1];
        Assert.assertEquals(12, databaseLastElement);

        //да се подсигурим, че към дб е добавен още един елемент, защото може съществуващия да си е 12
        int startSize = numbers.length;
        Assert.assertEquals(startSize + 1, databaseElements.length);
    }

    //remove
    //Happy path -> Последният елемент се изтрива
    //опит да изтрием от празна база -> throws

    @Test
    public void testRemoveSuccessfully () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[]{1, 2, 3};
        Database database = new Database(numbers);

        int startSize = numbers.length;
        database.remove();
        Integer[] currentElements = database.getElements();

        Assert.assertEquals(startSize - 1, currentElements.length);

        //да се подсигурим, че е последния елемент този,който трием
        Integer firstBeforeLastBeforeDelete = numbers[numbers.length - 2];
        Integer lastInDbAfterDelete = currentElements[currentElements.length - 1];
        Assert.assertEquals(firstBeforeLastBeforeDelete, lastInDbAfterDelete);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrow () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        Database database = new Database(numbers);
        database.remove();
    }
}