package p04_BubbleSortTest;

import main.p04_BubbleSortTest.Bubble;
import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = {1, 8, 5, 66, 55};
        Bubble.sort(numbers);

        int[] sortedArray = {1, 5, 8, 55, 66};
        Assert.assertArrayEquals(sortedArray, numbers);
    }
}