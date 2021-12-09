package ReadAndWrite;/*
Developed by Alexia Monize
*/

import Managers.Manageable;
import Managers.Manager;
import Managers.PrioritySkillManager;
import MatchingAlgoHelpers.MatchMaker;
import MatchingAlgoHelpers.Scheduler;
import UserData.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Observer{
    private static FileWriter file;

    @SuppressWarnings("unchecked")
    public static void writePlayer(Player p1, Manager m, ArrayList<Manageable> unranked_list) {
        Scheduler scheduler1 = new Scheduler();
        MatchMaker matchMaker1 = new MatchMaker();
        Manager managerObject = new PrioritySkillManager(matchMaker1, scheduler1);

        JSONObject obj = new JSONObject();
        JSONArray keys = new JSONArray();
        for (Manageable user : m.getRankedList(p1, unranked_list)){
            JSONObject info = new JSONObject();
            JSONArray region = new JSONArray();
            info.put("username", p1.getUsername());
            info.put("bio", p1.getBio());
            info.put("age", p1.getAge());
            info.put("skilllevel", p1.getSkill());
            region.add(p1.getLocation()[0]);
            region.add(p1.getLocation()[1]);
            info.put("region", region);
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


    // Testing the ReadAndWrite.Observer class here. Note: After testing, to ensure reading also works, please run ReadAndWrite.Read.java and
    // ensure the pipe1.json file is outputting data that corresponds to the profiles generate by this file.
    public static void main(String[] args) {
        Scheduler scheduler1 = new Scheduler();
        MatchMaker matchMaker1 = new MatchMaker();
        Manager managerObject = new PrioritySkillManager(matchMaker1, scheduler1);


        ArrayList<String> avail1 = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Funday"));
        ArrayList<String> avail2 = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday"));
        Player r = new Player("jack", 26, "I know tennis.", 163.4,
                109.02, avail2, 3, "6479837765");
        Player e = new Player("jack", 26, "I know tennis.", 163.4,
                109.02, avail2, 3, "6479837765");
        Player o = new Player("jack", 26, "I know tennis.", 163.4,
                109.02, avail2, 3, "6479837765");
        Player z = new Player("jack", 26, "I know tennis.", 163.4,
                109.02, avail2, 3, "6479837765");
        Player q = new Player("jack", 26, "I know tennis.", 163.4,
                109.02, avail2, 3, "6479837765");
        Player p = new Player("janedoe12", 22, "I know tennis.", 133.4,
                89.02, avail1, 5, "6479837765");


        ArrayList<Manageable> playerList = new ArrayList<>();
        playerList.add(e);
        playerList.add(r);
        playerList.add(o);
        playerList.add(z);
        playerList.add(p);

        writePlayer(q, managerObject, playerList);


    }
}
