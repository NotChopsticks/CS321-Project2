import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SubTournament {

    List<Match> matches;
    int currentRound;
    TournamentArchetype archetype;
    List<Fighter> combatants;
    Fighter winner;
    Random matchMaker = new Random();
    Random statGenerator = new Random();
    Random idGen = new Random();
    int totalRounds;
    WeaponFactory factory;
    Scanner pauser = new Scanner(System.in);


    public SubTournament() {

    }

   public SubTournament(int rounds, TournamentArchetype type) {
        totalRounds = rounds;
        archetype = type;
        factory = new WeaponFactory();
        combatants = new ArrayList<>();
        matches = new ArrayList<>();
        double totalCombatants = Math.pow(2, rounds);
        for (int i = 0; i < totalCombatants; i++) {
            int str = statGenerator.nextInt(10)+1;
            int rch = statGenerator.nextInt(10)+1;
            int spd = statGenerator.nextInt(10)+1;
            Weapon newWeap = factory.makeWeapon(type);
            String newName = "Fighter " + (idGen.nextInt(99)+1); //TODO: Add actual random names
            Fighter temp = new Fighter(str, rch, spd, newWeap, newName);
            combatants.add(temp);
        }
        int index = 0;

        //TODO: Possibly take out the randomized matching since the fighters are already randomly generated
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

    public void DetermineWinner() {
        /**Assumptions when using this function:
         * combatants is empty
         * matches is filled
        */
        currentRound = 1;
        String tournamentType = getTournamentType();
        //for (int i = totalRounds; i > 0; i--)

        while(true){

            System.out.println("\n" + tournamentType + "Tournament Round: " + currentRound);
            currentRound++;
            int roundSize = matches.size();
            for (int j = 0; j < roundSize; j++) {
                System.out.println("\nMatch " + (j+1) + ": " + matches.get(0).fighter1.name + " Vs. " + matches.get(0).fighter2.name);
                matches.get(0).PlayMatch();  //
                combatants.add(matches.get(0).winner);
                System.out.println(matches.get(0).winner.name + " wins match " + (j+1));
                System.out.println("Press Enter to continue");
                try{System.in.read();}
                catch(Exception e){}
                matches.remove(0);
            }
            int remainingCombatants = combatants.size();
            if (remainingCombatants > 1) {

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
