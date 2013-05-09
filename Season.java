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
public class Season {
    
    private ArrayList<Team> Teams;
    private ArrayList<Week> Weeks;
    
    public Season(){
        Teams = new ArrayList();
        Weeks = new ArrayList();
    }
    
    public void schedule()
    {
        for(int x=1; x <= 10; x++)
            Teams.add(new Team("Team" + x));
        for(int x=0; x < 18; x++)
            Weeks.add(new Week(x));
        
        int roundRobin[][] = new int[9][9];
        int week = 1; 
        for(int x= 0; x < 9; x++)
        {    
            for(int y=0; y < 9; y++)
            {
                roundRobin[x][y] = week % 9 == 0 ? 9 : week % 9;
                week++;
                System.out.print(roundRobin[x][y]+" ");
            }
            week = week++ %9;
            week++;
            System.out.println();
        }
        
        for(int x=0; x < 9; x++)
        {
            Team t1 = Teams.get(x);
            for(int y=0; y < 9; y++)
            {
                Team t2;
                if(x == y)
                    t2 = Teams.get(9);
                else
                    t2 = Teams.get(y);
                Week w1 = Weeks.get(roundRobin[x][y] - 1);
                Week w2 = Weeks.get(roundRobin[x][y] + 8);
                Match m1 = new Match(t1, t2, w1);
                Match m2 = new Match(t1, t2, w2);
                w1.addMatch(m1);
                w2.addMatch(m2);
            }
        }  
    }
    
    public void simulate()
    {
        
    }
    
}
