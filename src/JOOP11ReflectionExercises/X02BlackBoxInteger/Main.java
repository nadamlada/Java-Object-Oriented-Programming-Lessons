package blackBoxInteger;

/*
You are helping a buddy of yours who is still in the OOP Basics course - his name is John. He is rather slow and made a class with all private members. Your tasks are to instantiate an object from his class (always with start value 0) and then invoke the different methods it has. Your restriction is to not change anything in the class itself (consider it a black box). You can look at his class but don't touch anything! The class itself is called BlackBoxInt. It is a wrapper for the int primitive. The methods it has are:

Input
The input will consist of lines in the form:
"{command name}_{value}"
Input will always be valid and in the format described, so there is no need to check it explicitly. You stop receiving input when you encounter the command "END".
Output
Each command (except the "END" one) should print the current value of innerValue of the BlackBoxInt object you instantiated. Don't cheat by overriding toString in the class - you must get the value from the private field.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //взимаме метаинформацията за BlackBoxInt
        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        //викаме си конструктора
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        //създаваме си инстарция на BlackBoxInt
        BlackBoxInt blackBoxInt = constructor.newInstance();

        //достъпване на прайвът поле innerValue и сетване на accessible
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] methodData = input.split("_");
            String methodName = methodData[0];
            int value = Integer.parseInt(methodData[1]);

            //взимаме метод от класа
            Method method = clazz.getDeclaredMethod(methodName,int.class);
            method.setAccessible(true);

            //извикваме метода върху обекта
            method.invoke(blackBoxInt, value);

            //на кой обект искам да принтирам inner value
            //извикване на полето от обект blackBoxInt
            Object data = innerValue.get(blackBoxInt);
            System.out.println(data);

            input = scanner.nextLine();
        }
    }
}
