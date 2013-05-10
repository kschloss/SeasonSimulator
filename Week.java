/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Season Season;
    private ArrayList<Match> Matches; 
    
    public Week(int n)
    {
        WeekNumber = n;
        Matches = new ArrayList();
    }
    
    public void addMatch(Match m)
    {
        if(Matches.isEmpty()){
            Matches.add(m);
            System.out.println("Schedule "+m.Team1.getName()+" against "+m.Team2.getName() + " in week #"+WeekNumber);
        }
        else
        {
            for(Match x : Matches)
            {
                if(x == m)
                    return;
                if(x.Team1.equals(m.Team1)
                        && x.Team2.equals(m.Team2))
                    return;
                if(x.Team1.equals(m.Team2)
                        && x.Team2.equals(m.Team1))
                   return; 
            }
            Matches.add(m);
            System.out.println("Schedule "+m.Team1.getName()+" against "+m.Team2.getName() + " in week #"+WeekNumber);
        }
    }
    
    public synchronized void setMaxScore(int score)
    {
        MaxScore = score;
    }
    
    public synchronized int getMaxScore()
    {
        return MaxScore;
    }
    
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
