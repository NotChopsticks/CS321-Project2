public class Weapon {

    public WeaponArchetype archetype;
    public int attackRating;
    public int defenseRating;

    public Weapon() {

    }

    public Weapon(WeaponArchetype arch, int atk, int def) {
        this.archetype = arch;
        this.attackRating = atk;
        this.defenseRating = def;
    }
    
}
