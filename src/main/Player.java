import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Player implements Manageable{
    private String username;
    private int age;
    private double[] location = new double[2];
    private ArrayList<String> availability;
    private double skill;
    private String phone_number;
    private ArrayList<String> swiped_users;

    public Player(String username, int age, double longitude, double latitude, ArrayList<String> availability, double skill,
                  String phone_number)
    {
        this.username = username;
        this.age = age;
        this.location = new double[]{latitude, longitude};
        this.availability = availability;
        this.skill = skill;
        this.phone_number = phone_number;
        this.swiped_users = new ArrayList<String>;

    }

    public String getUsername() {
        return this.username;
    }

    public int getAge() {
        return this.age;
    }

    public double[] getLocation() {
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

