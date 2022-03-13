import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    static Hangman game = new Hangman();
    Graphic graphic = new Graphic();

    public static void main(String[] args) throws IOException {
        game.intro();
        game.gameLoop(); //Passing in the word as an array of characters, and letters
    }

    // Intro text, sanity check that proves the game is running
    public void intro() {
        System.out.println("Welcome to Hangman! What's your name?");
        String name = new Scanner(System.in).nextLine();
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

    public void gameLoop() throws IOException {
        // List of guessed letters, and the word as a list of characters
        ArrayList<Character> alphabet = new ArrayList<>(Collections.nCopies(26, '_'));
        List<Character> wordArray = new ArrayList<>(Objects.requireNonNull(wordArray()));

        // List of blanks for the word
        char blank = '_';
        List<Character> wordBlanks = new ArrayList<>(Collections.nCopies(wordArray.size(), blank));
        // Game loop initializations
        int score = 0;
        boolean win = false;

        /* Generate a 60-character sized array with 60 different characters; example of stream generation
        List<Person> persons = Stream.generate(Person::new)
                .limit(60)
                .collect(Collectors.toList()); */

        // Lone while loop to keep the game running
        while (!win && !(graphic.lives >= 0)) {
            //TODO Replace image and letters with actual images instead of ASCII
            graphic.draw();
            System.out.println(wordBlanks);
            System.out.println(alphabet);

            System.out.println("What's your guess?");
            char input = new Scanner(System.in).next().charAt(0);
            List<Character> guess = new ArrayList<>(input);

            // Checking for letter re-use
            if (String.valueOf(alphabet).contains(guess.toString())) {
                System.out.println("You've guessed that letter. Try again.");
            } else { // Else, that letter is added to the array
                alphabet.stream()
                        .map(guess::add);
            }

            boolean matchFound = false;
            // Checking to see if the letter is in the word
            wordArray.stream()
                    .map(guess::contains)
                    .collect(Collectors.toList());

            for (int i = 0; i <= wordArray.size() - 1; i++) {
                if (guess == wordArray.get(i)) {
                    matchFound = true;
                    wordBlanks[i] = guess;
                }
            }
            if (matchFound) {
                System.out.println("Correct!");
                win = Arrays.equals(wordArray, wordBlanks);
            } else {
                System.out.println("You guessed wrong!");
                graphic.next();
            }
            ;

            // Endgame
            if (graphic.lives == -1) {
                System.out.println("Your luck has run out. You lose.");
            } else {
                System.out.println("Congratulations! guessed the word!");
            }
            String word = String.valueOf(wordArray);
            System.out.println("The word was " + word + "\nAnd your final score is: " + score);
            again();
        }
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