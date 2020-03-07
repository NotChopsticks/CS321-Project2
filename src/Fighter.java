import java.util.Random;

public class Fighter {
    public int strength;
    public int reach;
    public int speed;
    public Weapon weapon;
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

    
    public boolean strongerThan(Fighter opponent)
    {
        return strength > opponent.strength;
    }

    public boolean longerReachThan(Fighter opponent)
    {
        return reach > opponent.reach;
    }

    public boolean fasterThan(Fighter opponent)
    {
        return speed > opponent.speed;
    }
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
