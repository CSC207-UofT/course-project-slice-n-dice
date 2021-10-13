import java.util.ArrayList;

interface Schedulable {
    public ArrayList<String> getSchedule();   //String list of times that the player is available in the week.
    public String getUsername();
}
