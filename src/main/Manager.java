import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private MatchMaker matchMakerObject;
    private Scheduler schedulerObject;

    public Manager(MatchMaker mm1, Scheduler ss1) {
        this.matchMakerObject = mm1;
        this.schedulerObject = ss1;
    }

    public double getMatchableScore(Manageable user1, Manageable user2){
        return matchMakerObject.getScore((Matchable) user1, (Matchable) user2);
    }

    public ArrayList<String> getOverlapTimes(Manageable user1, Manageable user2){
        return schedulerObject.getCommonTimes((Schedulable) user1, (Schedulable) user2);
    }

    public boolean[] getSwipeStatusPair(Manageable user1, Manageable user2){
        boolean user1SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) user1, (Matchable) user2);
        boolean user2SwipeStatus = matchMakerObject.getSwipedStatus((Matchable) user2, (Matchable) user1);
        boolean[] swipedPair = {user1SwipeStatus, user2SwipeStatus};
        return swipedPair;
    }

    /**
     * Ranks the list of manageable objects based on their score with user1. Highest rank is index 0.
     * @param user1 Manageable object (player)
     * @param dirty_list List of Manageable objects (players) that are to be compared with user1 based on score.
     * @return a ranked ArrayList of Manageable objects
     */
    public ArrayList<Manageable> getRankedList(Manageable user1, ArrayList<Manageable> dirty_list) {
        int listSize = dirty_list.size();

        // ArrayList of object array of size 2 where
        // index 0 is the manageable object and index 1 is the score (double).
        Object[] indexedScores = new Object[listSize];

        // Fills in indexedScores in the required format mentioned above.
        for (int i = 0; i < listSize; i++){
            Object[] eachIndex = new Object[2];
            Manageable user2 = dirty_list.get(i);
            double score = getMatchableScore(user1, dirty_list.get(i))
            eachIndex[0] = new Manageable(user2);
            eachIndex[1] = new Double(score);
            indexedScores[i] = eachIndex;
        }

        // The bubble sort algorithm that sorts the indexedScores list according to score value.
        for (int i = 0; i < listSize - 1; i++){
            for (int j = 0; j < listSize - i - 1; j++) {
                if (indexedScores[j][1] > indexedScores[j + 1][1]) {
                    // swap indexedScores[j+1] and indexedScores[j]
                    Object temp = indexedScores[j];
                    indexedScores[j] = indexedScores[j + 1];
                    indexedScores[j + 1] = temp;
                }
            }
        }

        // This will be the final ArrayList that holds the ranked manageable objects.
        ArrayList<Manageable> returnList = new ArrayList<>();

        // Fills in the returnList with just the Manageables in the ranked order.
        for (int i = 0; i < listSize; i++){
            returnList.add(indexedScores[i][0]);
        }

        return returnList;

    }


}

