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
    
    /**
     * Generate the score for the team
     * @return random int 1-99
     */
    public int score()
    {
        Random rand = new Random();
        return rand.nextInt(99) + 1;
    }
    
    /**
     * Get the name of this team
     * @return The name of this team
     */
    public String getName()
    {
        return Name;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(!(obj instanceof Team))
            return false;
        
        Team rhs = (Team) obj;
        
        return Name.equals(rhs.Name);
    }
    
    @Override
    public int hashCode()
    {
        return Name.hashCode();
    }
    
    @Override
    public String toString()
    {
        return Name;
    }
}
