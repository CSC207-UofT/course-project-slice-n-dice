package MatchingAlgoHelpers;
// Developed by Rahul Jaideep

import java.util.ArrayList;

public class Scheduler{

    /**
     * Creates a new MatchingAlgoHelpers.Scheduler object.
     */
    public Scheduler(){
    }

    /**
     * This method returns a list of common times between two schedulable objects (Tennis players).
     * How to call -> MatchingAlgoHelpers.Scheduler.getCommonTimes((MatchingAlgoHelpers.Schedulable) p1, (MatchingAlgoHelpers.Schedulable) p2)
     */
    public ArrayList<String> getCommonTimes(Schedulable s1, Schedulable s2){
        ArrayList<String> commonTimes = new ArrayList<>();
        ArrayList<String> schedule1 = s1.getSchedule();
        ArrayList<String> schedule2 = s2.getSchedule();

        for (String item1: schedule1){
            for (String item2: schedule2){
                if (item1.equals(item2) && (!commonTimes.contains(item1))){
                    commonTimes.add(item1);
                }
            }
        }
        return commonTimes;
    }

    /**
     * This method returns a list of the two schedulable objects (Tennis players).
     * How to call -> MatchingAlgoHelpers.Scheduler.getSchedulableUsernames((MatchingAlgoHelpers.Schedulable) p1, (MatchingAlgoHelpers.Schedulable) p2)
     */
    public String[] getSchedulableUsernames(Schedulable player1, Schedulable player2){
        return new String[]{player1.getUsername(), player2.getUsername()};

    }
}
