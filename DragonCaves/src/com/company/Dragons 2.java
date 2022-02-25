package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Dragons {
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
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0));
        do {
            switch (choice.toLowerCase(Locale.ROOT)) {
                case "1": // Friendly Dragon
                    System.out.println("Gleeful to see you, they share their horde!");
                    again();
                case "2": // Hungry Dragon
                    System.out.println("Delighted to see you, they invite you inside...their stomach!");
                    again();
                default: // Invalid input
                    System.out.println("That is not an option available to you.");
                    dragonCaves();
            }
        } while (true);
    }

    public static void again() {
        System.out.println("Explore a different cave?");
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0));
        do {
            switch (choice.toLowerCase(Locale.ROOT)) {
                case "y":
                    System.out.println("Let's try again...");
                    dragonCaves();
                case "n":
                    System.out.println("That's a wise decision.");
                    System.exit(0);
                default:
                    System.out.println("Sorry, didn't quite catch that?");
                    again();
            }
        } while (true);
    }
}
