package L02SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {

        if (this.age > 30) {
            this.salary = this.salary + this.salary * percentage / 100;
        } else{
            this.salary = this.salary + this.salary * percentage / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva", this.firstName, this.lastName, this.salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
