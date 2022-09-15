package L04SayHelloExtended;

public abstract class BasePerson implements Person {
    private String name;

    //абстрактен клас не може да с е инициалицира, няма смисъл конструктора да е пълбик
    //протектед конструктор го виждат само наследниците
    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
