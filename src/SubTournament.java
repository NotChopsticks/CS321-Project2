import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The subtournament that decides winners based on weapon archetypes
 */
public class SubTournament {
    /**
     * list of all matches to be played
     */
    List<Match> matches;
    /**
     * the current round the match is at
     */
    int currentRound;
    /**
     * the archetype of weapons that are used in the subtournament
     */
    TournamentArchetype archetype;
    /**
     * The list of fighters in the subtournament
     */
    List<Fighter> combatants;
    /**
     * the winner of the subtournament
     */
    Fighter winner;
    /**
     * Random object for matching fighters together
     */
    Random matchMaker = new Random();
    /**
     * Random object for generating fighter stats
     */
    Random statGenerator = new Random();
    /**
     * Random object for generating IDs
     */
    Random idGen = new Random();
    /**
     * total number of rounds in the subtournament
     */
    int totalRounds;
    /**
     * WeaponFactory that assigns weapons to fighters
     */
    WeaponFactory factory;
    /**
     * input that effectively pauses the output stream so the user can read it
     */
    Scanner pauser = new Scanner(System.in);


    public SubTournament() {

    }
    /**
     * sets up initial values and internal states for the subtournament
     * @param rounds
     * @param type
     */
    public SubTournament(int rounds, TournamentArchetype type) {
        totalRounds = rounds;
        archetype = type;
        factory = new WeaponFactory();
        combatants = new ArrayList<>();
        matches = new ArrayList<>();
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Hagar", "Dovakin", "Sandor", "Gregor", "Maximus", "Thorin", "Jonathan", "Adam", "Juley", "Tyler", "Jorah", "Drogo", "Dario", "Naruto", "Sasuke", "Barristan", "Jotaro", "Dio", "Babayaga", "Gon", "Killua", "Nathan", "Sam", "Die-Hardman", "Snake", "Spike", "Jet", "Faye", "Ed", "Vicious", "Dante", "Virgil", "Marcus", "Lelouch", "Zero", "CC", "Kallen", "Suzaku", "Bruce", "Tiber", "Ulfric", "Raiden", "Armstrong"));
        double totalCombatants = Math.pow(2, rounds);
        for (int i = 0; i < totalCombatants; i++) {
            int str = statGenerator.nextInt(10)+1;
            int rch = statGenerator.nextInt(10)+1;
            int spd = statGenerator.nextInt(10)+1;
            Weapon newWeap = factory.makeWeapon(type);
            String newName = names.get(rand.nextInt(names.size()));
            Fighter temp = new Fighter(str, rch, spd, newWeap, newName);
            combatants.add(temp);
        }
        int index = 0;

        for (int j = 0; j < totalCombatants/2; j++){
            index = matchMaker.nextInt(combatants.size());
            Fighter f1 = combatants.get(index);
            combatants.remove(index);

            index = matchMaker.nextInt(combatants.size());
            Fighter f2 = combatants.get(index);
            combatants.remove(index);

            Match temp = new Match(f1, f2);
            matches.add(temp);


        }
    }

    /**
     * Method for running the subtournament and determining a winner out of the two fighters
     */
    public void DetermineWinner() {
        /**Assumptions when using this function:
         * combatants is empty
         * matches is filled
        */
        currentRound = 1;
        String tournamentType = getTournamentType();
        boolean last = false;
        //for (int i = totalRounds; i > 0; i--)

        while(true){

            System.out.println("\n" + tournamentType + "Tournament Round: " + currentRound);
            currentRound++;
            int roundSize = matches.size();
            for (int j = 0; j < roundSize; j++) {
                System.out.println("\nMatch " + (j+1) + ": " + matches.get(0).fighter1.name + " Vs. " + matches.get(0).fighter2.name);
                matches.get(0).PlayMatch(last);  //
                combatants.add(matches.get(0).winner);
                System.out.println(matches.get(0).winner.name + " wins match " + (j+1) + "\n");
                System.out.println("Press Enter to continue \n");
                try{System.in.read();}
                catch(Exception e){}
                matches.remove(0);
            }
            int remainingCombatants = combatants.size();
            if (remainingCombatants > 1) {
                if (remainingCombatants == 2){
                    last = true;
                }
                for (int j = 0; j < remainingCombatants / 2; j++) {
                    Fighter f1 = combatants.get(0);
                    Fighter f2 = combatants.get(1);
                    Match temp = new Match(f1, f2);
                    matches.add(temp);
                    combatants.remove(0);
                    combatants.remove(0);

                }
            }
            else {
                winner = combatants.get(0);
                System.out.println("The winner of the " + tournamentType + "weapon SubTournament is " + winner.name);
                System.out.println("Press Enter to continue");
                try{System.in.read();}
                catch(Exception e){}
                break;
            }


        }




    }

    /**
     * gets the weapon archetype for weapons in the subtournament
     * @return tournamentType
     */
    public String getTournamentType(){
        String tournamentType = "";
        switch(archetype){
            case Long:
                tournamentType = "Long ";
                break;

            case Medium:
                tournamentType = "Medium ";
                break;

            case Short:
                tournamentType = "Short ";
                break;
            case Wild:
                tournamentType = "Wild ";
                break;
        }
        return tournamentType;
    }

}
