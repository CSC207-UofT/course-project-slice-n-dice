import java.util.Scanner;
import java.util.ArrayList;


public class Main {

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

        //Player p = new Player(username, phoneNumber, age, lat, lon, total_availability, skilllevel);

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

    public static void presentMatches(){

    }


    public static void main(String[] args){

        makeProfile();
        presentMatches();
    }
}
