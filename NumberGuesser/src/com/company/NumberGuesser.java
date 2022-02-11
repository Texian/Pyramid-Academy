package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        System.out.println("Hello there. What's your name?");
        String name = new Scanner(System.in).next();
        System.out.println("Welcome, " + name + "! I'm thinking of a number between 1 and 20. What is it?");
        numberGuesser();
    }

    public static void numberGuesser() {
        Scanner input = new Scanner(System.in);
        int guess = 0, guessCount = 0, secretNum = randomizer();
        //System.out.println("Sanity check - Guesser " + secretNum); // To see the secret number
        do {
            if (input.hasNextInt()) {
                guess = input.nextInt();
                guessCount++;
                if (guess > secretNum) {
                    System.out.println("Too high. Guess again.");
                } else if (guess < secretNum) {
                    System.out.println("Too low. Guess again.");
                }
            } else {
                System.out.println("That's not a number. Guess again.");
                input.next();
            }
        } while(guess !=secretNum);
        System.out.println("You got it! The number was " + secretNum + ". " + "It took you " + guessCount + " guesses." + "Would you like to play again? (y/n)");
        again();

    }

    public static int randomizer() {
        int min = 1, max = 20, range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void again() {
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0));
        do {
            switch (choice.toLowerCase(Locale.ROOT)) {
                case "y":
                    System.out.println("Let's play again! What number is it this time?");
                    numberGuesser();
                case "n":
                    System.out.println("Ok, see you another time.");
                    System.exit(0);
                default:
                    System.out.println("Sorry, didn't quite catch that?");
                    again();
            }
        } while (true);
    }
}