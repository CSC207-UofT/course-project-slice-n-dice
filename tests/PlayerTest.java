import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    ArrayList<String> avail = new ArrayList<String>();
    private final Player player1 = new Player("janedoe12", 22, "I know tennis.", 133.4, 89.02, avail, 5, "6479837765");

    @Test
    void getUsername() {
        assertEquals(player1.getUsername(), "janedoe12");
    }

    @Test
    void getBio() {
        assertEquals(player1.getBio(), "I know tennis.");
    }

    @Test
    void getAge() {
        assertEquals(player1.getAge(), 22);
    }

    @Test
    void getLocation() {
        assertEquals(player1.getLocation(), new double[]{133.4, 89.02});
    }

    @Test
    void getAvailability() {
    }

    @Test
    void getSkill() {
    }

    @Test
    void getPhoneNumber() {
    }

    @Test
    void getSchedule() {
    }

    @Test
    void setSwipedUsers() {
    }

    @Test
    void getSwipedUsers() {
    }
}