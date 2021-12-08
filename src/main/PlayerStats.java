import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;


public class PlayerStats {

    private FileTime time1;

    public PlayerStats(){
        Instant instant
                = Instant.parse("0000-00-00000:00:00.000");
        this.time1 = FileTime.from(instant);
    }
    /*
    public int numGamesPlayed(StatsMaker player1) {
        return player1.getWinsandLosses()[0] + player1.getWinsandLosses()[1];
    }

    public double getWinRate(StatsMaker player1) {
        return (double) player1.getWinsandLosses()[0] / numGamesPlayed(player1);
    }

    public double getWinLossRatio(StatsMaker player1) {
        return (double) player1.getWinsandLosses()[0] / player1.getWinsandLosses()[1];
    }
     */

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
        while (! checkNewChange(path)) {
            File f = new File(path);
            time1 = getLastModifiedTime(f.getName());
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

    public boolean readJson(String filepath, JSONObject jsonObject) {
        try {
            File f = new File(filepath);
            FileWriter file = new FileWriter(f.getName());
            file.write(jsonObject.toJSONString());
            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean modifyTime(String filepath) {
        File f = new File(filepath);
        FileTime xyz = getLastModifiedTime(f.getName());
        if (xyz.equals(time1)) {
            return false;
        }
        else {
            time1 = getLastModifiedTime(f.getName());
            return true;
        }

    }

    public boolean checkNewChange(String filepath){
        File f = new File(filepath);
        FileTime xyz = getLastModifiedTime(f.getName());
        return !xyz.equals(time1);
    }

    public FileTime getLastModifiedTime(String filepath){
        try {
            File myfile = new File(filepath);
            Path path = myfile.toPath();
            BasicFileAttributes attr = Files.readAttributes(path,
                    BasicFileAttributes.class);
            return attr.lastModifiedTime();

        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }
}


