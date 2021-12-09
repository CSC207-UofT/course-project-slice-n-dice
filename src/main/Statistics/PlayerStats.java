package Statistics;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;



public class PlayerStats {

    public int numGamesPlayed(int wins, int losses){
        return wins + losses;
    }

    public double getWinRate(int wins, int losses){
        return (double) wins / (wins + losses);
    }

    public double getWinLossRatio(int wins, int losses) {
        return (double) wins / losses;
    }

    public int numGames;

    public PlayerStats() {
        this.numGames = 0;
    }

    public void isReadReady(String path, String path2){
        JSONParser parser = new JSONParser();
        try {
            var obj = parser.parse(new FileReader(path));
            JSONObject jsonObject =  (JSONObject) obj;
            String wins =  (String) jsonObject.get("wins");
            String losses = (String) jsonObject.get("losses");

            int new_wins = Integer.parseInt(wins);
            int new_losses = Integer.parseInt(losses);
            //only save a new pipe if the number of games has changed.
            if (new_wins + new_losses > this.numGames) {
                this.numGames = new_wins + new_losses;
                loadandsaveJSON(path2, new_wins, new_losses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public void loadandsaveJSON(String path, int wins, int losses) {
        double win_rate = getWinRate(wins, losses);
        double winLossRatio = getWinLossRatio(wins, losses);
        int gamesPlayed = wins + losses;

        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("gamesPlayed", String.valueOf(gamesPlayed));
        jsonObject.put("winRate", String.valueOf(win_rate));
        jsonObject.put("winLossRatio", String.valueOf(winLossRatio));
        try {
            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


