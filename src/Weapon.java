/**
 * Class that holds weapons stats
 */
public class Weapon {
    /**
     * archtype of the weapon
     */
    public WeaponArchetype archetype;
    /**
     * weapon attack bonus
     */
    public int attackRating;
    /**
     * weapon defense bonus
     */
    public int defenseRating;

    public Weapon() {

    }

    /**
     * parameterized constructor for setting stat values of the weapon on initialization
     * @param arch
     * @param atk
     * @param def
     */
    public Weapon(WeaponArchetype arch, int atk, int def) {
        this.archetype = arch;
        this.attackRating = atk;
        this.defenseRating = def;
    }
    
}
