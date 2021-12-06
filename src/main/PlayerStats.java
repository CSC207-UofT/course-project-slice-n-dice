import org.json.simple.JSONObject;

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

    public int numGamesPlayed(StatsMaker player1) {
        return player1.getWinsandLosses()[0] + player1.getWinsandLosses()[1];
    }

    public double getWinRate(StatsMaker player1) {
        return (double) player1.getWinsandLosses()[0] / numGamesPlayed(player1);
    }

    public double getWinLossRatio(StatsMaker player1) {
        return (double) player1.getWinsandLosses()[0] / player1.getWinsandLosses()[1];
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
        if (xyz.equals(time1)) {
            return false;
        }
        else
            return true;
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

//    public boolean sendStats(String filepath){
//        while (checkNewChange(filepath)) {
//
//        }
//    }
}


