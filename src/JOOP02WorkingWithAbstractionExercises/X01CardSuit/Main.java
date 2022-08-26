package JOOP02WorkingWithAbstractionExercises.X01CardSuit;

/*
Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS, HEARTS, SPADES). Iterate over the values of the enumeration type and print all ordinal values and names.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner (System.in);

        //принтира кой номер в масива е diamonds
        //System.out.println(CardSuits.DIAMONDS.ordinal());

        //принтира името на съответният обект
        //System.out.println(CardSuits.DIAMONDS.name());

        //Arrays.stream(CardSuits.values()).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n", e.ordinal(), e.name()));

        System.out.println("Card Suits:");

        for (CardSuits cardSuits : CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuits.ordinal(),cardSuits.name());
        }
    }
}
