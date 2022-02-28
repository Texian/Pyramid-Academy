import java.io.*;
import java.util.*;

public class Hangman {
    static Hangman game = new Hangman();
    Graphic graphic = new Graphic();

    // Importing the word list from a file
    public ArrayList<String[]> wordList() throws IOException {
        ArrayList<String[]> wordList = new ArrayList<>();
        try {
            String file = "src/nouns-in-english.csv";
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNext()) {
                wordList.add(scanner.nextLine().split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Word file not found: " + e);
            return null;
        }
        return wordList;
    }


    public static void main(String[] args) throws IOException {
        // Instantiating the class, adding letters and words to arrays
        game.intro();;
        ArrayList<String[]> words = game.wordList(); // Importing the word list from a file, creating an array
        char[] wordArray = gameStart(words).toCharArray(); //Passing the word list to get a random word
        char[] letters = new char[26]; // Empty array for the guessed letters
        game.gameLoop(wordArray, letters); //Passing in the word as an array of characters, and letters
    }

    public void intro() {
        System.out.println("Welcome to Hangman!");
        System.out.println("You know this game:\n" +
                "Guess the word one letter at a time.\n" +
                "Guess right, and it's revealed. Guess wrong, and the hangman gets one step closer to being hanged.\n" +
                "If you complete the word before he's hanged, you win!\n" +
                "Good luck!");
    }

    public static String gameStart(ArrayList<String[]> words) throws IOException {
        int size = words.size();
        int random = (int) (Math.random() * size) + 1;
        return words.get(random)[0];
    }

    public void gameLoop(char[] wordArray, char[] letters) {
        // Drawing the letter blanks for the word
        char blank = '_';
        char[] blanks = new char[wordArray.length];
        Arrays.fill(letters,' ');
        Arrays.fill(blanks, blank);
        boolean win = false;

        do {
            graphic.draw();
            System.out.println(Arrays.toString(blanks));
            System.out.println(Arrays.toString(letters));

            System.out.println("What's your guess?");
            char input = new Scanner(System.in).next().charAt(0);
            char guess = Character.toLowerCase(input);

            // Checking for letter re-use
            if (new String(letters).indexOf(guess) != -1) {
                System.out.println("You've guessed that letter. Try again.");
            } else { // Else, that letter is added to the array
                for (int i = 0; i <= letters.length - 1; i++) {
                    if (letters[i] == ' ') {
                        letters[i] = guess;
                        break;
                    }
                }
            }
            boolean matchFound = false;
            // Checking to see if the letter is in the word
            for (int i = 0; i <= wordArray.length - 1; i++) {
                if (guess == wordArray[i]) {
                    matchFound = true;
                    blanks[i] = guess;
                }
            }
            if (matchFound) {
                System.out.println("You guessed right!");
                win = Arrays.equals(wordArray, blanks);
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
            String word = new String(wordArray);
            System.out.println("The word was " + word);
            again();
        } while ( !win && !(graphic.lives >= 0));
    }

    void again() {
        System.out.println("Would you like to play again? (y/n)");
        String choice = String.valueOf(new Scanner(System.in).next().charAt(0)).toLowerCase(Locale.ROOT);

        switch (choice) {
            case "y":
                System.out.println("Ok! Lets get a new word!");
                intro();
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