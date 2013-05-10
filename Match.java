/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seasonsimulator;

import java.util.Random;
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
    
    public boolean isMaxScore(int score)
    {
        if(score >= WeekPlayed.getMaxScore())
            return true;
        return false;
    }
    
    @Override
    public void run()
    {
        System.out.println("Match between " + Team1 + " and " + Team2 + " has started");
        Random rand = new Random();
        int delay = rand.nextInt(12000) + 3000;
        try
        {
            Thread.sleep(delay);
        }
        catch(InterruptedException e)
        {
            System.err.println("Match thread interrupted");
            System.err.println(e.getStackTrace());
        }
        
        int score1 = Team1.score();
        int score2 = Team2.score();
        
        if(score1 > score2)
        {
            System.out.println(Team1 + " defeats " + Team2 + " "+ score1 + "-" + score2);
            synchronized(WeekPlayed)
            {
                if(isMaxScore(score1))
                {
                    System.out.println(Team1 + "'s score is now the weeks maximum");
                    WeekPlayed.setMaxScore(score1);
                }
            }
        }
        
        if(score2 > score1)
        {
            System.out.println(Team2 + " defeats " + Team1 + " "+ score2 + "-" + score1);
            synchronized(WeekPlayed)
            {
                if(isMaxScore(score2))
                {
                    System.out.println(Team2 + "'s score is now the weeks maximum");
                    WeekPlayed.setMaxScore(score2);
                }
            }
        }
        
        if(score1 == score2)
        {
            System.out.println(Team1 + " ties " + Team2 + " "+ score1 + "-" + score2);
            synchronized(WeekPlayed)
            {
                if(isMaxScore(score1))
                {
                    System.out.println(Team1 + " and " + Team2 + "'s score is now the weeks maximum");
                    WeekPlayed.setMaxScore(score1);
                }
            }
        }
    }
}
