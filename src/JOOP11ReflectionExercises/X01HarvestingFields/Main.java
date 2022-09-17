package harvestingFields;

/*
You are given a RichSoilLand class with lots of fields (look at the provided skeleton). Like the good farmer you are, you must harvest them. Harvesting means that you must print each field in a certain format (see output).
Input
You will receive a maximum of 100 lines with one of the following commands:
•	private - print all private fields
•	protected - print all protected fields
•	public - print all public fields
•	all - print ALL declared fields
•	HARVEST - end the input
Output
For each command you must print the fields that have the given access modifier as described in the input section. The format in which the fields should be printed is:
"{access modifier} {field type} {field name}"
 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"HARVEST".equals(input)) {

            switch (input) {
                case "public":
//                    Arrays.stream(declaredFields)
//                            .filter(declaredField -> Modifier.isPublic(declaredField.getModifiers()))
//                            .forEach(declaredField -> {
//                                System.out.printf("%s %s %s",
//                                        Modifier.toString(declaredField.getModifiers()),
//                                        declaredField.getType().getSimpleName(),
//                                        declaredField.getName()
//                                );
//                            });

                    for (Field declaredField : declaredFields) {
                        int modifier = declaredField.getModifiers();

                        if (Modifier.isPublic(modifier)) {
                            //declaredField.getType() -> връща клас
                            //declaredField.getType().getSimpleName() -> връща името на класа
                            //Modifier.toString(declaredField.getModifiers()) -> връща модифайъра като стринг
                            print(declaredField);
                        }
                    }

                    break;

                case "private":

                    for (Field declaredField : declaredFields) {
                        int modifier = declaredField.getModifiers();

                        if (Modifier.isPrivate(modifier)) {
                            print(declaredField);
                        }
                    }

                    break;

                case "protected":

                    for (Field declaredField : declaredFields) {
                        int modifier = declaredField.getModifiers();

                        if (Modifier.isProtected(modifier)) {
                            print(declaredField);
                        }
                    }

                    break;

                case "all":
                    for (Field declaredField : declaredFields) {
                        print(declaredField);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void print(Field declaredField) {
        System.out.printf("%s %s %s%n",
                Modifier.toString(declaredField.getModifiers()),
                declaredField.getType().getSimpleName(),
                declaredField.getName()
        );
    }
}
