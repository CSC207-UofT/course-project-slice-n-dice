package MatchingAlgoHelpers;
//Developed by Aman Rana

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class MatchMaker{

    public MatchMaker() {
    }

    /**
     * getScoreBase method returns a list of 2 variables where the first element is the skill difference
     * and the second element is the location difference.
     * @param m1 MatchingAlgoHelpers.Matchable object 1
     * @param m2 MatchingAlgoHelpers.Matchable object 2
     */
    public double[] getScoreBase(Matchable m1, Matchable m2){
        double skill_difference;
        double location_difference;
        double[] returnVariables = new double[2];

        // Uses Pythagoras to find the distance between players and takes the absolute difference in skill
        skill_difference = Math.abs(m1.getSkill() - m2.getSkill());
        location_difference = sqrt(Math.pow((m1.getLocation()[0] - m2.getLocation()[0]), 2) +
                Math.pow((m1.getLocation()[1] - m2.getLocation()[1]), 2));
        returnVariables[0] = skill_difference;
        returnVariables[1] = location_difference;
        return returnVariables;
    }

    /**
     * This method returns the weighted average which exemplifies the match suitability between two players.
     * A score of 0 means the match is perfect, the two players are in the same location and have the same skill
     * levels. The score is a weighted average which weighs location as twice as important as skill level difference.
     * @param m1 MatchingAlgoHelpers.Matchable object 1
     * @param m2 MatchingAlgoHelpers.Matchable object 2
     */
    public double getScoreLocation(Matchable m1, Matchable m2) {
        double skill_difference = getScoreBase(m1, m2)[0];
        double location_difference = getScoreBase(m1, m2)[1];
        return (location_difference * 0.5 + skill_difference) / 2; // calculates the weighted average
    }

    /**
     * This method returns the weighted average which exemplifies the match suitability between two players.
     * A score of 0 means the match is perfect, the two players are in the same location and have the same skill
     * levels. The score is a weighted average which weighs skill difference as twice as important as location.
     * @param m1 MatchingAlgoHelpers.Matchable object 1
     * @param m2 MatchingAlgoHelpers.Matchable object 2
     */
    public double getScoreSkill(Matchable m1, Matchable m2){
        double skill_difference = getScoreBase(m1, m2)[0];
        double location_difference = getScoreBase(m1, m2)[1];
        return (skill_difference * 0.5 + location_difference) / 2; // calculates the weighted average
    }

    /**
     * getUsernames returns the usernames attribute to an array list of the players usernames
     * @param m1 MatchingAlgoHelpers.Matchable object 1
     * @param m2 MatchingAlgoHelpers.Matchable object 2
     */
    public String[] getMatchMakerUsernames(Matchable m1, Matchable m2){
        return new String[]{m1.getUsername(), m2.getUsername()};
    }

    /**
     * Check if m1 wants to match with m2. Return true if it wants to match and false if not.
     */
    public boolean getSwipedStatus(Matchable m1, Matchable m2){
        ArrayList<String> m1SwipedList = m1.getSwipedUsers();
        return m1SwipedList.contains(m2.getUsername());
    }
}
