import java.util.Random;


/**
 * Represents a single fighter in the tournament
 */
public class Fighter {
    /**
     * Strength of the fighter
     */
    public int strength;
    /**
     * Reach of the fighter
     */
    public int reach;
    /**
     * Speed of the fighter
     */
    public int speed;
    /**
     * The fighter's equipped weapon
     */
    public Weapon weapon;
    /**
     * Name of the fighter
     */
    public String name;

    public Fighter()
    {
        
    }

    public Fighter(int str, int rch, int spd, Weapon weap, String nm)
    {
        strength = str;
        reach = rch;
        speed = spd;
        weapon = weap;
        name = nm;
    }

    /**
     * method for determining if the fighter is stronger than his opponent
     * @param opponent
     * @return true or false
     */
    public boolean strongerThan(Fighter opponent)
    {
        return strength > opponent.strength;
    }

    /**
     * method for determining if the fighter has longer reach than his opponent
     * @param opponent
     * @return true or false
     */
    public boolean longerReachThan(Fighter opponent)
    {
        return reach > opponent.reach;
    }

    /**
     * method for determining if the fighter is faster than his opponent
     * @param opponent
     * @return true or false
     */
    public boolean fasterThan(Fighter opponent)
    {
        return speed > opponent.speed;
    }

    /**
     * method for determining the fighter's attack performance for the match
     * uses "dice" rolls and weapon stats to determine performance
     * @param opponent
     * @return attack performance rating
     */
    public int getAttackPerformance(Fighter opponent)
    {
        int performance = 0;
        Random rand = new Random();
        
        for(int i = 0; i < weapon.attackRating; i++)
        {
            performance += rand.nextInt(6)+1;
        }
        
        if(strongerThan(opponent)) {
            performance++;
        }
        if(opponent.weapon.archetype != weapon.archetype && fasterThan(opponent)) {
            performance++;
        }
        return performance;
    }

    /**
     * method for determining the fighter's defense performance for the match
     * uses "dice" rolls and weapon stats to determine performance
     * @param opponent
     * @return defense performance rating
     */
    public int getDefensePerformance(Fighter opponent)
    {
        int performance = 0;
        Random rand = new Random();

        for(int i = 0; i < weapon.defenseRating; i++)
        {
            performance += rand.nextInt(6);
        }

        if(longerReachThan(opponent)) {
            performance++;
        }
        if(opponent.weapon.archetype != weapon.archetype && fasterThan(opponent)) {
            performance++;
        }
        return performance;
    }
}
