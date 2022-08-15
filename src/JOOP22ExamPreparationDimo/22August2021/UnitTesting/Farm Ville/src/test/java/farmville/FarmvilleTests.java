package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowBecauseNull() {
        Farm farm = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowBecauseEmpty() {
        Farm farm = new Farm("", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowBecauseBlank() {
        Farm farm = new Farm("   ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowForNegativeCapacity() {
        Farm farm = new Farm("myFarm", -2);
    }

    @Test
    public void testShouldCreateFarmHappyPath() {
        Farm farm = new Farm("myFarm", 3);
        Assert.assertEquals("myFarm", farm.getName());
        Assert.assertEquals(3, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalInFullFarm() {
        Farm farm = new Farm("myFarm", 1);
        Animal animal1 = new Animal("dog", 1);
        Animal animal2 = new Animal("cat", 2);
        farm.add(animal1);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalThatExists() {
        Farm farm = new Farm("myFarm", 2);
        Animal animal1 = new Animal("dog", 1);
        farm.add(animal1);
        farm.add(animal1);
    }

    @Test
    public void testAddHappyPath() {
        Farm farm = new Farm("myFarm", 2);
        Animal animal1 = new Animal("dog", 1);
        farm.add(animal1);
        Assert.assertEquals(1, farm.getCount());
        Assert.assertEquals("myFarm", farm.getName());
    }

    @Test
    public void testRemoveWhenNull () {
        Farm farm = new Farm("myFarm", 2);
        farm.remove(null);
    }

    @Test
    public void testRemoveShouldRemove () {
        Farm farm = new Farm("myFarm", 2);
        Animal animal1 = new Animal("dog", 1);
        farm.add(animal1);
        farm.remove(animal1.getType());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test
    public void testRemoveShouldNotRemove () {
        Farm farm = new Farm("myFarm", 2);
        Animal animal1 = new Animal("dog", 1);
        farm.add(animal1);
        farm.remove("cat");
        Assert.assertEquals(1, farm.getCount());
    }
}
