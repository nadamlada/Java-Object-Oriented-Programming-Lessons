package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test
    public void testConstructorHappyPath() {
        Spaceship spaceship = new Spaceship("BBB", 12);

         Assert.assertEquals("BBB", spaceship.getName());
        Assert.assertEquals(12, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWithFullSpaceshipThrow() {
        Spaceship spaceship = new Spaceship("BBB", 1);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);
        Astronaut astronaut2 = new Astronaut("Gosho", 20.0);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautIfAstronautExistsThrow() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);

        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void testAddAstronautHappyPath() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);
        Astronaut astronaut2 = new Astronaut("Gosho", 20.0);

        //когато ги добавяме проверяваме и капацитета, за да видим дали се увеличава
        //може и да им проверяваме и данните - имената
        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());

        spaceship.add(astronaut2);
        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test
    public void testBooleanRemoveAstronautNotInSpaceshipReturnNull() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);

        spaceship.add(astronaut1);
        Assert.assertFalse(spaceship.remove("Gosho"));
    }

    @Test
    public void testBooleanRemoveAstronaut() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);

        spaceship.add(astronaut1);
        Assert.assertTrue(spaceship.remove("Pesho"));
    }


    //когато връща булеан на ремуув, тестваме и самият ремуув
    @Test
    public void testRemoveShouldRemove() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);

        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());

        spaceship.remove(astronaut1.getName());
        Assert.assertEquals(0, spaceship.getCount());
        //можем да проверим и дали е махнал правилният
    }

    @Test
    public void testRemoveShouldNotRemove() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Astronaut astronaut1 = new Astronaut("Pesho", 10.0);

        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());

        spaceship.remove("Spas");
        Assert.assertEquals(1, spaceship.getCount());
        //можем да проверим и дали е махнал правилният
    }

    //тест на прайвът сетър
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithInvalidCapacityThrow() {
        Spaceship spaceship = new Spaceship("BBB", -2);
    }

    @Test
    public void testSetCapacityHappyPath() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    //тестване на прайвът сетър
    @Test(expected = NullPointerException.class)
    public void testSetNameWithNullNameThrow() {
        Spaceship spaceship = new Spaceship(null, 2);
    }

    //тестване на прайвът сетър
    @Test(expected = NullPointerException.class)
    public void testSetNameWithEmptyNameThrow() {
        Spaceship spaceship = new Spaceship("", 2);
    }

    //тестване на прайвът сетър
    @Test(expected = NullPointerException.class)
    public void testSetNameWithNameWithSpacesThrow() {
        Spaceship spaceship = new Spaceship("      ", 2);
    }

    @Test
    public void testSetNameHappyPath() {
        Spaceship spaceship = new Spaceship("BBB", 2);
        Assert.assertEquals("BBB", spaceship.getName());
    }
}

