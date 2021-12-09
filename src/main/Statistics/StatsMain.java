package Statistics;

public class StatsMain {

    public static void main() {
        PlayerStats playerStats = new PlayerStats();
        while (true) {
            playerStats.isReadReady("../frontend/statspipe2.json", "../frontend/statspipe1.json");
        }
    }
}
