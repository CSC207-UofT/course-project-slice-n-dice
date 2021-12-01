import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PriorityLocationManagerTest {

    MatchMaker matchMaker1 = new MatchMaker();
    Scheduler scheduler1 = new Scheduler();
    PriorityLocationManager plm1 = new PriorityLocationManager(matchMaker1, scheduler1);
    static ArrayList<String> avail1 = new ArrayList<String>();
    static ArrayList<String> avail2 = new ArrayList<String>();

    Player p = new Player("janedoe12", 22, "I know tennis.", 133.4,
            89.02, avail1, 5, "6479837765");

    Player q = new Player("jack", 26, "I know tennis.", 163.4,
            109.02, avail2, 3, "6479837765");

    @Test
    void returnIndexedScorePriority() {
        assertEquals(plm1.getMatchableScoreLocation((Manageable) p, (Manageable) q), 10.013878188659973);
    }
}