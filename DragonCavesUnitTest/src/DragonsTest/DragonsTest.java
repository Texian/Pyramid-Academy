import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonsTest {

    Player player;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Initiating all JUnit tests.");
    }

    @BeforeEach
    void setUp() {
        //instantiates a new dragons object for each individual test
        player = new Player();
        System.out.println("Initiating a test.");
    }

    @DisplayName("Tests")
    @Test
    void groupTests() {
        player.setGuess(1);
        player.setAgain("y");
        assertAll("Testing inputs",
                () -> assertEquals(1, player.getGuess(), "Not a valid choice"),
                () -> assertEquals("y", player.getAgain(), "Not a valid input"));
    }

    @AfterEach //runs after each individual test
    void tearDown() {
        System.out.println("This test complete");
    }

    @AfterAll
    public static void afterAll(){System.out.println("All tests concluded.");}
}