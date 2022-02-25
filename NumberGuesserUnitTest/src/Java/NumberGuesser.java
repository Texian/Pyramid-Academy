import java.util.Locale;
import java.util.Scanner;

public class NumberGuesser {

    public static int randomizer() {
        int min = 1, max = 20, range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void main(String[] args) {
        gameStart();
        numberGuesser();
        again();
    }

    static void gameStart() {
        System.out.println("Hello there. What's your name?");
        var name = new Scanner(System.in).next();
        Player player;
        player = new Player();
        player.setName(name);
        System.out.println("Welcome, " + name + "! I'm thinking of a number between 1 and 20. What is it?");
    }

    static void numberGuesser() {
        int guessCount = 0, secretNum = randomizer();
        int guess;
        System.out.println("Sanity check - Guesser " + secretNum); // To see the secret number
        do {
            guessCount++;
            guess = new Scanner(System.in).next().charAt(0);
            if (guess > secretNum) {
                System.out.println("Too high. Guess again.");
            } else if (guess < secretNum) {
                System.out.println("Too low. Guess again.");
            }
        } while (guess != secretNum);
        System.out.println("You got it! The number was " + secretNum + ". " + "It took you " + guessCount + " guesses. Would you like to play again? (y/n)");
    }

    public static void again() {
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0)).toLowerCase(Locale.ROOT);
        switch (choice) {
            case "y":
                System.out.println("Ok! What number is it this time?");
                numberGuesser();
            case "n":
                System.out.println("Alright, another time then.");
                System.exit(0);
            default:
                System.out.println("Pardon? I didn't understand that.");
                again();
        }
    }
}