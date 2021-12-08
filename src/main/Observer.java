/*
Developed by Alexia Monize
*/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Observer{
    private static FileWriter file;

    @SuppressWarnings("unchecked")
    public void writePlayer(PlayerDataOut p1) {
        Scheduler scheduler1 = new Scheduler();
        MatchMaker matchMaker1 = new MatchMaker();
        Manager managerObject = new PrioritySkillManager(matchMaker1, scheduler1);

        JSONObject obj = new JSONObject();
        JSONArray keys = new JSONArray();
        for (Manageable user : p1.getRankedList()){
            JSONObject info = new JSONObject();
            info.put("bio", p1.getBio());
            info.put("age", p1.getAge());
            info.put("skilllevel", p1.getSkill());
            info.put("region", p1.getLocation());
            info.put("availability", p1.getAvailability());
            info.put("photo", "nadal.jpeg");
            keys.add(info);
        }

        obj.put("profiles", keys);

        try {

            file = new FileWriter("src/main/pipe1.json");
            file.write(obj.toJSONString());
            ObserverLog("Successfully Copied JSON Object to File...");
            ObserverLog("\nJSON Object: " + obj);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public void ObserverLog(String str) {
        System.out.println("Your profile has been created and saved.");
    }
}
