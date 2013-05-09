/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seasonsimulator;

import java.util.ArrayList;
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
                if(x.Team1.getName().equals(m.Team1.getName())
                        && x.Team2.getName().equals(m.Team2.getName()))
                    return;
                if(x.Team1.getName().equals(m.Team2.getName())
                        && x.Team2.getName().equals(m.Team1.getName()))
                   return; 
            }
            Matches.add(m);
            System.out.println("Schedule "+m.Team1.getName()+" against "+m.Team2.getName() + " in week #"+WeekNumber);
        }
    }
    
    public void simulate()
    {
        
    }
            
}
