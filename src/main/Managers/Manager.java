package Managers;
// Developed by John Park and Rahul Jaideep

import MatchingAlgoHelpers.MatchMaker;
import MatchingAlgoHelpers.Matchable;
import MatchingAlgoHelpers.Schedulable;
import MatchingAlgoHelpers.Scheduler;

import java.util.ArrayList;

public abstract class Manager {
    private MatchMaker matchMakerObject;
    private Scheduler schedulerObject;

    public Manager(MatchMaker mm1, Scheduler ss1) {
        this.matchMakerObject = mm1;
        this.schedulerObject = ss1;
    }

    /**
     * This method can be called in Managers.PriorityLocationManager subclass. TEMPLATE DESIGN PATTERN.
     */
    public double getMatchableScoreLocation(Manageable user1, Manageable user2){
        return matchMakerObject.getScoreLocation((Matchable) user1, (Matchable) user2);
    }


    /**
     * This method can be called in Managers.PrioritySkillManager subclass. TEMPLATE DESIGN PATTERN.
     */
    public double getMatchableScoreSkill(Manageable user1, Manageable user2){
        return matchMakerObject.getScoreSkill((Matchable) user1, (Matchable) user2);
    }

    public ArrayList<String> getOverlapTimes(Manageable user1, Manageable user2){
        return schedulerObject.getCommonTimes((Schedulable) user1, (Schedulable) user2);
    }

    public boolean[] getSwipeStatusPair(Manageable user1, Manageable user2){
        boolean user1SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) user1, (Matchable) user2);
        boolean user2SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) user2, (Matchable) user1);
        return new boolean[]{user1SwipeStatus, user2SwipeStatus};
    }


    abstract double returnIndexedScorePriority(Manageable user1, Manageable user2);

    /**
     * Ranks the list of manageable objects based on their score with user1. Highest rank is index 0.
     * @param user1 Managers.Manageable object (player)
     * @param dirty_list List of Managers.Manageable objects (players) that are to be compared with user1 based on score.
     * @return a ranked ArrayList of Managers.Manageable objects
     */
    public ArrayList<Manageable> getRankedList(Manageable user1, ArrayList<Manageable> dirty_list){
        int listSize = dirty_list.size();

        // ArrayList of object array of size 2 where
        // index 0 is the manageable object and index 1 is the score (double).

        Manageable[] indexedManageables = new Manageable[listSize];
        double[] indexedScores = new double[listSize];

        // Fills in indexedScores in the required format mentioned above.
        for (int i = 0; i < listSize; i++){
            indexedManageables[i] = dirty_list.get(i);
            indexedScores[i] = returnIndexedScorePriority(user1, dirty_list.get(i));
        }

        // The bubble sort algorithm that sorts the indexedScores list according to score value.
        bubbleSort(listSize, indexedScores, indexedManageables);

        // This will be the final ArrayList that holds the ranked manageable objects.
        ArrayList<Manageable> returnList = new ArrayList<>();

        // Fills in the returnList with just the Manageables in the ranked order.
        for (int i = 0; i < listSize; i++){
            returnList.add(indexedManageables[i]);
        }
        return returnList;
    }

    /**
     * This function uses the bubble sort algorithm to sort an array of Manageable items
     * from lowest to highest indexedScores.
     */
    public void bubbleSort(int listSize, double[] indexedScores, Manageable[] indexedManageables){
        for (int i = 0; i < listSize - 1; i++){
            for (int j = 0; j < listSize - i - 1; j++) {
                if (indexedScores[j] > indexedScores[j + 1]) {
                    double temp1 = indexedScores[j];
                    indexedScores[j] = indexedScores[j + 1];
                    indexedScores[j + 1] = temp1;

                    Manageable temp2 = indexedManageables[j];
                    indexedManageables[j] = indexedManageables[j + 1];
                    indexedManageables[j + 1] = temp2;
                }
            }
        }
    }

}

