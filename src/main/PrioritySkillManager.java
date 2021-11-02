import java.util.ArrayList;
import java.util.Arrays;

public class PrioritySkillManager extends Manager{

    public PrioritySkillManager(MatchMaker mm1, Scheduler ss1) {
        super(mm1, ss1);
    }

    public double returnIndexedScorePriority(Manageable user1, Manageable user2){
        return getMatchableScoreSkill(user1, user2);
    }
}