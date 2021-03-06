import java.util.Scanner;

/**
 * Takes user input for the number of rounds the tournament should have and starts the tournament
 */
public class Menu {
    public Menu() {

    }

    /**
     * method for the user to select the number of rounds the tournament will have
     */
    public void UserInterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many rounds do you want in the sub-tournaments? \n 1 - 2 Matches \n 2 - 4 Matches \n 3 - 8 Matches \n 4 - 16 Matches \n 5 - 32 Matches \n 6 - 64 Matches");
        while (true) {
            String input = in.nextLine();
            String[] token = input.split(" ");
            int subRounds;
            try {
                subRounds = Integer.parseInt(token[0]);
                System.out.println("Initializing sub-tournaments with " + subRounds + " Rounds");
                RunTournament(subRounds);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid integer");
            }
        }
    }

    /**
     * starts the tournament
     * @param subRounds
     */
    public void RunTournament(int subRounds){
        Tournament thunderDome = new Tournament();
        thunderDome.InitializeTournament(subRounds);
        thunderDome.DetermineWinner();
    }

}
