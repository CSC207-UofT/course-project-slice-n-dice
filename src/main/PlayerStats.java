
public class PlayerStats {

    public int numGamesPlayed(StatsMaker player1){
        return player1.getWinsandLosses()[0] + player1.getWinsandLosses()[1];
    }

    public double getWinRate(StatsMaker player1){
        return (double) player1.getWinsandLosses()[0] / numGamesPlayed(player1);
    }

    public double getWinLossRatio(StatsMaker player1){
        return (double) player1.getWinsandLosses()[0] / player1.getWinsandLosses()[1];
    }
}
