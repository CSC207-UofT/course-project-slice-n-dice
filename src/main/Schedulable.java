/*
    Developed by Aman Rana and Rahul Jaideep
 */
import java.util.ArrayList;

interface Schedulable {
    ArrayList<String> getSchedule();   //String list of times that the player is available in the week.
    String getUsername();
}
