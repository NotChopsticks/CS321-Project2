public class Match {

    Fighter fighter1;
    Fighter fighter2;
    Jester jester;
    Fighter winner;
    int roundCount;
    //Boolean debug = true;
    int tieCount;

    public Match(Fighter f1, Fighter f2)
    {
       fighter1 = f1;
       fighter2 = f2;
       jester = new Jester(f1, f2);
       roundCount = 0;
       winner = null;
       tieCount = 0;
    }

    public void PlayMatch()
    {
        // These are the function calls that will be used in every combat turn to get the
        // attack and defense performances for each fighter.
        // Figured I'd include these cause they're long and there's a lot of 
        // parentheses.
        int f1Health = 10;
        int f2Health = 10;
        boolean f1HalfHealth = false;
        boolean f2HalfHealth = false;

        while(true) {
            roundCount++;
            int f1Atk = fighter1.getAttackPerformance(fighter2);
            int f2Atk = fighter2.getAttackPerformance(fighter1);

            int f1Def = fighter1.getDefensePerformance(fighter2);
            int f2Def = fighter2.getDefensePerformance(fighter1);

            int f1DamageTaken = Math.max(f2Atk - f1Def, 0);
            int f2DamageTaken = Math.max(f1Atk - f2Def, 0);
            f2Health = f2Health - f2DamageTaken;
            f1Health = f1Health - f1DamageTaken;

            System.out.println("Round " + roundCount);
            System.out.println(fighter1.name + "(F1) hits " + fighter2.name + "(F2) for " + f2DamageTaken + " points of damage");
            System.out.println(fighter2.name + "(F1) hits " + fighter1.name + "(F2) for " + f1DamageTaken + " points of damage");

            if(f2Health <= 5 && !f1HalfHealth){
                SignalMiddleToJester(fighter2);
                f2HalfHealth = true;
            }
            if(f1Health <= 5 && !f2HalfHealth){
                SignalMiddleToJester(fighter1);
                f1HalfHealth = true;
            }



            if (f1Health <= 0 && f2Health <= 0){
                //TODO: Add jester comment about both fighters being dead and starting over
                tieCount++;
                roundCount = 0;
                f1Health = 10;
                f2Health = 10;
                f1HalfHealth = false;
                f2HalfHealth = false;
            }
            else if (f1Health > 0 && f2Health <= 0){
                //TODO: Add jester comment about Fighter 1 being the winner
                winner = fighter1;
                break;
            }
            else if (f1Health <= 0 && f2Health > 0){
                //TODO: Add jester comment about Fighter 2 being the winner
                winner = fighter2;
                break;
            }

        }
    }

    private void SignalMiddleToJester(Fighter subject)
    {

    }
}
