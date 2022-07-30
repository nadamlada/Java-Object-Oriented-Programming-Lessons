package p03_IteratorTest;

import main.p03_IteratorTest.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;

    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator("aaa", "bbb", "ccc", "ddd");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListIteratorWithNullShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    //has next
    //true -> has next
    //false -> has no next
    @Test
    public void hasHasNext() {
        //aaa
        Assert.assertTrue(listIterator.hasNext());

        //bbb
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());

        //ccc
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());

        //ddd
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        //aaa
        Assert.assertTrue(listIterator.move());

        //bbb
        Assert.assertTrue(listIterator.move());

        //ccc
        Assert.assertTrue(listIterator.move());

        //ddd -> nowhere to go!
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyListShouldThrow() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintSuccess() {
        //създаваме масив, същия като листитератора, и едновременно и на двата се движа по индеските и сравнявам
        String[] names = new String[]{"aaa", "bbb", "ccc", "ddd"};

        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(names[index], listIterator.print());

            //увеличавам индекса на неймс с 1
            index++;

            //минавам на следващия елемент от листитератора
            listIterator.move();
        }
    }
}