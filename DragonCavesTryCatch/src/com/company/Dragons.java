package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Dragons {
    static class badChoiceException extends Exception {
        public badChoiceException(String message) {
            super(message);
        }
    }

    static class caveChoice {
        public String whichCave() throws badChoiceException {
            String cave = String.valueOf(new Scanner(System.in).next().charAt(0)).toLowerCase(Locale.ROOT);
            if (!cave.equals("1") && !cave.equals("2")) {
                throw new badChoiceException("That is not an option available to you.");
            } else {
                return cave;
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
        String introText = "" +
                "You are in a land full of dragons." +
                "\nIn front of you are two caves." +
                "\nIn 1 is a friendly dragon who will share his treasure." +
                "\nIn the other, a hungry dragon who will eat all trespassers.";
        System.out.println(introText);
        dragonCaves();
    }

    public static void dragonCaves() {
        // User input
        System.out.println("\n Which cave will you go in to? (1 or 2?)");
        caveChoice thatCave = new caveChoice();
        try {
            switch (thatCave.whichCave()) {
                case "1": // Friendly Dragon
                    System.out.println("Gleeful to see you, they share their horde!");
                    again();
                case "2": // Hungry Dragon
                    System.out.println("Delighted to see you, they invite you inside...their stomach!");
                    again();
            }
        } catch (badChoiceException e)   {
            System.out.println(e.getMessage());
            dragonCaves();
        }
    }

    public static void again() {
        System.out.println("Explore a different cave?");
        newGame anotherRound = new newGame();
        try {
            switch (anotherRound.playAgain()) {
                case "y":
                    System.out.println("Let's try again...");
                    dragonCaves();
                case "n":
                    System.out.println("That's a wise decision.");
                    System.exit(0);
            }
        } catch (badChoiceException e) {
            System.out.println(e.getMessage());
            again();
        }
    }
}
