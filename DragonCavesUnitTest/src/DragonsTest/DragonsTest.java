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

    @DisplayName("Intro text test")
    @Test
    void introText() {
        System.out.println("Testing");
    }

    @DisplayName("Dragon Caves test")
    @Test
    void dragonCaves() {
        assertEquals(1, 1, "Should be 1");
    }

    @DisplayName("Play again test")
    @Test
    void again() {
        assertEquals('y', 'y', "Should be y");
    }

    @AfterEach //runs after each individual test
    void tearDown() {
        System.out.println("This test complete");
    }

    @AfterAll
    public static void afterAll(){System.out.println("All tests concluded.");}
}