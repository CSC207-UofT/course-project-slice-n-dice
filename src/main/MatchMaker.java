import static java.lang.Math.sqrt;

public class matchMaker implements Manageable {

    private Matchable player1;
    private Matchable player2;
    public double score;
    public ArrayList<String> usernames;

    public matchMaker(Matchable player1, Matchable player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setScore(double score, Matchable player1, Matchable player2) {
        double skill_difference;
        double location_difference;

        // Uses Pythagoras to find the distance between players and takes the absolute difference in skill
        skill_difference = Math.abs(player1.getSkill() - player2.getSkill());
        location_difference = sqrt(Math.pow((player1.getLocation()[0] - player2.getLocation()[0]), 2) +
                Math.pow((player1.getLocation()[1] - player2.getLocation()[1]), 2));
        this.score = (location_difference * 0.5 + skill_difference) / 2; // sets a score of match suitability which weighs distance over skill
    }

    public double getScore() {
        return score;
    }

    public void setUsernames(Matchable player1, Matchable player2) {
        usernames = [player1.getUsername(), player2.getUsername()]
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }
}