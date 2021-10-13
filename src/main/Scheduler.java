public class Scheduler{

    /**
     * Creates a new Scheduler object.
     */
    public Scheduler(){
    }

    /**
     * This method returns a list of common times between two schedulable objects (Tennis players).
     * How to call -> Scheduler.getCommonTimes((Schedulable) p1, (Schedulable) p2)
     */
    public ArrayList<String> getCommonTimes(Schedulable player1, Schedulable player2){
        ArrayList<String> commonTimes = new ArrayList<>;
         for (String item1: player1.get_schedule()){
             for (String item2: player2.get_schedule()){
                 if (item1.equals(item2)){
                     commonTimes.add(item1);
                 }
             }
         }
         return commonTimes;
    }

    /**
     * This method returns a list of the two schedulable objects (Tennis players).
     * How to call -> Scheduler.getSchedulableUsernames((Schedulable) p1, (Schedulable) p2)
     */
    public ArrayList<String> getSchedulableUsernames(Schedulable player1, Schedulable player2){
        String[] username_pair = {player1.getUsername(), player2.getUsername()};
        return username_pair;
    }
}

