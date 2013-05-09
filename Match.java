/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seasonsimulator;

/**
 *
 * @author Kevin
 */
public class Match implements Runnable {
    
    Week WeekPlayed;
    Team Team1;
    Team Team2;
    
    public Match(Team t1, Team t2, Week w)
    {
        Team1 = t1;
        Team2 = t2;
        WeekPlayed = w;
    }
    
    public boolean isMaxScore()
    {
        return false;
    }
    
    public void run()
    {
        System.out.println("Match between " + Team1 + " and " + Team2 + " has started");
    }
}
