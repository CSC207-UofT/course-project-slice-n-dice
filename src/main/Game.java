import java.util.Calendar;
        import java.util.ArrayList;
        import java.text.SimpleDateFormat;

public class Game implements BioRetrieval{

    private Calendar date;
    private String court;
    private ArrayList<String> players;
    private String bio;

    public Game(int d, int m, int y, int h, int min, String c, String p1, String p2) {
        this.date = Calendar.getInstance();
        date.clear();
        date.set(y, m - 1, d, h, min);
        // changed m to m - 1 because in Calender, month value is 0 based, i.e.,
        // 0-January, 1-February and so on...

        this.court = c;
        this.players = new ArrayList<String>();
        players.add(p1);
        players.add(p2);
    }

    public String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return dateFormat.format(date.getTime());
    }

    public void setDate(int d, int m, int y, int h, int min){
        date.set(y, m - 1, d, h, min);
        // changed m to m - 1 because in Calender, month value is 0 based, i.e.,
        // 0-January, 1-February and so on...
    }

    public String getCourt(){
        return court;
    }

    public void setCourt(String c){
        this.court = c;
    }

    public ArrayList<String> getPlayers(){
        return players;
    }

    public String getBio() {
        return "Date/Time: " + getDate() + " Players: " + this.players;
    }

    public static void main (String[] args){

    }

}