import Managers.Manageable;
import Managers.Manager;
import Managers.PrioritySkillManager;
import MatchingAlgoHelpers.MatchMaker;
import MatchingAlgoHelpers.Scheduler;
import UserData.Player;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static ArrayList<Manageable> all_users = new ArrayList<Manageable>();
    public static Player user = new Player();
    public static Player u1 = new Player();
    public static Player u2 = new Player();
    public static Player u3 = new Player();
    public static Player u4 = new Player();

    public static void makeProfile(){

        System.out.println(",--------.                      ,--.             ,---.                 ");
        System.out.println("'--.  .--',---. ,--,--, ,--,--, `--' ,---.      /  O  \\  ,---.  ,---.  ");
        System.out.println("   |  |  | .-. :|      \\|      \\,--.(  .-'     |  .-.  || .-. || .-. | ");
        System.out.println("   |  |  \\   --.|  ||  ||  ||  ||  |.-'  `)    |  | |  || '-' '| '-' ' ");
        System.out.println("   `--'   `----'`--''--'`--''--'`--'`----'     `--' `--'|  |-' |  |-'  ");
        System.out.println("                                                        `--'   `--'    ");


        System.out.println("Welcome! Start by following the prompts below to create your profile.");

        // Controls user input to ensure that usernames are alphanumeric
        Scanner usersc = new Scanner(System.in);
        System.out.println("Please enter a username (containing only letters and/or numbers): ");
        while (!usersc.hasNext("[A-Za-z0-9]*")) {
            System.out.println("Sorry, usernames can only contain letters and numbers. Please try again.");
            usersc.next();
        }
        String username = usersc.nextLine();

        // Controls user input to make sure phone numbers are integers
        Scanner phonesc = new Scanner(System.in);
        System.out.println("Please enter your phone number (in the format 1234567890): ");
        while (!phonesc.hasNext("[0-9]*")) {
            System.out.println("Invalid phone number. Please try again.");
            phonesc.next();
        }
        String phoneNumber = phonesc.nextLine();

        // Controls user input to make sure ages are integers
        Scanner agesc = new Scanner(System.in);
        int age;
        do {
            System.out.println("Enter your age: ");
            while (!agesc.hasNextInt()) {
                System.out.println("That's not a valid age!");
                agesc.next();
            }
            age = agesc.nextInt();
        } while (age <= 0);

        Scanner biosc = new Scanner(System.in);
        System.out.println("Enter a bio. This will be displayed to potential matches. ");
        String bio = biosc.nextLine();

        // Collects longitude and latitude information as doubles
        Scanner latsc = new Scanner(System.in);
        System.out.println("Enter your location's latitude (in decimal form): ");
        double lat = latsc.nextDouble();

        Scanner lonsc = new Scanner(System.in);
        System.out.println("Enter your location's longitude (in decimal form): ");
        double lon = lonsc.nextDouble();

        // Controls user input to make sure skill level is 1, 2, 3, 4, or 5
        Scanner skillsc = new Scanner(System.in);
        System.out.println("On a scale from 1 to 5, how would you rate your tennis skill level? (1: Complete beginner; 2: Some experience; 3: Intermediate; 4: Experienced; 5: Pro)?");
        while (!skillsc.hasNext("[12345]")) {
            System.out.println("Invalid input. Please try again.");
            skillsc.next();
        }
        String skillLevel = skillsc.nextLine();
        double sl = Double.parseDouble(skillLevel);


        System.out.println("Next, we'll ask some questions about your availability in order to find you the best matches.");

        String availmon = "";
        String availtue = "";
        String availwed = "";
        String availthurs = "";
        String availfri = "";
        String availsat = "";
        String availsun = "";

        // The next blocks of code collect availability information for a day of the week if the user is available
        // This is repeated for every day of the week

        Scanner my_scan = new Scanner(System.in);

        System.out.println("Are you available Mondays? (Y/N)");
        String avail = my_scan.nextLine();

        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availmon = my_scan.nextLine();
            avail = "";
        }

        System.out.println("Are you available Tuesdays? (Y/N)");
        avail = my_scan.nextLine();

        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availtue = my_scan.nextLine();
            avail = "";
        }
        System.out.println("Are you available Wednesdays? (Y/N)");
        avail = my_scan.nextLine();
        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availwed = my_scan.nextLine();
            avail = "";
        }
        System.out.println("Are you available Thursdays? (Y/N)");
        avail = my_scan.nextLine();
        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availthurs = my_scan.nextLine();
            avail = "";
        }
        System.out.println("Are you available Fridays? (Y/N)");
        avail = my_scan.nextLine();
        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availfri = my_scan.nextLine();
            avail = "";
        }
        System.out.println("Are you available Saturdays? (Y/N)");
        avail = my_scan.nextLine();
        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availsat = my_scan.nextLine();
            avail = "";
        }
        System.out.println("Are you available Sundays? (Y/N)");
        avail = my_scan.nextLine();
        if(avail.equals("Y")) {
            System.out.println("Please enter, separated by commas, the beginning time of the one-hour time blocks you are available for on Mondays. For instance, if you're available from 10am-11am and 1pm-2pm, please enter '10,13'.");
            availsun = my_scan.nextLine();
            avail = "";
        }

        // Splits the user input strings into something more usable

        String[] mondays = availmon.split("\\s*,\\s*");
        String[] tuesdays = availtue.split("\\s*,\\s*");
        String[] wednesdays = availwed.split("\\s*,\\s*");
        String[] thursdays = availthurs.split("\\s*,\\s*");
        String[] fridays = availfri.split("\\s*,\\s*");
        String[] saturdays = availsat.split("\\s*,\\s*");
        String[] sundays = availsun.split("\\s*,\\s*");

        // Creates an array list of availabilities to pass to the player constructor

        ArrayList<String> total_availability = new ArrayList<String>();
        if(mondays[0] != "") {
            for (int i = 0; i < mondays.length; i++) {
                total_availability.add("Monday " + mondays[i]);
            }
        }
        if(tuesdays[0] != "") {
            for (int i = 0; i < tuesdays.length; i++) {
                total_availability.add("Tuesday " + tuesdays[i]);
            }
        }
        if(wednesdays[0] != "") {
            for (int i = 0; i < wednesdays.length; i++) {
                total_availability.add("Wednesday " + wednesdays[i]);
            }
        }
        if(thursdays[0] != "") {
            for (int i = 0; i < thursdays.length; i++) {
                total_availability.add("Thursday " + thursdays[i]);
            }
        }
        if(fridays[0] != "") {
            for (int i = 0; i < fridays.length; i++) {
                total_availability.add("Friday " + fridays[i]);
            }
        }
        if(saturdays[0] != "") {
            for (int i = 0; i < saturdays.length; i++) {
                total_availability.add("Saturday " + saturdays[i]);
            }
        }
        if(sundays[0] != "") {
            for (int i = 0; i < sundays.length; i++) {
                total_availability.add("Sunday " + sundays[i]);
            }
        }

        // Creates a new player object with the information collected above


        Player user = new Player(username, age, bio, lon, lat, total_availability, sl, phoneNumber);

        System.out.println("Great! Your information has been saved: ");
        System.out.println("Username: " + username);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
        System.out.println("Location: Latitude:  " + lat + ", Longitude: " + lon);
        System.out.println("Skill Level: " + skillLevel);
        System.out.println("Availability: " + total_availability);

        System.out.println();

        System.out.println("Now generating a list of perfect matches for you...");

    }

    public static void createFakeUsers(){

        ArrayList<String> availability1 = new ArrayList<>(Arrays.asList("Monday 1", "Monday 2", "Monday 3", "Monday 10", "Monday 22", "Tuesday 7", "Thursday 1", "Thursday 2", "Thursday 3", "Friday 4", "Friday 8", "Friday 9", "Friday 10", "Friday 11", "Friday 12", "Saturday 12", "Saturday 1", "Saturday 2", "Saturday 3", "Saturday 4"));
        ArrayList<String> availability2 = new ArrayList<>(Arrays.asList("Monday 10", "Monday 12", "Monday 3", "Monday 11", "Monday 22", "Tuesday 7", "Thursday 1", "Thursday 2", "Thursday 3", "Friday 4", "Friday 8", "Friday 9", "Friday 10", "Friday 11", "Friday 12", "Saturday 12", "Saturday 1", "Saturday 2", "Saturday 3", "Saturday 4", "Sunday 5", "Sunday 6"));

        u1 = new Player("johndoe17", 22, "I love tennis!", 43.663898, -79.387914, availability1, 5, "6473458765");
        u2 = new Player("tennisbro123", 17, "tennis rox", 43.663898, -79.387914, availability2, 5, "4165556789");
        u3 = new Player("realperson123", 20, "I am a real person who likes tennis", 43.669145, -79.399372, availability1, 3, "6463648999");
        u4 = new Player("emma16", 19, "tennis is soooooooo fun", 43.671442, -79.397645, availability2, 2, "5197653487");

        u4.setSwipedUsers(user);
        u1.setSwipedUsers(user);

        all_users.add(u1);
        all_users.add(u2);
        all_users.add(u3);
        all_users.add(u4);

    }


    public static void presentMatches(){
            Scheduler scheduler1 = new Scheduler();
            MatchMaker matchMaker1 = new MatchMaker();
            Manager managerObject = new PrioritySkillManager(matchMaker1, scheduler1);
            ArrayList<Manageable> users_in_order = new ArrayList<>();
            users_in_order = managerObject.getRankedList(user, all_users);

            System.out.println(u1.getUsername());
            System.out.println("Age: " + u1.getAge());
            System.out.println("Bio: " + u1.getBio());
            System.out.println("Skill Level: " + u1.getSkill());
            System.out.println();


            System.out.println("Would you like to match with " + u1.getUsername()+ "? (Y/N)");
            Scanner s1 = new Scanner(System.in);
            String choice1 = s1.nextLine();

        if(u1.getSwipedUsers().contains(user.getUsername())){
            System.out.println(u1.getUsername() + " also wants to match with you! Contact them at " + u1.getPhoneNumber() + ".");

        }
        System.out.println();

        System.out.println(u2.getUsername());
        System.out.println("Age: " + u2.getAge());
        System.out.println("Bio: " + u2.getBio());
        System.out.println("Skill Level: " + u2.getSkill());
        System.out.println();


        System.out.println("Would you like to match with " + u2.getUsername()+ "? (Y/N)");
        Scanner s2 = new Scanner(System.in);
        String choice2 = s1.nextLine();

        if(u2.getSwipedUsers().contains(user.getUsername())){
            System.out.println(u2.getUsername() + " also wants to match with you! Contact them at " + u2.getPhoneNumber());
        }
        System.out.println();

        System.out.println(u3.getUsername());
        System.out.println("Age: " + u3.getAge());
        System.out.println("Bio: " + u3.getBio());
        System.out.println("Skill Level: " + u3.getSkill());
        System.out.println();


        System.out.println("Would you like to match with " + u3.getUsername()+ "? (Y/N)");
        Scanner s3 = new Scanner(System.in);
        String choice3 = s1.nextLine();

        if(u3.getSwipedUsers().contains(user.getUsername())){
            System.out.println(u3.getUsername() + " also wants to match with you! Contact them at " + u3.getPhoneNumber());
        }
        System.out.println();

        System.out.println(u4.getUsername());
        System.out.println("Age: " + u4.getAge());
        System.out.println("Bio: " + u4.getBio());
        System.out.println("Skill Level: " + u4.getSkill());
        System.out.println();


        System.out.println("Would you like to match with " + u4.getUsername()+ "? (Y/N)");
        Scanner s4 = new Scanner(System.in);
        String choice4 = s1.nextLine();

        if(u4.getSwipedUsers().contains(user.getUsername())){
            System.out.println(u4.getUsername() + " also wants to match with you! Contact them at " + u4.getPhoneNumber());
        }
        System.out.println();


    }


    public static void main(String[] args){
        makeProfile();
        createFakeUsers();
        presentMatches();
    }
}
