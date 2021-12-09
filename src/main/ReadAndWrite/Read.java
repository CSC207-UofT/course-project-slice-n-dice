package ReadAndWrite;/*
Developed by Alexia Monize
source code: https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
*/
import UserData.Player;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read{
    public static Player individual = new Player();
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/pipe1.json"))
        {
            //ReadAndWrite.Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
        // playerData is profiles
            JSONArray playerData = (JSONArray) obj.get("profiles");
            System.out.println(playerData);

            //Iterate over employee array
            playerData.forEach( ply -> {Player player = (parsePlayerObject( (JSONObject) ply ));
            System.out.println(player);});

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static Player parsePlayerObject(JSONObject player)
    {
        //Get profiles object within file
        //JSONObject playerObject = (JSONObject) player.get("profiles");
        //Get player username
        String username = (String) player.get("username");

        //Get player age
        long age = ((long)player.get("age"));


        //Get player bio
        String bio = (String) player.get("bio");

        //Get player location
        JSONArray location = (JSONArray) player.get("region");

        // Get player availability
        ArrayList<String> availability = (ArrayList<String>) player.get("availability");

        //Get player skill
        double skill = (double) player.get("skilllevel");

        //Get player phone number
        String phoneNumber = (String) player.get("phoneNumber");

        //Get player photo
        String photo = (String) player.get("photo");

        return new Player(username, (int) age, bio, (double) location.get(0), (double) location.get(1), availability, skill, phoneNumber);

    }

}