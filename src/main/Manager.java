import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private HashMap<String[], Object[]> pair_of_players = new HashMap<String[], Object[]>();
    private ArrayList<String> schedule_overlap;

    private MatchMaker matchMaker;
    private Scheduler scheduler;

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
        this.matchMaker = mm1;
        this.scheduler = ss1;

    }

    public HashMap<String[], Object[]> freturn(Manageable m1, Manageable m2){
        overlap = scheduler.getCommonTimes((Schedulable) m1, (Schedulable) m2)
    }

    public compileList() {
        for ()
            this.reccomendations
    }
}

