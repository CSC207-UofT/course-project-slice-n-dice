import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class Player implements Manageable, BioRetrieval {
    private String username;
    private int age;
    private String bio;
    private double[] location = new double[2];
    private ArrayList<String> availability;
    private double skill;
    private String phoneNumber;
    private ArrayList<String> swipedUsers;

    public Player(){
        this.username = "";
        this.age = 0;
        this.location = new double[]{0, 0};
        this.bio = "";
        this.availability = new ArrayList<String>();
        this.skill = 0;
        this.phoneNumber = "";
        this.swipedUsers = new ArrayList<>();
    }

    public Player(String username, int age, String bio, double latitude, double longitude, ArrayList<String> availability, double skill,
                  String phoneNumber)
    {
        this.username = username;
        this.age = age;
        this.location = new double[]{latitude, longitude};
        this.bio = bio;
        this.availability = availability;
        this.skill = skill;
        this.phoneNumber = phoneNumber;
        this.swipedUsers = new ArrayList<>();

    }

    public String getUsername(){
        return this.username;
    }

    public String getBio(){
        return this.bio;
    }

    public int getAge(){
        return this.age;
    }

    public double[] getLocation(){
        return this.location;
    }

    public ArrayList<String> getAvailability(){
        return this.availability;
    }

    public double getSkill(){
        return this.skill;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public ArrayList<String> getSchedule(){
        return this.availability;
    }

    /**
     * IMPORTANT - LIST OF PLAYER OBJECTS OR LIST OF STRINGS?
     * @param swipedPlayer ...
     */
    public void setSwipedUsers(Player swipedPlayer){
        swipedUsers.add(swipedPlayer.username);
    }

    public ArrayList<String> getSwipedUsers(){
        return swipedUsers;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", bio='" + bio + '\'' +
                ", location=" + Arrays.toString(location) +
                ", availability=" + availability +
                ", skill=" + skill +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", swipedUsers=" + swipedUsers +
                '}';
    }
}

