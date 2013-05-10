package seasonsimulator;

import java.util.ArrayList;
import java.lang.Thread;
/**
 *
 * @author Kevin
 */
public class Week {
    
    private int MaxScore;
    private int WeekNumber;
    private ArrayList<Match> Matches; 
    
    public Week(int n)
    {
        WeekNumber = n;
        Matches = new ArrayList();
    }
    
    /**
     * Add a match for this week to be simulated
     * @param m The match
     */
    public void addMatch(Match m)
    {
        if(Matches.isEmpty()){
            Matches.add(m);
        }
        else
        {
            for(Match x : Matches)
            {
                if(x == m)
                    return;
                if(x.getTeam1().equals(m.getTeam1())
                        && x.getTeam2().equals(m.getTeam2()))
                    return;
                if(x.getTeam1().equals(m.getTeam2())
                        && x.getTeam2().equals(m.getTeam1()))
                   return; 
            }
            Matches.add(m);
        }
    }
    
    /**
     * Set the maximum score recorded for this week
     * @param score the maximum score recorded for this week
     */
    public synchronized void setMaxScore(int score)
    {
        MaxScore = score;
    }
    
    /**
     * Get the maximum score recorded this week
     * @return The maximum score recorded this week
     */
    public synchronized int getMaxScore()
    {
        return MaxScore;
    }
    
    /**
     * Simulate the week. All matches start simultaneously
     * in their own thread
     */
    public void simulate() 
    {
        System.out.println("Simulating week #"+WeekNumber);
        ArrayList<Thread> matchThreads = new ArrayList();
        for(int x = 0; x < Matches.size(); x++)
        {
            matchThreads.add(new Thread(Matches.get(x)));
            matchThreads.get(x).start();
        }
        
        for(Thread th : matchThreads)
        {
            try
            {
                th.join();
            }
            catch(InterruptedException e)
            {
                System.err.println("Main thread interrupted");
                System.err.println(e.getStackTrace());
            }
        }
    }
            
}
