import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final Game game1 = new Game(22, 8, 2021, 13, 30, "xyz", "Jake", "Amy");

    @Test
    void getDate() {
        assertEquals(game1.getDate(), "2021-08-22 01:30");
    }

    @Test
    void setDate() {
        game1.setDate(14, 11, 2022, 14, 45);
        assertEquals(game1.getDate(), "2022-11-14 02:45");
    }

    @Test
    void getCourt() {
        assertEquals(game1.getCourt(), "xyz");
    }

    @Test
    void setCourt() {
        game1.setCourt("abc");
        assertEquals(game1.getCourt(), "abc");
    }

    @Test
    void getPlayers() {
        assertTrue(game1.getPlayers().contains("Jake"));
        assertTrue(game1.getPlayers().contains("Amy"));
    }

    @Test
    void getBio() {
        assertEquals(game1.getBio(), "Date/Time: " + "2021-08-22 01:30" + " Players: " + "[Jake, Amy]");
    }

    @Test
    void main() {
    }
}