import java.util.Random;

public class WeaponFactory {

    private int[][] ratings = {{3,0},{1,2},{2,2},{1,3},{3,2},{3,1},{4,1},{5,0},{3,3}};

    public WeaponFactory() {
    }

    public Weapon makeWeapon(TournamentArchetype archetype) {
        int weaponNo;
        Random rand = new Random();

        switch(archetype) {
            case short_weapon:
                weaponNo = rand.nextInt(2);
                Weapon shortWeapon = new Weapon(WeaponArchetype.short_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                return shortWeapon;
            case medium_weapon:
                int low = 3;
                int high = 5;
                weaponNo = rand.nextInt(high-low) + low;
                Weapon mediumWeapon = new Weapon(WeaponArchetype.medium_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                return mediumWeapon;
            case long_weapon:
                low = 5;
                high = 8;
                weaponNo = rand.nextInt(high-low) + low;
                Weapon longWeapon = new Weapon(WeaponArchetype.long_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                return longWeapon;
            case wild:
                low = 0;
                high = 8;
                weaponNo = rand.nextInt(high-low) + low;
                if(weaponNo <= 2) {
                    Weapon wildWeapon = new Weapon(WeaponArchetype.short_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                    return wildWeapon;
                }
                else if(weaponNo >= 3 && weaponNo <= 5) {
                    Weapon wildWeapon = new Weapon(WeaponArchetype.medium_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                    return wildWeapon;
                }
                else if(weaponNo >= 6 && weaponNo <= 8) {
                    Weapon wildWeapon = new Weapon(WeaponArchetype.long_weapon, ratings[0][weaponNo], ratings[1][weaponNo]);
                    return wildWeapon;
                }
            default:
                Weapon defaultWeapon = new Weapon();
                return defaultWeapon;
        }
    }

}
