package L05StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    //решение с делегиране
    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {

        if (!data.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }

        return null;
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
