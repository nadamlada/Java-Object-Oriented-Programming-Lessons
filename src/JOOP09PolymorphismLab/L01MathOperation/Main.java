package L01MathOperation;

/*
Create a class MathOperation, which should have method add(). Method add() has to be invoked with two, three, or four Integers.
 */

import java.io.IOException;

public class   Main {
    public static void main(String[] args) throws IOException {
        MathOperation math = new MathOperation();
        System.out.println(math.add(2, 2));
        System.out.println(math.add(3, 3, 3));
        System.out.println(math.add(4, 4, 4, 4));
    }
}


