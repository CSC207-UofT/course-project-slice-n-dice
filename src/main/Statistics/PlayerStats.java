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

    public void isReadReady(String path, String path2){
        while (!checkNewChange(path)) {
            JSONParser parser = new JSONParser();
            try {
                var obj = parser.parse(new FileReader(path));
                JSONObject jsonObject =  (JSONObject) obj;
                String wins =  (String) jsonObject.get("wins");
                String losses = (String) jsonObject.get("losses");

                int new_wins = Integer.parseInt(wins);
                int new_losses = Integer.parseInt(losses);

                loadandsaveJSON(path2, new_wins, new_losses);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // YOU ARE READING FROM statspipe1.json
        // you have an instance variable that stores the last time the file was modified (initially, set it to 0)
        // have a while loop that is constantly checking the last updated time of the file
        // google how to access a file's metadata in Java/what the variable would be called
        // if the last updated time is newer, do these two things
        // 1. set the new modified time to the one you just read (NOTE: make sure you're saving the last UPDATED time,
        // not the time this is happening)
        // 2. break out of the while loop and call the method that reads the json information
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
        // just parse the json information into two variables: wins and losses
        // call the methods that manipulate that information (like get win rate, whatever) and save those to variables
        // create a new JSON object with these three variables
        // Save that JSON object to statspipe2.json

    }

    public boolean checkNewChange(String filepath){
        return true;
    }
}


