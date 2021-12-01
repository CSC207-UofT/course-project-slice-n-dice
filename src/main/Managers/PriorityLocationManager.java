package Managers;
// Developed by Rahul Jaideep

import Managers.Manageable;
import Managers.Manager;
import MatchingAlgoHelpers.MatchMaker;
import MatchingAlgoHelpers.Scheduler;

// Subclass of Manager - prioritizes score by location
public class PriorityLocationManager extends Manager {

    public PriorityLocationManager(MatchMaker mm1, Scheduler ss1) {
        super(mm1, ss1);
    }

        public double returnIndexedScorePriority(Manageable user1, Manageable user2){
            return getMatchableScoreLocation(user1, user2);
        }
}
