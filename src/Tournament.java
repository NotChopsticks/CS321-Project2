import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament {

    List<SubTournament> subTournaments;
    Random matchMaker = new Random();
    Fighter winner = null;


    public Tournament() {

    }

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

        semiFinal1.PlayMatch();
        semiFinal2.PlayMatch();

        Match FinalMatch = new Match(semiFinal1.winner, semiFinal2.winner);
        FinalMatch.PlayMatch();
        winner = FinalMatch.winner;

//        Fighter longWeaponChampion = subTournaments.get(0).winner;
//        Fighter mediumWeaponChampion = subTournaments.get(1).winner;
//        Fighter shortWeaponChampion = subTournaments.get(2).winner;
//        Fighter wildWeaponChampion = subTournaments.get(3).winner;

    }

    public void InitializeTournament(int rounds) {
        for (TournamentArchetype type : TournamentArchetype.values()){
            SubTournament temp = new SubTournament(rounds, type);
            //temp.archetype = type;
            subTournaments.add(temp); //TODO:
        }
    }

}
