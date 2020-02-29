public class Fighter {
    public int strength;
    public int reach;
    public int speed;
    public Weapon weapon;
    public String name;

    public Fighter(){

    }

    // all just placeholders
    public boolean strongerThan(){
        return true;
    }
    public boolean longerReachThan(){
        return true;
    }
    public boolean fasterThan(){
        return true;
    }
    public int getAttackPerformance(){
        return strength;
    }
    public int getDefensePerformance(){
        return speed;
    }
}
