import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    static Hangman game = new Hangman();
    public static class Scoreboard {
        public String name;
        public int score;
        public Scoreboard(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Hangman! What's your name?");
        String name = new Scanner(System.in).nextLine();
        game.intro(name);
        game.gameLoop(name); //Passing in the word as an array of characters, and letters
    }

    // Intro text, sanity check that proves the game is running
    public void intro(String name) {
        System.out.println("You know this game, " +name+ ":\n" +
                "Guess the word one letter at a time.\n" +
                "Guess right, it's revealed and you score some points.\n" +
                "Guess wrong, and the hangman gets one step closer to being hanged.\n" +
                "If you complete the word in time, you win!\n" +
                "Good luck!");
    }

    // Importing the word list from a file, picking a random word, returning as character list
    public static List<Character> wordArray() throws IOException {
        try {
            String input = String.valueOf(Files.lines(Paths.get("src/nouns-in-english.csv")));
            long random = (long) (Math.random() * input.length()) + 1;
            String word = input.lines().skip(random).toString();
            // Letters to list, trimming comma off the end
            return Collections.singletonList(word.chars().mapToObj(l -> (char) l).collect(Collectors.toList()).remove(word.length() - 1));
        } catch (FileNotFoundException e) {
            System.out.println("Word list not found: " + e);
        }
        return null;
    }

    public void gameLoop(String name) throws IOException {
        char blank = '_';
        int lives = 8;
        int score = 0;
        boolean win = false;

        ArrayList<Character> alphabet = new ArrayList<>(Collections.nCopies(26, '_'));
        List<Character> wordArray = new ArrayList<>(Objects.requireNonNull(wordArray()));
        List<Character> wordBlanks = new ArrayList<>(Collections.nCopies(wordArray.size(), blank));

        Stream<Character> alphabetStream = alphabet.stream();
        Stream<Character> wordArrayStream = wordArray.stream();
        Stream<Character> wordBlanksStream = wordBlanks.stream();

        // Lone while loop to keep the game running
        while (!win && !(lives >= 0)) {
            //TODO Replace image and letters with actual images instead of ASCII

            System.out.println(wordBlanks);
            System.out.println(alphabet);

            System.out.println("What's your guess?");
            char guess = new Scanner(System.in).next().charAt(0);

            // Checking for letter re-use
            if (alphabet.stream().anyMatch(c -> c.equals(guess))) {
                System.out.println("You've guessed that letter. Try again.");
            } else { // Else, that letter is added to the array
                alphabet.add(guess);
            }

            boolean matchFound = false;
            // Checking to see if the letter is in the word
            if (wordArray.stream().anyMatch(c -> c.equals(guess))) {
                wordBlanks.replaceAll(c -> guess);
                score++;
                win = wordBlanks.stream().allMatch(c -> c.equals(wordArray.get(c)));
            } else {
                System.out.println("You guessed wrong!");
                images.next();
            }

            // Endgame
            if (graphic.lives == -1) {
                System.out.println("Your luck has run out. You lose.");
            } else {
                System.out.println("Congratulations! guessed the word!");
            }
            highScore(name, score);
            String word = String.valueOf(wordArray);
            System.out.println("The word was " + word + "\nAnd your final score is: " + score);

            again();
        }
    }

    private void highScore(String name, int score) {
        name = name;
        score = score;
    }

    void again() throws IOException {
        System.out.println("Would you like to play again? (y/n)");
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0)).toLowerCase(Locale.ROOT);

        switch (choice) {
            case "y":
                System.out.println("Ok! Lets get a new word!");
                gameLoop();
                break;
            case "n":
                System.out.println("Alright, another time then.");
                System.exit(0);
                break;
            default:
                System.out.println("Pardon? I didn't understand that.");
                again();
        }
    }
}


/*
Reimplement hangman.

Limitations/differences from before:

-No loops are allowed except for the main game loop,
which is a single while loop. All looping must be
subsumed through map, filter, and reduce.

-The art for hangman should be read from a file, this art
connotates the state of the game.

-The user should be able to enter their name, where their
name and score will be recorded to a file after each
game.

-The game will tell the user if they have the high score or
not.

- no exceptions are allowed, all exceptions must be
caught by the program.

Add unit testing to your project.
 */