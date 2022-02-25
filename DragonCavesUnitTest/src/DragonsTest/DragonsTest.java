import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DragonsTest {

    Dragons dragons;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Initiating all JUnit tests.");
    }

    @BeforeEach
    void setUp() {
        //instantiates a new dragons object for each individual test
        dragons = new Dragons();
        System.out.println("Initiating a test.");
    }

    @DisplayName("Play again test")
    @Test
    void again() {
        System.out.println(dragons.again("y"));
        assertEquals("y", dragons.again(), "Should be y");
    }

    @AfterEach //runs after each individual test
    void tearDown() {
        System.out.println("This test complete");
    }

    @DisplayName("All tests concluded")
    @AfterAll {
        System.out.println("All tests concluded.");
    }
}