import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Player implements Manageable{
    private final String username;
    private final int age;
    private final int[] location = new int[2];
    private final ArrayList<String> availability;
    private final double skill;
    private final String phone_number;
    private ArrayList<String> swiped_users;

    public Player(String username, int age, int longitude, int latitude, ArrayList<String> availability, Double skill, String phone_number)
    {
        this.username = username;
        this.age = age;
        this.location[0]= longitude;
        this.location[1]= latitude;
        this.availability = availability;
        this.skill = skill;
        this.phone_number = phone_number;
        this.swiped_users = = new ArrayList<String>;

    }
    public String getUsername() {
        return this.username;
    }

    public int getAge() {
        return this.age;
    }

    public int[] getLocation() {
        return this.location;
    }

    public ArrayList<String> getAvailability() {
        return this.availability;
    }

    public double getSkill() {
        return this.skill;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public ArrayList<String> getSchedule() {
        return this.availability;
    }
    
    public setSwiped_Users(Player player) {
        swiped_users.add(player)
    }
    
    

}

