import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.*;

public class WeaponFactory {



    //private int[][] ratings = {{3,0},{1,2},{2,2},{1,3},{3,2},{3,1},{4,1},{5,0},{3,3}};
    private Map<String, Integer> atkRatings = new HashMap<String, Integer>();
    private Map<String, Integer> defRatings = new HashMap<String, Integer>();
    private String[] longWeapons = {"Halberd", "Lance", "Two-Handed Sword"};
    private String[] medWeapons = {"Staff", "Hand-and-a-half Sword", "Rapier"};
    private String[] shortWeapons = {"Dagger", "Cestus", "Gladius"};
    private String[] allWeapons = {"Halberd", "Lance", "Two-Handed Sword", "Staff", "Hand-and-a-half Sword", "Rapier", "Dagger", "Cestus", "Gladius"};


    public WeaponFactory() {
       //Map<String, Integer> atkRatings = new HashMap<String, Integer>();
        atkRatings.put("Halberd", 3);
        atkRatings.put("Lance", 1);
        atkRatings.put("Two-Handed Sword", 2);
        atkRatings.put("Staff", 1);
        atkRatings.put("Hand-and-a-half Sword", 3);
        atkRatings.put("Rapier", 3);
        atkRatings.put("Dagger", 4);
        atkRatings.put("Cestus", 5);
        atkRatings.put("Gladius", 3);
        //Map<String, Integer> defRatings = new HashMap<String, Integer>();
        defRatings.put("Halberd", 0);
        defRatings.put("Lance", 2);
        defRatings.put("Two-Handed Sword", 2);
        defRatings.put("Staff", 3);
        defRatings.put("Hand-and-a-half Sword", 2);
        defRatings.put("Rapier", 1);
        defRatings.put("Dagger", 1);
        defRatings.put("Cestus", 0);
        defRatings.put("Gladius", 3);
    }

    public Weapon makeWeapon(TournamentArchetype archetype) {
        int weaponNo;
        Random rand = new Random();

        switch(archetype) {
            case Short:
                weaponNo = rand.nextInt(3);
                Weapon shortWeapon = new Weapon(WeaponArchetype.short_weapon, atkRatings.get(shortWeapons[weaponNo]),  defRatings.get(shortWeapons[weaponNo]));
                return shortWeapon;
            case Medium:

                weaponNo = rand.nextInt(3);
                Weapon mediumWeapon = new Weapon(WeaponArchetype.medium_weapon, atkRatings.get(medWeapons[weaponNo]), defRatings.get(medWeapons[weaponNo]));
                return mediumWeapon;
            case Long:

                weaponNo = rand.nextInt(3);
                Weapon longWeapon = new Weapon(WeaponArchetype.long_weapon, atkRatings.get(longWeapons[weaponNo]), defRatings.get(longWeapons[weaponNo]));
                return longWeapon;
            case Wild:
                WeaponArchetype wildArchetype = null;
                weaponNo = rand.nextInt(9);
                if(weaponNo <= 2) {
                    wildArchetype = WeaponArchetype.long_weapon;
                }
                else if(weaponNo >= 3 && weaponNo <= 5) {
                    wildArchetype = WeaponArchetype.medium_weapon;
                }
                else if(weaponNo >= 6 && weaponNo <= 8) {
                    wildArchetype = WeaponArchetype.short_weapon;
                }

                Weapon wildWeapon = new Weapon(wildArchetype, atkRatings.get(allWeapons[weaponNo]), defRatings.get(allWeapons[weaponNo]));
                return wildWeapon;
            default:
                Weapon defaultWeapon = new Weapon();
                return defaultWeapon;
        }
    }

}
