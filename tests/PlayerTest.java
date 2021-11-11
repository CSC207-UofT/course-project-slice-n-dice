import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    static ArrayList<String> avail = new ArrayList<String>();

    private final Player player1 = new Player("janedoe12", 22, "I know tennis.", 133.4,
            89.02, avail, 5, "6479837765");

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
        assertArrayEquals(player1.getLocation(), new double[]{133.4, 89.02});
    }

    @Test
    void getAvailability() {
        avail.add("Monday");
        avail.add("Friday");
        assertTrue(player1.getAvailability().contains("Monday"));
        assertTrue(player1.getAvailability().contains("Friday"));
    }

    @Test
    void getSkill() {
        assertEquals(player1.getSkill(), 5);
    }

    @Test
    void getPhoneNumber() {
        assertEquals(player1.getPhoneNumber(), "6479837765");
    }

    @Test
    void getSchedule() {
        avail.add("Sunday");
        assertTrue(player1.getSchedule().contains("Monday"));
        assertTrue(player1.getSchedule().contains("Friday"));
        assertTrue(player1.getSchedule().contains("Sunday"));
    }

    @Test
    void setSwipedUsers() {
        Player playertemp = new Player("jack", 19, "I know tennis well.", 193.0,
                99.07, avail, 3, "6679887385");
        player1.setSwipedUsers(playertemp);
        assertTrue(player1.getSwipedUsers().contains("jack"));
    }

    @Test
    void getSwipedUsers() {
        Player playertemp1 = new Player("jim", 15, "Tennis is my life.", 143.03,
                134.7, avail, 4, "6978887380");
        player1.setSwipedUsers(playertemp1);
        assertTrue(player1.getSwipedUsers().contains("jim"));
    }
}