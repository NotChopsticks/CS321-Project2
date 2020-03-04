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

    
    public boolean strongerThan(int str)
    {
        boolean st = false;

        if(strength > str)
            st = true;

        return st;
    }
    public boolean longerReachThan(int rch)
    {
        boolean lrt = false;

        if(reach > rch)
            lrt = true;

        return lrt;
    }
    public boolean fasterThan(int spd)
    {
        boolean ft = false;

        if(speed > spd)
            ft = true;

        return ft;
    }
    public int getAttackPerformance(boolean st, boolean ft)
    {
        int performance = 0;
        Random rand = new Random();
        
        for(int i = 0; i < weapon.attackRating; i++)
        {
            performance += rand.nextInt(6);
        }
        
        if(st == true)
            performance++;

        if(ft == true)
            performance++;

        return performance;
    }
    public int getDefensePerformance(boolean lrt, boolean ft)
    {
        int performance = 0;
        Random rand = new Random();

        for(int i = 0; i < weapon.defenseRating; i++)
        {
            performance += rand.nextInt(6);
        }

        if(lrt == true)
            performance++;

        if(ft == true)
            performance++;

        return performance;
    }
}
