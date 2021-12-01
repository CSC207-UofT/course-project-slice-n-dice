import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatchMakerTest {

    MatchMaker matchMaker1 = new MatchMaker();
    static ArrayList<String> avail = new ArrayList<String>();
    Matchable m1 = new Player("janedoe12", 22, "I know tennis.", 133.4,
                                                       89.02, avail, 5, "6479837765");

    Matchable m2 = new Player("jack", 26, "I know tennis.", 163.4,
            109.02, avail, 3, "6479837765");

    @Test
    void getScoreBase() {
        assertEquals(matchMaker1.getScoreBase(m1, m2)[0], 2);
        assertEquals(matchMaker1.getScoreBase(m1, m2)[1], 36.05551275463989);
    }

    @Test
    void getScoreLocation() {
        assertEquals(matchMaker1.getScoreLocation(m1, m2), 10.013878188659973);
    }

    @Test
    void getScoreSkill() {
        assertEquals(matchMaker1.getScoreSkill(m1, m2), 18.527756377319946);
    }

    @Test
    void getMatchMakerUsernames() {
        assertEquals(matchMaker1.getMatchMakerUsernames(m1, m2)[0], "janedoe12");
        assertEquals(matchMaker1.getMatchMakerUsernames(m1, m2)[1], "jack");
    }

    @Test
    void getSwipedStatus() {
        assertFalse(matchMaker1.getSwipedStatus(m1, m2));
    }
}