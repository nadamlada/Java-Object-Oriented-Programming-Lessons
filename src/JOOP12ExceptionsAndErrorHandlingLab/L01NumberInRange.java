import java.util.Scanner;

public class L01NumberInRange {
/*
Write a program to enter an integer in a certain range. Until the number is not valid, enter a new number from the console. When the number is valid - end the program.
Input
	Read a range - two numbers, separated by a space.
	On the next line, read the String.
Output
	Print the range in the following format: "Range: [{startIndex}...{endIndex}]".
	When an invalid number is entered, String or the number is out of range, print "Invalid number: {num}".
	When the entered number is valid, print "Valid number: {num}".
 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        int startNumber = Integer.parseInt(data[0]);
        int endNumber = Integer.parseInt(data[1]);

        System.out.printf("Range: [%d...%d]%n", startNumber, endNumber);

        int validNumber = readValidNumber(scanner, startNumber, endNumber);
        System.out.printf("Valid number: %d%n", validNumber);
    }

    private static int readValidNumber(Scanner scanner, int startNumber, int endNumber) {

        //for(;;)
        while (true) {
            String firstInput = scanner.nextLine();

            try {
                int input = Integer.parseInt(firstInput);

                if (startNumber <= input && input <= endNumber) {
                    return input;
                }
            } catch (NumberFormatException e) {

            }

            System.out.printf("Invalid number: %s%n", firstInput);
        }
    }
}