package petStore;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {


    //проверка за ънмодифайъбъл лист
    @Test (expected = UnsupportedOperationException.class)
    public void testGetAnimalsShouldReturnUnmodifiableList () {
        PetStore petStore = new PetStore();
        List<Animal> animals = petStore.getAnimals();
        animals.remove(0);
    }

    @Test
    public void testGetCountShouldReturnZeroWhenEmpty() {
        PetStore petStore = new PetStore();
        Assert.assertEquals(0, petStore.getCount());

        Animal animal1 = new Animal("dog", 10, 10);
        petStore.addAnimal(animal1);

        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsShouldReturnEmptyListWhenThereISNoSuchAnimal(){
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("dog", 10, 10);
        petStore.addAnimal(animal1);

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(11);
        Assert.assertTrue(animals.isEmpty());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilogramsShouldReturnHeavier(){
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("dog", 10, 10);
        Animal animal2 = new Animal("cat", 5, 5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(1);
        Assert.assertEquals(2, animals.size());
        //assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrow() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void testAddAnimalShouldIncreaseCount (){
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("dog", 10, 10);
        petStore.addAnimal(animal1);

        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnNull() {
        PetStore petStore = new PetStore();
        Animal animal = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(animal);
    }

    //    @Test
    //    public void test_GetTheMostExpensiveAnimal_Should_Return_TheMostExpensiveOne() {
    //        petStore.addAnimal(animal);
    //        petStore.addAnimal(new Animal(SPECIE, MAX_WEIGHT, PRICE - 10));
    //        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
    //        assertEquals(animal.getPrice(), actualAnimal.getPrice(), 0.00);
    //    }

    @Test
    public void testGetTheMostExpensiveAnimalReturnsTheMostExpensive() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("dog", 10, 10);
        Animal animal2 = new Animal("cat", 5, 5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        Animal expensiveAnimal = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(animal1, expensiveAnimal);
    }

    @Test
    public void testFindAllAnimalBySpecie (){
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("dog", 10, 10);
        Animal animal2 = new Animal("cat", 5, 5);
        Animal animal3 = new Animal("dog", 15, 15);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        List<Animal> allAnimalBySpecie = petStore.findAllAnimalBySpecie("dog");
        Assert.assertEquals(2, allAnimalBySpecie.size());

        //проверяваме дали е точно от кучета
        Assert.assertEquals("dog",allAnimalBySpecie.get(0).getSpecie());
    }
}

