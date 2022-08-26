package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithNullNameThrow() {
        String name = null;
        House house = new House(name, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithNegativeCapacity() {
        String name = "testName";
        int capacity = -4;

        House house = new House(name, capacity);
    }

    @Test
    public void testSetCapacitySuccess() {
        String name = "testName";
        int capacity = 20;
        House house = new House(name, capacity);

        Assert.assertEquals(20, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatToFullHouseThrow() {
        String name = "testName";
        int capacity = 2;

        House testHouse = new House(name, capacity);

        String catName1 = "testCatName1";
        String catName2 = "testCatName2";
        String catName3 = "testCatName3";

        Cat cat1 = new Cat(catName1);
        Cat cat2 = new Cat(catName2);
        Cat cat3 = new Cat(catName3);

        testHouse.addCat(cat1);
        testHouse.addCat(cat2);
        testHouse.addCat(cat3);
    }

    @Test
    public void testAddCatToEmptyHouse() {
        String name = "testName";
        int capacity = 2;

        House house = new House(name, capacity);
        String catName1 = "testCatName1";
        Cat cat1 = new Cat(catName1);

        house.addCat(cat1);

        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThatIsNotInTheHouseThrow() {
        String name = "testName";
        int capacity = 2;

        House house = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        house.addCat(cat1);
        house.removeCat("testCatNotInHouse2");
    }

    @Test
    public void testRemoveCatThatIsInTheHouseSuccess() {
        String name = "testName";
        int capacity = 2;

        House house = new House(name, capacity);
        String catName1 = "testCatName1";
        String catName2 = "testCatName2";

        Cat cat1 = new Cat(catName1);
        Cat cat2 = new Cat(catName2);

        house.addCat(cat1);
        house.addCat(cat2);

        house.removeCat("testCatName1");

        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void forSaleCatThatIsNotInTheHouseThrow() {
        String name = "testName";
        int capacity = 2;

        House house = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        house.addCat(cat1);
        house.catForSale("testCatNotInHouse");
    }

    @Test
    public void forSaleCatThatIsInTheHouseSuccess() {
        String name = "testName";
        int capacity = 2;

        House house = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        house.addCat(cat1);
        house.catForSale("testCatName1");

        //Assert.assertEquals("testCatName1", house.catForSale("testCatName1").getName());
        Assert.assertEquals(cat1, house.catForSale("testCatName1"));

        Assert.assertFalse(cat1.isHungry());
    }

    @Test
    public void testStatistics() {
        String name = "testName";
        int capacity = 2;

        House testHouse = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        testHouse.addCat(cat1);

        String testStatistic = "The cat testCatName1 is in the house testName!";

        Assert.assertEquals(testStatistic, testHouse.statistics());
    }

    @Test
    public void getHouseName() {
        String name = "testName";
        int capacity = 2;

        House testHouse = new House(name, capacity);
        Assert.assertEquals("testName", testHouse.getName());
    }

    @Test
    public void testGetCatCountInTheHouse() {
        String name = "testName";
        int capacity = 2;

        House testHouse = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        testHouse.addCat(cat1);

        Assert.assertEquals(1, testHouse.getCount());
    }

    @Test
    public void testGetCapacity() {
        String name = "testName";
        int capacity = 2;

        House testHouse = new House(name, capacity);
        String catName1 = "testCatName1";

        Cat cat1 = new Cat(catName1);

        testHouse.addCat(cat1);

        Assert.assertEquals(2, testHouse.getCapacity());
    }

}
