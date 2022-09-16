package L03Animals;

public class Dog extends Animal {
    //викам суперконструктора от енимал
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favourite food is %s%nDJAAF",
                super.name, super.favouriteFood);
    }
}
