package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;    //accessible only by the base class
    private Collection<Beverages> beverages;        //accessible only by the base class
    private int number;                             //the table number
    private int size;                               //the table size
    private int numberOfPeople;                     //the counter of people who want a table
    private double pricePerPerson;                  //the price per person for the table
    private boolean isReservedTable;                //returns true if the table is reserved, otherwise false
    private double allPeople;                       //calculates the price for all people

    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
    }

    private void setSize(int size) {

        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        //the counter of people who want a table
        //It can’t be less than or equal to 0. In these cases, throw an IllegalArgumentException with the message "Cannot place zero or less people!"

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    //този метод аз го създавам, няма го в условието
    private void calculateAllPeople() {
        this.allPeople = this.numberOfPeople * this.pricePerPerson;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        //Reserves the table with the counter of people given.

        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
        calculateAllPeople();
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        //Orders the provided healthy food (think of a way to collect all the healthy food which is ordered).

        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        //Orders the provided beverages (think of a way to collect all the beverages which are ordered).

        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        //Returns the bill for all orders

        double healthyFoodBill = healthyFood.stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();

        double beveragesBill = beverages.stream()
                .mapToDouble(s -> s.getPrice() * s.getCounter())
                .sum();

        return healthyFoodBill + beveragesBill + this.allPeople;
    }

    @Override
    public void clear() {
        //Removes all the ordered drinks and food and finally frees the table, the table is not reserved, sets the count of people and price to 0.

        this.beverages.clear();
        this.healthyFood.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        calculateAllPeople();
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();

        // sb.append(String.format("Table - %d", this.number)).append(System.lineSeparator());

        sb.append(String.format("Table - %d%n", this.number));
        sb.append(String.format("Size - %d%n", this.size));
        sb.append(String.format("Type - %s%n", this.getClass().getSimpleName()));
        sb.append(String.format("All price - %f%n", this.pricePerPerson));

        return sb.toString();
    }
}
