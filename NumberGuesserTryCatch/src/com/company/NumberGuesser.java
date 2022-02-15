package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class NumberGuesser {
    static class badChoiceException extends Exception {
        public badChoiceException(String message) {
            super(message);
        }
    }

    static class numberChoice {
        public int whichNum() throws badChoiceException {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int guess = input.nextInt();
                return guess;
            } else {
                throw new badChoiceException("That was an invalid choice. Choose a NUMBER between 1 and 20.");
            }
        }
    }

    static class newGame {
        public String playAgain() throws badChoiceException {
            String play = String.valueOf(new Scanner(System.in).next().charAt(0)).toLowerCase(Locale.ROOT);
            if (!play.equals("y") && !play.equals("n")) {
                throw new badChoiceException("Pardon? I didn't understand that.");
            } else {
                return play;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello there. What's your name?");
        String name = new Scanner(System.in).next();
        int guess = 0, guessCount = 0, secretNum = randomizer();
        System.out.println("Welcome, " + name + "! I'm thinking of a number between 1 and 20. What is it?");
        numberGuesser(guess, guessCount, secretNum);
    }

    public static void numberGuesser(int guess, int guessCount, int secretNum) {
        numberChoice thatNumber = new numberChoice();
        System.out.println("Sanity check - Guesser " + secretNum); // To see the secret number
        do{
            try {
                guessCount++;
                guess = thatNumber.whichNum();
                if (guess > secretNum) {
                    System.out.println("Too high. Guess again.");
                } else if (guess < secretNum) {
                    System.out.println("Too low. Guess again.");
                }
            } catch (badChoiceException e) {
                System.out.println(e.getMessage());
                numberGuesser(guess, guessCount, secretNum);
            }
        } while (guess != secretNum);
        System.out.println("You got it! The number was " + secretNum + ". " + "It took you " + guessCount + " guesses. Would you like to play again? (y/n)");
        again();
    }

    public static int randomizer() {
        int min = 1, max = 20, range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void again() {
        newGame anotherRound = new newGame();
        try {
            switch (anotherRound.playAgain()) {
                case "y":
                    System.out.println("Ok! What number is it this time?");
                    int guess = 0, guessCount = 0, secretNum = randomizer();
                    numberGuesser(guess, guessCount, secretNum);
                case "n":
                    System.out.println("Alright, another time then.");
                    System.exit(0);
            }
        } catch (badChoiceException e) {
            System.out.println(e.getMessage());
            again();
        }
    }
}