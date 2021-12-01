
import java.util.ArrayList;

abstract class Manager {
    private MatchMaker matchMakerObject;
    private Scheduler schedulerObject;

    public Manager(MatchMaker mm1, Scheduler ss1) {
        this.matchMakerObject = mm1;
        this.schedulerObject = ss1;
    }

    // Phase 1 - added this method so that it can be called in PriorityLocationManager subclass.
    // Needed to implement template design Pattern.
    public double getMatchableScoreLocation(Manageable user1, Manageable user2){
        return matchMakerObject.getScoreLocation(user1, user2);
    }

    // Phase 1 - Added this method so that it can be called in PrioritySkillManager subclass.
    // Needed to implement template design Pattern.
    public double getMatchableScoreSkill(Manageable user1, Manageable user2){
        return matchMakerObject.getScoreSkill(user1, user2);
    }

    public ArrayList<String> getOverlapTimes(Manageable user1, Manageable user2){
        return schedulerObject.getCommonTimes(user1, user2);
    }

    public boolean[] getSwipeStatusPair(Manageable user1, Manageable user2){
        boolean user1SwipeStatus = matchMakerObject.getSwipedStatus(user1, user2);
        boolean user2SwipeStatus = matchMakerObject.getSwipedStatus(user2, user1);
        return new boolean[]{user1SwipeStatus, user2SwipeStatus};
    }

    abstract double returnIndexedScorePriority(Manageable user1, Manageable user2);

    /**
     * Ranks the list of manageable objects based on their score with user1. Highest rank is index 0.
     * @param user1 Manageable object (player)
     * @param unranked_list List of Manageable objects (players) that are to be compared with user1 based on score.
     * @return a ranked ArrayList of Manageable objects
     */
    public ArrayList<Manageable> getRankedList(Manageable user1, ArrayList<Manageable> unranked_list){
        int listSize = unranked_list.size();

        // ArrayList of object array of size 2 where
        // index 0 is the manageable object and index 1 is the score (double).

        Manageable[] indexedManageables = new Manageable[listSize];
        double[] indexedScores = new double[listSize];

        // Fills in indexedScores in the required format mentioned above.
        for (int i = 0; i < listSize; i++){
            indexedManageables[i] = unranked_list.get(i);
            indexedScores[i] = returnIndexedScorePriority(user1, unranked_list.get(i));
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

    public void bubbleSort(int listSize, double[] indexedScores, Manageable[] indexedManageables){
        for (int i = 0; i < listSize - 1; i++){
            for (int j = 0; j < listSize - i - 1; j++) {
                if (indexedScores[j] > indexedScores[j + 1]) {
                    // swap indexedScores[j+1] and indexedScores[j]
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

