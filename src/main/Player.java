import java.util.ArrayList;

public class Player implements Manageable{
    private String username;
    private int age;
    private String bio;
    private double[] location = new double[2];
    private ArrayList<String> availability;
    private double skill;
    private String phoneNumber;
    private ArrayList<String> swipedUsers;

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



}

