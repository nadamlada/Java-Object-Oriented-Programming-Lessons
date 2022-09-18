import java.util.Scanner;

/*
Write a program that reads an integer number and calculates and prints its square root (with 2 digits after the decimal point). If the number is invalid, print "Invalid number". In all cases finally, print "Goodbye". Use try-catch-finally.
 */

public class L02SquareRoot {

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();

            try {
                int newNum = Integer.parseInt(number);

                if (newNum >= 0) {
                    double sqrt = Math.sqrt(newNum);
                    System.out.printf("%.2f%n", sqrt);
                } else {
                    String e = "Invalid";
                    throw new IllegalArgumentException(e);
                }

            } catch (Exception e) {
                System.out.println("Invalid");
            } finally {
                System.out.println("Goodbye");
            }
        }
    }
}
