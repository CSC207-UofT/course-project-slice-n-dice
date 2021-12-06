import MatchingAlgoHelpers.Schedulable;
import MatchingAlgoHelpers.Scheduler;
import UserData.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {

    Scheduler scheduler1 = new Scheduler();
    static ArrayList<String> avail1 = new ArrayList<String>();
    static ArrayList<String> avail2 = new ArrayList<String>();
    Schedulable s1 = new Player("janedoe12", 22, "I know tennis.", 133.4,
            89.02, avail1, 5, "6479837765");

    Schedulable s2 = new Player("jack", 26, "I know tennis.", 163.4,
            109.02, avail2, 3, "6479837765");

    @Test
    void getCommonTimes() {
        avail1.add("Sunday");
        avail1.add("Friday");
        avail2.add("Sunday");
        avail2.add("Monday");
        assertTrue(scheduler1.getCommonTimes(s1, s2).contains("Sunday"));
        assertFalse(scheduler1.getCommonTimes(s1, s2).contains("Monday"));
        assertFalse(scheduler1.getCommonTimes(s1, s2).contains("Friday"));
    }

    @Test
    void getSchedulableUsernames() {
        assertEquals(scheduler1.getSchedulableUsernames(s1, s2)[0], "janedoe12");
        assertEquals(scheduler1.getSchedulableUsernames(s1, s2)[1], "jack");
    }
}