import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The tournament that invokes subtournaments to determine winners to fight in semifinals and final rounds
 * All to determine one winner of the tournament overall
 */
public class Tournament {
    /**
     * List of subtournaments in the tournament
     */
    List<SubTournament> subTournaments = new ArrayList<>();
    /**
     * Random object for matchmaking
     */
    Random matchMaker = new Random();
    /**
     * Fighter object that will contain the winner of the tournament
     */
    Fighter winner = null;


    public Tournament() {

    }

    /**
     * Determines the winner of the tournament by playing subtournaments and then having
     * the winners of those fight in semifinal matches and then a final match
     */
    public void DetermineWinner() {
        for (SubTournament subBracket : subTournaments) {
            subBracket.DetermineWinner();
        }
        int index = matchMaker.nextInt(3);
        Fighter wildCard = subTournaments.get(3).winner;
        Fighter SemiFinalist1 = subTournaments.get(index).winner;
        subTournaments.remove(index);
        Fighter SemiFinalist2 = subTournaments.get(0).winner;
        Fighter SemiFinalist3 = subTournaments.get(1).winner;

        Match semiFinal1 = new Match(SemiFinalist2, SemiFinalist3);
        Match semiFinal2 = new Match(SemiFinalist1, wildCard);

        semiFinal1.PlayMatch(false);
        semiFinal2.PlayMatch(false);

        System.out.println("Final Stage \n");

        Match FinalMatch = new Match(semiFinal1.winner, semiFinal2.winner);
        FinalMatch.PlayMatch(true);
        winner = FinalMatch.winner;
    }

    /**
     * Sets starting values and internal state of the tournament
     */
    public void InitializeTournament(int rounds) {
        for (TournamentArchetype type : TournamentArchetype.values()){
            SubTournament temp = new SubTournament(rounds, type);
            subTournaments.add(temp);
        }
    }

}
