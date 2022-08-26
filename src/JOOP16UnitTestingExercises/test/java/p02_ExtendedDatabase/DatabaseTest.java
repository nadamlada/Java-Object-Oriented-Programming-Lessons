package p02_ExtendedDatabase;

import main.java.p02_ExtendedDatabase.Database;
import main.java.p02_ExtendedDatabase.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
//    private Database database;
//
//    @Before
//    public void prepare() throws OperationNotSupportedException {
//        Person person1 = new Person(14, "Pesho");
//        Person person2 = new Person(25, "Gosho");
//
//        database = new Database(person1, person2);
//    }


    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullShouldThrow() throws OperationNotSupportedException {
        Person person1 = new Person(14, "Pesho");
        Person person2 = new Person(25, "Gosho");
        Database database = new Database(person1, person2);

        database.findByUsername(null);
    }

    @Test
    public void testFindByUsernameSuccess() throws OperationNotSupportedException {
        Person person1 = new Person(14, "Pesho");
        Person person2 = new Person(25, "Gosho");
        Database database = new Database(person1, person2);

        Person personAfterMethod = database.findByUsername("Pesho");
        Assert.assertEquals(person1.getUsername(), personAfterMethod.getUsername());
        Assert.assertEquals(person1.getId(), personAfterMethod.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithMissingName() throws OperationNotSupportedException {
        Person person1 = new Person(14, "Pesho");
        Person person2 = new Person(25, "Gosho");
        Database database = new Database(person1, person2);

        database.findByUsername("Tosho");
    }

    @Test
    public void findByIdSuccess() throws OperationNotSupportedException {
        Person person1 = new Person(14, "Pesho");
        Person person2 = new Person(25, "Gosho");
        Database database = new Database(person1, person2);

        Person personAfterMethod = database.findById(14);
        Assert.assertEquals(14, personAfterMethod.getId());
        Assert.assertEquals("Pesho", personAfterMethod.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWithMissingIdThrows() throws OperationNotSupportedException {
        Person person1 = new Person(14, "Pesho");
        Person person2 = new Person(25, "Gosho");
        Database database = new Database(person1, person2);

        database.findById(16);
    }
}
