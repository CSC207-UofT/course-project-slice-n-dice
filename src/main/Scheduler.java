public class Scheduler implements Manageable{

    private Schedulable player1;
    private Schedulable player2;
    private ArrayList<String> p1times;
    private ArrayList<String> p2times;

    /**
     * Creates a new Scheduler object. This constructor takes in 2 schedulable objects as arguments.
     * @param player1 a schedulable object with available times.
     * @param player2 another schedulable object with available times.
     */
    public Scheduler(Schedulable player1, Schedulable player2){
        this.player1 = player1;
        this.player2 = player2;
        this.p1times = player1.get_schedule();
        this.p2times = player2.get_schedule();
    }

    /**
     * This method returns a list of common times between two schedulable objects (Tennis players).
     */
    public ArrayList<String> getCommonTimes(){
        ArrayList<String> commonTimes = new ArrayList<>;
         for (String item1: p1times){
             for (String item2: p2times){
                 if (item1.equals(item2)){
                     commonTimes.add(item1);
                 }
             }
         }
         return commonTimes;
    }

    public ArrayList<String> getSchedulableUsernames(){
        String[] username_pair = {this.player1.getUsername(), this.player2.getUsername()}
        return username_pair;
    }
}

