package X07CollectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String element) {
        super.items.add(element);
        return super.items.indexOf(element);
    }
}
