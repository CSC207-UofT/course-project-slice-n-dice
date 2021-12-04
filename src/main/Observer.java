import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Observer{
    private static FileWriter file;

    @SuppressWarnings("unchecked")
    public void writePlayer(PlayerDataOut p1) {
        JSONObject obj = new JSONObject();
        obj.put("Username", p1.getUsername());
        obj.put("Number", p1.getPhoneNumber());

        JSONArray background = new JSONArray();
        background.add(p1.getBio());
        background.add(p1.getAge());
        background.add(p1.getSkill());
        background.add(p1.getLocation());
        background.add(p1.getAvailability());
        obj.put("Background Info", background);
        try {

            file = new FileWriter("src/main/Pipe1");
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
