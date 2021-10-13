import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private MatchMaker matchMakerObject;
    private Scheduler schedulerObject;

//    public Manager(Manageable pairs_players) {
//        if(pairs_players.getSchedulableUsernames() == pairs_players.getUsernames()) {
//            this.pair_of_players.put([pairs_players.getUsernames()[0], pairs_players.getUsernames()[1]], [])
//        }
//    }
//
//    public String randomFunc(Manageable player1, Manageable player2){
//        this.scheduler.getCommonTimes(player1, player2);
//    }

    public Manager(MatchMaker mm1, Scheduler ss1) {
        this.matchMakerObject = mm1;
        this.schedulerObject = ss1;
    }

    public double getMatchableScore(){
        return 0.0;
    }

    public HashMap<String[], Object[]> fReturn(Manageable m1, Manageable m2){
        ArrayList<String> overlap = schedulerObject.getCommonTimes((Schedulable) m1, (Schedulable) m2);
        double matchable_score = matchMakerObject.getScore((Matchable) m1, (Matchable) m2);

        boolean m1SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) m1, (Matchable) m2);
        boolean m2SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) m2, (Matchable) m1);

        boolean[] swipedPair = {m1SwipeStatus, m2SwipeStatus};
    }
}

