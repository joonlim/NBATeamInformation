/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbateaminformation;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import static tools.FileTools.deleteFile;
import static tools.FileTools.readFile;
import static tools.WebTools.saveHtmlFile;

/**
 *
 * To open jar file: java -jar <jar-file-name>.jar
 *
 * @author Joon
 */
public class NBATeamInformation {

    Hashtable teamList;

    public NBATeamInformation(String fileName) throws IOException {
        teamList = new Hashtable(31);
        StringBuilder data = new StringBuilder(readFile(fileName));

        // Create NBATeam objects and add them to teamList hashtable
        while (data != null) {
            try {
                data.delete(0, data.indexOf("<th width=\"5%\">#</th>"));

                for (int i = 1; i <= 15; i++) {

                    int rank = i;

                    data.delete(0, data.indexOf("season\">"));
                    String teamName = data.substring(data.indexOf(">") + 1, data.indexOf("<"));

                    data.delete(0, data.indexOf("<td>"));
                    int gamesWon = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    int gamesLost = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    double winningPercentage = Double.parseDouble(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    String gamesBehind = data.substring(data.indexOf(">") + 1, data.indexOf("<", 1));

                    data.delete(0, data.indexOf("<td>", 3));
                    int gamesPlayed = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    teamList.put(teamName, new NBATeam(teamName, rank, gamesWon, gamesLost, winningPercentage, gamesBehind, gamesPlayed));

                }

                for (int i = 1; i <= 15; i++) {

                    int rank = i;

                    data.delete(0, data.indexOf("season\">"));
                    String teamName = data.substring(data.indexOf(">") + 1, data.indexOf("<"));

                    data.delete(0, data.indexOf("<td>"));
                    int gamesWon = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    int gamesLost = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    double winningPercentage = Double.parseDouble(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    data.delete(0, data.indexOf("<td>", 3));
                    String gamesBehind = data.substring(data.indexOf(">") + 1, data.indexOf("<", 1));

                    data.delete(0, data.indexOf("<td>", 3));
                    int gamesPlayed = Integer.parseInt(data.substring(data.indexOf(">") + 1, data.indexOf("<", 1)));

                    teamList.put(teamName, new NBATeam(teamName, rank, gamesWon, gamesLost, winningPercentage, gamesBehind, gamesPlayed));

                }

                data.delete(0, data.indexOf("?"));

            } catch (StringIndexOutOfBoundsException e) {
                data = null;
            }
        } // END OF WHILE LOOP
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        saveHtmlFile("http://en.wikipedia.org/wiki/2014%E2%80%9315_NBA_season", "2014-2015_NBA_Season.html");

        NBATeamInformation w = new NBATeamInformation("2014-2015_NBA_Season.html");

        deleteFile("2014-2015_NBA_Season.html");

        //get user input
        // if input.nextline.ignoreCase == "hawks" || "atlanta" || "atl" || "atlanta hawks"
        // key is "Atlanta Hawks"
        while (true) {
            System.out.print("\nEnter team name: ");

            String teamName = input.nextLine();
            if (teamName.equalsIgnoreCase("boston celtics")
                    || teamName.equalsIgnoreCase("bos")
                    || teamName.equalsIgnoreCase("celtics")
                    || teamName.equalsIgnoreCase("boston")) {
                teamName = "Boston Celtics";
            } else if (teamName.equalsIgnoreCase("brooklyn nets")
                    || teamName.equalsIgnoreCase("bkn")
                    || teamName.equalsIgnoreCase("nets")
                    || teamName.equalsIgnoreCase("brooklyn")) {
                teamName = "Brooklyn Nets";
            } else if (teamName.equalsIgnoreCase("new york knicks")
                    || teamName.equalsIgnoreCase("nyk")
                    || teamName.equalsIgnoreCase("knicks")
                    || teamName.equalsIgnoreCase("new york")) {
                teamName = "New York Knicks";
            } else if (teamName.equalsIgnoreCase("philadelphia 76ers")
                    || teamName.equalsIgnoreCase("phi")
                    || teamName.equalsIgnoreCase("76ers")
                    || teamName.equalsIgnoreCase("philadelphia")) {
                teamName = "Philadephia 76ers";
            } else if (teamName.equalsIgnoreCase("toronto raptors")
                    || teamName.equalsIgnoreCase("tor")
                    || teamName.equalsIgnoreCase("raptors")
                    || teamName.equalsIgnoreCase("toronto")) {
                teamName = "Toronto Raptors";
            } else if (teamName.equalsIgnoreCase("chicago bulls")
                    || teamName.equalsIgnoreCase("chi")
                    || teamName.equalsIgnoreCase("bulls")
                    || teamName.equalsIgnoreCase("chicago")) {
                teamName = "Chicago Bulls";
            } else if (teamName.equalsIgnoreCase("cleveland cavaliers")
                    || teamName.equalsIgnoreCase("cle")
                    || teamName.equalsIgnoreCase("cavaliers")
                    || teamName.equalsIgnoreCase("cleveland")) {
                teamName = "Cleveland Cavaliers";
            } else if (teamName.equalsIgnoreCase("detroit pistons")
                    || teamName.equalsIgnoreCase("det")
                    || teamName.equalsIgnoreCase("pistons")
                    || teamName.equalsIgnoreCase("detroit")) {
                teamName = "Detroit Pistons";
            } else if (teamName.equalsIgnoreCase("indiana pacers")
                    || teamName.equalsIgnoreCase("ind")
                    || teamName.equalsIgnoreCase("pacers")
                    || teamName.equalsIgnoreCase("indiana")) {
                teamName = "Indiana Pacers";
            } else if (teamName.equalsIgnoreCase("milwaukee bucks")
                    || teamName.equalsIgnoreCase("mil")
                    || teamName.equalsIgnoreCase("bucks")
                    || teamName.equalsIgnoreCase("milwaukee")) {
                teamName = "Milwaukee Bucks";
            } else if (teamName.equalsIgnoreCase("atlanta hawks")
                    || teamName.equalsIgnoreCase("atl")
                    || teamName.equalsIgnoreCase("hawks")
                    || teamName.equalsIgnoreCase("atlanta")) {
                teamName = "Atlanta Hawks";
            } else if (teamName.equalsIgnoreCase("charlotte hornets")
                    || teamName.equalsIgnoreCase("cha")
                    || teamName.equalsIgnoreCase("hornets")
                    || teamName.equalsIgnoreCase("charlotte")) {
                teamName = "Charlotte Hornets";
            } else if (teamName.equalsIgnoreCase("miami heat")
                    || teamName.equalsIgnoreCase("mia")
                    || teamName.equalsIgnoreCase("heat")
                    || teamName.equalsIgnoreCase("miami")) {
                teamName = "Miami Heat";
            } else if (teamName.equalsIgnoreCase("orlando magic")
                    || teamName.equalsIgnoreCase("orl")
                    || teamName.equalsIgnoreCase("magic")
                    || teamName.equalsIgnoreCase("orlando")) {
                teamName = "Orlando Magic";
            } else if (teamName.equalsIgnoreCase("washington wizards")
                    || teamName.equalsIgnoreCase("wsh")
                    || teamName.equalsIgnoreCase("wizards")
                    || teamName.equalsIgnoreCase("washington")) {
                teamName = "Washington Wizards";
            } else if (teamName.equalsIgnoreCase("denver nuggets")
                    || teamName.equalsIgnoreCase("den")
                    || teamName.equalsIgnoreCase("nuggets")
                    || teamName.equalsIgnoreCase("denver")) {
                teamName = "Denver Nuggets";
            } else if (teamName.equalsIgnoreCase("minnesota timberwolves")
                    || teamName.equalsIgnoreCase("min")
                    || teamName.equalsIgnoreCase("timberwolves")
                    || teamName.equalsIgnoreCase("minnesota")) {
                teamName = "Minnesota Timberwolves";
            } else if (teamName.equalsIgnoreCase("oklahoma city thunder")
                    || teamName.equalsIgnoreCase("okc")
                    || teamName.equalsIgnoreCase("thunder")
                    || teamName.equalsIgnoreCase("oklahoma city")) {
                teamName = "Oklahoma City Thunder";
            } else if (teamName.equalsIgnoreCase("portland trail blazers")
                    || teamName.equalsIgnoreCase("por")
                    || teamName.equalsIgnoreCase("trail blazers")
                    || teamName.equalsIgnoreCase("trailblazers")
                    || teamName.equalsIgnoreCase("portland")) {
                teamName = "Portland Trail Blazers";
            } else if (teamName.equalsIgnoreCase("utah jazz")
                    || teamName.equalsIgnoreCase("uta")
                    || teamName.equalsIgnoreCase("jazz")
                    || teamName.equalsIgnoreCase("utah")) {
                teamName = "Utah Jazz";
            } else if (teamName.equalsIgnoreCase("golden state warriors")
                    || teamName.equalsIgnoreCase("gs")
                    || teamName.equalsIgnoreCase("warriors")
                    || teamName.equalsIgnoreCase("golden state")) {
                teamName = "Golden State Warriors";
            } else if (teamName.equalsIgnoreCase("l.a. clippers")
                    || teamName.equalsIgnoreCase("lac")
                    || teamName.equalsIgnoreCase("clippers")
                    || teamName.equalsIgnoreCase("los angeles clippers")
                    || teamName.equalsIgnoreCase("la clippers")) {
                teamName = "Los Angeles Clippers";
            } else if (teamName.equalsIgnoreCase("l.a. lakers")
                    || teamName.equalsIgnoreCase("lal")
                    || teamName.equalsIgnoreCase("lakers")
                    || teamName.equalsIgnoreCase("los angeles lakers")
                    || teamName.equalsIgnoreCase("la lakers")) {
                teamName = "Los Angeles Lakers";
            } else if (teamName.equalsIgnoreCase("phoenix suns")
                    || teamName.equalsIgnoreCase("phx")
                    || teamName.equalsIgnoreCase("suns")
                    || teamName.equalsIgnoreCase("phoenix")) {
                teamName = "Phoenix Suns";
            } else if (teamName.equalsIgnoreCase("sacramento kings")
                    || teamName.equalsIgnoreCase("sac")
                    || teamName.equalsIgnoreCase("kings")
                    || teamName.equalsIgnoreCase("sacramento")) {
                teamName = "Sacramento Kings";
            } else if (teamName.equalsIgnoreCase("dallas mavericks")
                    || teamName.equalsIgnoreCase("dal")
                    || teamName.equalsIgnoreCase("mavericks")
                    || teamName.equalsIgnoreCase("dallas")) {
                teamName = "Dallas Mavericks";
            } else if (teamName.equalsIgnoreCase("houston rockets")
                    || teamName.equalsIgnoreCase("hou")
                    || teamName.equalsIgnoreCase("rockets")
                    || teamName.equalsIgnoreCase("houston")) {
                teamName = "Houston Rockets";
            } else if (teamName.equalsIgnoreCase("memphis grizzlies")
                    || teamName.equalsIgnoreCase("mem")
                    || teamName.equalsIgnoreCase("grizzlies")
                    || teamName.equalsIgnoreCase("memphis")) {
                teamName = "Memphis Grizzlies";
            } else if (teamName.equalsIgnoreCase("new orleans pelicans")
                    || teamName.equalsIgnoreCase("no")
                    || teamName.equalsIgnoreCase("pelicans")
                    || teamName.equalsIgnoreCase("new orleans")) {
                teamName = "New Orleans Pelicans";
            } else if (teamName.equalsIgnoreCase("san antonio spurs")
                    || teamName.equalsIgnoreCase("sa")
                    || teamName.equalsIgnoreCase("spurs")
                    || teamName.equalsIgnoreCase("san antonio")) {
                teamName = "San Antonio";
            }

            System.out.println("");
            String output = (w.teamList.get(teamName) == null) ? "There is no team by that name" : w.teamList.get(teamName).toString();

            System.out.print(output);
            System.out.println("");
        }
    }

}
