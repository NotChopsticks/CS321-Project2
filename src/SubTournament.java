import java.util.List;
import java.util.Random;

public class SubTournament {

    List<Match> matches;
    List<Match> currentRound;
    TournamentArchetype archetype;
    List<Fighter> combatants;
    Fighter winner;
    Random matchMaker = new Random();
    int totalRounds;


    public SubTournament() {

    }

   public SubTournament(int rounds, TournamentArchetype type) {
        totalRounds = rounds;
        double totalCombatants = Math.pow(2, rounds);
        for (int i = 0; i < totalCombatants; i++) {
            Fighter temp = new Fighter(); //TODO: Change this to work as a parameterized constructor passing in the weapon archetype
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

    public void DetermineWinner() {
        /**Assumptions when using this function:
         * combatants is empty
         * matches is filled
        */


        //for (int i = totalRounds; i > 0; i--)

        while(true){
            int roundSize = matches.size();
            for (int j = 0; j < roundSize; j++) {
                matches.get(0).PlayMatch();  //
                combatants.add(matches.get(0).winner);
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
                break;
            }


        }




    }

}
