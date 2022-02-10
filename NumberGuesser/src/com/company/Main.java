package com.company;

import java.util.Locale;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String args) {
        System.out.println("Hello there. What's your name?");
        String name = new Scanner(System.in).next();
        int secretNum = randomizer();
        int guesses = 0;
        System.out.println("Welcome, " + name + "! I'm thinking of a number between 1 and 20. Can you guess it?");
        int guess = new Scanner(System.in).nextInt();
        do {
            guesses++;
            if (guess > secretNum) {
                System.out.println("Too high. Guess again.");
                guess = new Scanner(System.in).nextInt();
            } else if (guess < secretNum) {
                System.out.println("Too low. Guess again.");
                guess = new Scanner(System.in).nextInt();
            } else if (guess == secretNum) {
                System.out.println("You got it! The number was " + secretNum + ". " +
                        "It took you " + guesses + " guesses." +
                        "Would you like to play again?");
                again(name);
            }
        } while (true);
    }

    public static int randomizer() {
        int min = 1, max = 20, range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void again(String name) {
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0));
        do {
            switch (choice.toLowerCase(Locale.ROOT)) {
                case "y":
                    System.out.println("Let's play again " + name + ".");
                    main(name);
                case "n":
                    System.out.println("That's a wise decision.");
                    System.exit(0);
                default:
                    System.out.println("Sorry, didn't quite catch that?");
                    again(name);
            }
        } while (true);
    }
}