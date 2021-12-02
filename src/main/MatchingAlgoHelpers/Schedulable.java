/*
    Developed by Aman Rana and Rahul Jaideep
 */
package MatchingAlgoHelpers;

import java.util.ArrayList;

public interface Schedulable {
    ArrayList<String> getSchedule();   //String list of times that the player is available in the week.
    String getUsername();
}
