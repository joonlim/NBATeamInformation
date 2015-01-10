/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbateaminformation;

/**
 *
 * @author Joon
 */
public class NBATeam {
    
    String teamName;
    int rank;
    int gamesWon;
    int gamesLost;
    double winningPercentage;
    String gamesBehind;
    int gamesPlayed;

    public NBATeam(String teamName, int rank, int gamesWon, int gamesLost, double winningPercentage, String gamesBehind, int gamesPlayed) {
        this.teamName = teamName;
        this.rank = rank;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.winningPercentage = winningPercentage;
        this.gamesBehind = gamesBehind;
        this.gamesPlayed = gamesPlayed;
    }
    
    public String toString() {
        return teamName + "\n"
                + "#" + rank + "\n"
                + "W: " + gamesWon + "\n"
                + "L: " + gamesLost + "\n"
                + "PCT: " + winningPercentage + "\n"
                + "GB: " + gamesBehind + "\n"
                + "GP: " + gamesPlayed + "\n";
    }
}
