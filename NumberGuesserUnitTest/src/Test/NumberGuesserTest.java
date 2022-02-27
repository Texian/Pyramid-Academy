//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.*;
//
//class NumberGuesserTest {
//
//    Player player;
//
//    @BeforeEach
//    void setUp() {
//        System.out.println("Instantiating a test");
//        player = new Player("Helen", 14, "y");
//    }
//
//    @DisplayName("Group Test")
//    @Test
//    void groupTest() {
//        player.setName("Helen");
//        player.setGuess(18);
//        player.setAgain("y");
//        assertAll("Testing",
//                () -> assertEquals("User", player.getName(), "Not a valid name"),
//                () -> assertEquals(3, player.getGuess(), "Not a valid number"),
//                () -> assertEquals("y", player.getAgain(), "Not a valid input"));
//
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Test is complete");
//    }
//}