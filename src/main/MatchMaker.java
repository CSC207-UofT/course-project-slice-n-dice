import static java.lang.Math.sqrt;

public class MatchMaker{

    public MatchMaker() {
    }

    /**
     * getScore method returns a weighted average which exemplifies the match suitability between two players
     * a score of 0 means the match is perfect, the two players are in the same location and have the same skill
     * levels. The score is a weighted average which eighs location as twice as important as skill level difference.
     * @param player1
     * @param player2
     */
    public double getScore(Matchable player1, Matchable player2) {
        double skill_difference;
        double location_difference;

        // Uses Pythagoras to find the distance between players and takes the absolute difference in skill
        skill_difference = Math.abs(player1.getSkill() - player2.getSkill());
        location_difference = sqrt(Math.pow((player1.getLocation()[0] - player2.getLocation()[0]), 2) +
                Math.pow((player1.getLocation()[1] - player2.getLocation()[1]), 2));
        return (location_difference * 0.5 + skill_difference) / 2; // calculates the weighted average
    }

    /**
     * getUsernames returns the usernames attribute to an array list of the players usernames
     * @param player1
     * @param player2
     */
    public String[] getMatchMakerUsernames(Matchable player1, Matchable player2) {
        String[] username_pair = {player1.getUsername(), player2.getUsername()};
        return username_pair;
    }
}