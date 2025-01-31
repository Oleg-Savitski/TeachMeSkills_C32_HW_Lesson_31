package patterns.iterator.app;

import patterns.iterator.collections.impl.MagicalZoo;
import patterns.iterator.entities.MagicalCreature;
import patterns.iterator.logic.CustomIterator;

import java.util.List;
import java.util.Scanner;

/**
 * The iterator's work on the example of a Magic Zoo.
 */

public class ApplicationRunner {
    public static void main(String[] args) {
        List<MagicalCreature> creatures = List.of(

                new MagicalCreature("Dragon", "Fire-breathing Ball", "Spewing flames"),
                new MagicalCreature("Phoenix", "Dumbledore's Firebird", "Reborn from the Ashes"),
                new MagicalCreature("Unicorn", "Magic Horse", "Heals wounds"),
                new MagicalCreature("Griffin", "Winged Lion of Gryffindor", "Guards treasures"),
                new MagicalCreature("Hypogriff", "The proud bird", "The claws are razor sharp"),
                new MagicalCreature("The Flaubert Worm", "Omnivorous", "It is not dangerous"),
                new MagicalCreature("The Fallen Lord Voldemort", "A dangerous wizard. Unleashed the second magical War", "Eliminated. The horcruxes are destroyed")
        );


        MagicalZoo zoo = new MagicalZoo(creatures);


        System.out.println("Welcome to the Hogwarts Magical Zoo!");
        System.out.println("Press 'n' -> to see the next creature, 'p' -> for the previous one, or -> 'q' to exit.");

        Scanner scanner = new Scanner(System.in);
        CustomIterator<MagicalCreature> iterator = zoo.iterator();

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("The tour is over. Goodbye! Ha Hagrid will take you to the Hogwarts Express");
                break;
            } else if (input.equalsIgnoreCase("n")) {
                if (iterator.hasNext()) {
                    MagicalCreature creature = iterator.next();
                    System.out.println(creature);
                } else {
                    System.out.println("This is the last creature in the zoo.");
                }
            } else if (input.equalsIgnoreCase("p")) {
                if (iterator.hasPrevious()) {
                    MagicalCreature creature = iterator.previous();
                    System.out.println(creature);
                } else {
                    System.out.println("This is the first animal in the zoo.");
                }
            } else {
                System.out.println("Wrong command. Please use 'n', 'p' or 'q'.");
            }
        }
        scanner.close();
    }
}