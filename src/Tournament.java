import java.util.ArrayList;
import java.util.List;

public class Tournament {

    List<SubTournament> subTournaments;


    public Tournament() {

    }

    public void DetermineWinner() {

    }

    public void InitializeTournament(int rounds) {
        for (TournamentArchetype type : TournamentArchetype.values()){
            SubTournament temp = new SubTournament(rounds, type);
            //temp.archetype = type;
            subTournaments.add(temp); //TODO:
        }
    }

}
