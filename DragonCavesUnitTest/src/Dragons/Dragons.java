import java.util.Locale;
import java.util.Scanner;

public class Dragons {
    static class badChoiceException extends Exception {
        public badChoiceException(String message) {
            super(message);
        }
    }

    Player player;
    public static void main(String[] args) {
        introText();  // Start
        Dragons game = new Dragons();
        game.dragonCaves(); // Game
        Dragons again = new Dragons();
        again.again(); // Replay
    }

    public static void introText() {
        String introText = "" +
                "You are in a land full of dragons." +
                "\nIn front of you are two caves." +
                "\nIn 1 is a friendly dragon who will share his treasure." +
                "\nIn the other, a hungry dragon who will eat all trespassers.";
        System.out.println(introText);
    }

    public void dragonCaves() {
        System.out.println("\n Which cave will you go in to? (1 or 2?)");
        int thatCave = (int) new Scanner(System.in).nextInt();
        player = new Player();
        try {
            // First validate the input
            if (thatCave != 1 && thatCave!=2) {
                throw new badChoiceException("That is not an option available to you.");
            } else {
                // If it's good, move on to the results
                switch (thatCave) {
                    case 1: // Friendly Dragon
                        System.out.println("Gleeful to see you, they share their horde!");
                        again();
                    case 2: // Hungry Dragon
                        System.out.println("Delighted to see you, they invite you inside...their stomach!");
                        again();
                }
            }
        } catch (badChoiceException e) {  // For bad input or errors that slip past the if statement
            System.out.println(e.getMessage());
            dragonCaves(); // Try the block again
        }
    }

    public void again() { // Just like the previous block
        System.out.println("Explore a different cave?");
        char play = new Scanner(System.in).next().charAt(0);
        try {
            if (play != 'y' && play != 'n') {
                throw new badChoiceException("Pardon? I didn't understand that.");
            } else {
                switch (play) {
                    case 'y':
                        System.out.println("Let's try again...");
                        dragonCaves();
                    case 'n':
                        System.out.println("That's a wise decision.");
                        System.exit(0);
                }
            }
        } catch (badChoiceException e) {
            System.out.println(e.getMessage());
            again();
        }
    }
}
