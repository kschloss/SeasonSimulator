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
public class Team {
    
    private String Name;
    
    public Team(String n)
    {
        Name = n;
    }
    
    public int score()
    {
        Random rand = new Random();
        return rand.nextInt(99) + 1;
    }
    
    public String getName()
    {
        return Name;
    }
}
