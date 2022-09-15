package L01CarShop;

/*
Build hierarchy from classes and interfaces for this UML diagram:

<<inteface>>
<<Car>>
+TIRES: Integer
+getModel(): String
+getColor(): String
+getHorsePower(): Integer
+countryProduced(): String
<<Serializable>>

Seat
+toString(): String

Your hierarchy has to be used with this code.
 */

public class Main {
    public static void main(String[] args) {
        Car seat = new Seat("Leon", "gray", 110, "Spain");

        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                seat.getModel(),
                seat.getColor(),
                seat.getHorsePower()));
        System.out.println(seat.toString());
    }
}
