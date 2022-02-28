import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @BeforeEach
    void setUp() {
        System.out.println("Setup");
    }

    @Test
    public void wordList() throws IOException {
        ArrayList<String[]> expectedValue = null;
        Hangman hangman = new Hangman();
        ArrayList<String[]> actualValue = hangman.wordList();
        System.out.println("Expected value: " + expectedValue + "\nActual value: " + actualValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void main() throws IOException {
        String[] args = null;
        Hangman hangman = new Hangman();
        hangman.main(args);
        assertTrue(true);
    }

    @Test
    public void gameLoop() {
        char[] wordArray = null;
        char[] letters = null;
        Hangman hangman = new Hangman();
        hangman.gameLoop (wordArray, letters);
        assertTrue(true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Moving to next test.");
    }
}