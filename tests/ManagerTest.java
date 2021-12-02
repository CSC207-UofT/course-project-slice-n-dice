import MatchingAlgoHelpers.MatchMaker;
import MatchingAlgoHelpers.Matchable;
import MatchingAlgoHelpers.Schedulable;
import MatchingAlgoHelpers.Scheduler;
import UserData.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    MatchMaker matchMaker1 = new MatchMaker();
    Scheduler scheduler1 = new Scheduler();
    static ArrayList<String> avail1 = new ArrayList<String>();
    static ArrayList<String> avail2 = new ArrayList<String>();

    Player p = new Player("janedoe12", 22, "I know tennis.", 133.4,
            89.02, avail1, 5, "6479837765");

    Player q = new Player("jack", 26, "I know tennis.", 163.4,
            109.02, avail2, 3, "6479837765");


    @Test
    void getMatchableScoreLocation() {
        assertEquals(matchMaker1.getScoreLocation((Matchable) p, (Matchable) q), 10.013878188659973);
    }

    @Test
    void getMatchableScoreSkill() {
        assertEquals(matchMaker1.getScoreSkill((Matchable) p, (Matchable) q), 18.527756377319946);
    }

    @Test
    void getOverlapTimes() {
        avail1.add("Sunday");
        avail1.add("Friday");
        avail2.add("Sunday");
        avail2.add("Monday");
        assertTrue(scheduler1.getCommonTimes((Schedulable) p, (Schedulable) q).contains("Sunday"));
    }

    @Test
    void getSwipeStatusPair() {
        assertFalse(matchMaker1.getSwipedStatus((Matchable) p, (Matchable) q));
        assertEquals(matchMaker1.getSwipedStatus((Matchable) q, (Matchable) p), false);

    }

    @Test
    void returnIndexedScorePriority() {
    }

    @Test
    void getRankedList() {
    }

    @Test
    void bubbleSort() {
    }
}