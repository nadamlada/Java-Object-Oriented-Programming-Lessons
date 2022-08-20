package garage;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    @Test(expected = IllegalArgumentException.class)
    public void test_addCar_whenCarIsNullThrow() {
        Garage garage = new Garage();
        garage.addCar(null);
    }

    @Test
    public void test_addCar_HappyPath() {
        Garage garage = new Garage();
        Car car = new Car("red", 20, 50.0);

        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
        Assert.assertEquals(car, garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_getTheMostExpensiveCar_throwNull() {
        Garage garage = new Garage();
        Assert.assertNull(garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_getTheMostExpensiveCar_HappyPath() {
        Garage garage = new Garage();
        Car car1 = new Car("red", 20, 50.0);
        Car car2 = new Car("blue", 20, 20.0);
        Car car3 = new Car("black", 20, 10.0);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(car1, garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_findAllCarsByBrand_HappyPath() {
        Garage garage = new Garage();
        Car car1 = new Car("red", 20, 50.0);
        Car car2 = new Car("red", 20, 20.0);
        Car car3 = new Car("black", 20, 10.0);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(2, garage.findAllCarsByBrand("red").size());
        Assert.assertTrue(garage.findAllCarsByBrand("red").contains(car1)
                && garage.findAllCarsByBrand("red").contains(car2));
    }

    @Test
    public void test_findAllCarsWithMaxSpeedAbove_HappyPath() {
//        List<Car> expected = List.of(
//                firstCar,
//                secondCar
//        );
//
//        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(CAR_TO_FIND_MAX_SPEED_ABOVE);
//
//        Assert.assertEquals(expected, actual);

        Garage garage = new Garage();
        Car car1 = new Car("red", 20, 50.0);
        Car car2 = new Car("red", 20, 20.0);
        Car car3 = new Car("black", 20, 10.0);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(3, garage.findAllCarsWithMaxSpeedAbove(10).size());
        Assert.assertTrue(garage.findAllCarsWithMaxSpeedAbove(10).contains(car1)
                && garage.findAllCarsWithMaxSpeedAbove(10).contains(car2)
                && garage.findAllCarsWithMaxSpeedAbove(10).contains(car3)
        );
    }

    @Test
    public void test_getCount_HappyPath() {
        Garage garage = new Garage();
        Car car1 = new Car("red", 20, 50.0);
        Car car2 = new Car("pink", 20, 20.0);
        Car car3 = new Car("black", 20, 10.0);

        garage.addCar(car1);
        Assert.assertEquals(1, garage.getCount());
        Assert.assertEquals("red", garage.getCars().get(0).getBrand());


        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
        Assert.assertEquals("pink", garage.getCars().get(1).getBrand());

        garage.addCar(car3);
        Assert.assertEquals(3, garage.getCount());
        Assert.assertEquals("black", garage.getCars().get(2).getBrand());
    }


    @Test (expected = UnsupportedOperationException.class)
    public void test_getCars_happyPath() {
        Garage garage = new Garage();
        Car car1 = new Car("red", 20, 50.0);
        Car car2 = new Car("pink", 20, 20.0);

        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> unmodifiableCollection = garage.getCars();
        unmodifiableCollection.add(car1);
    }
}