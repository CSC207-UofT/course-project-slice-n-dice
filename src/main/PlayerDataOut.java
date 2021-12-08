/*
Developed by Alexia Monize
*/
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PlayerDataOut extends Manageable{

    String getUsername();

    String getBio();

    int getAge();

    double[] getLocation();

    ArrayList<String> getAvailability();

    double getSkill();

    String getPhoneNumber();

    ArrayList getSwipedUsers();

    ArrayList<Manageable> getRankedList();

    ArrayList<Manageable> getPlayers();

}
