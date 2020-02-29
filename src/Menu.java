import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many rounds do you want in the sub-tournaments?");
        while (true) {
            String input = in.nextLine();
            String[] token = input.split(" ");
            int subRounds;
            try {
                subRounds = Integer.parseInt(token[0]);
                System.out.println("Initializing sub-tournaments with " + subRounds + " Rounds");


            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid integer");
            }
        }
    }

    public void RunTournament(int subRounds){
        Tournament thunderDome = new Tournament();
        thunderDome.InitializeTournament(subRounds);
    }

}
