import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    MatchMaker matchMaker1 = new MatchMaker();
    Scheduler scheduler1 = new Scheduler();
    Manager managerObject = new PrioritySkillManager(matchMaker1, scheduler1);
    ArrayList<String> avail1 = new ArrayList<String>();
    ArrayList<String> avail2 = new ArrayList<String>();
    ArrayList<String> availability1 = new ArrayList<String>();
    ArrayList<String> availability2 = new ArrayList<String>();

    Player p = new Player("janedoe12", 22, "I know tennis.", 133.4,
            89.02, avail1, 5, "6479837765");

    Player q = new Player("jack", 26, "I know tennis.", 163.4,
            109.02, avail2, 3, "6479837765");


    Player u1 = new Player("johndoe17", 22, "I love tennis!", 43.663898, -79.387914, availability1, 5, "6473458765");
    Player u2 = new Player("tennisbro123", 17, "tennis rox", 43.663898, -79.387914, availability2, 5, "4165556789");
    Player u3 = new Player("realperson123", 20, "I am a real person who likes tennis", 43.669145, -79.399372, availability1, 3, "6463648999");
    Player u4 = new Player("emma16", 19, "tennis is soooooooo fun", 43.671442, -79.397645, availability2, 2, "5197653487");


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
        assertFalse(matchMaker1.getSwipedStatus((Matchable) q, (Matchable) p));
    }

    @Test
    void getRankedList() {
        ArrayList<Manageable> xyz = new ArrayList<>();
        xyz.add(q);
        xyz.add(u1);
        xyz.add(u2);
        xyz.add(u3);
        xyz.add(u4);
        ArrayList<Manageable> users_in_order = new ArrayList<>();
        users_in_order.add(q);
        users_in_order.add(u1);
        users_in_order.add(u2);
        users_in_order.add(u3);
        users_in_order.add(u4);
        assertEquals(managerObject.getRankedList(p, xyz), users_in_order);
    }
}