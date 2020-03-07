public class Match {

    Fighter fighter1;
    Fighter fighter2;
    Jester jester;
    Fighter winner;
    int roundCount;
    //Boolean debug = true;
    int tieCount;
    Fighter expected;

    public Match(Fighter f1, Fighter f2)
    {
       fighter1 = f1;
       fighter2 = f2;
       jester = new Jester();
       roundCount = 0;
       winner = null;
       tieCount = 0;
       if((f1.strength + f1.speed + f1.reach) > (f2.strength + f2.speed + f2.reach))
        expected = f1;
        else
        expected = f2;
    }

    public void PlayMatch(boolean last)
    {
        // These are the function calls that will be used in every combat turn to get the
        // attack and defense performances for each fighter.
        // Figured I'd include these cause they're long and there's a lot of 
        // parentheses.
        int f1Health = 10;
        int f2Health = 10;
        boolean f1HalfHealth = false;
        boolean f2HalfHealth = false;
        boolean tieStated = false;
        jester = new Jester();
        
        jester.CommentOnStart(expected); 

        while(true) {
            if (!tieStated && tieCount > 0){
                System.out.println("Run " + (tieCount+1));
                tieStated = true;
            }

            roundCount++;
            int f1Atk = fighter1.getAttackPerformance(fighter2);
            int f2Atk = fighter2.getAttackPerformance(fighter1);

            int f1Def = fighter1.getDefensePerformance(fighter2);
            int f2Def = fighter2.getDefensePerformance(fighter1);

            int f1DamageTaken = Math.max(f2Atk - f1Def, 0);
            int f2DamageTaken = Math.max(f1Atk - f2Def, 0);
            f2Health = f2Health - f2DamageTaken;
            f1Health = f1Health - f1DamageTaken;

            System.out.println("\nRound " + roundCount);
            System.out.println(fighter1.name + " hits for " + f2DamageTaken + " points of damage");
            System.out.println(fighter2.name + " hits for " + f1DamageTaken + " points of damage");
            System.out.println(fighter1.name + " Remaining Health: " + f1Health);
            System.out.println(fighter2.name + " Remaining Health: " + f2Health);

            if(f1Health <= 5 && !f1HalfHealth){
                SignalMiddleToJester(fighter1);
                f1HalfHealth = true;
            }
            else if(f2Health <= 5 && !f2HalfHealth){
                SignalMiddleToJester(fighter2);
                f2HalfHealth = true;
            }



            if (f1Health <= 0 && f2Health > 0){
                //TODO: Add jester comment about Fighter 2 being the winner
                //System.out.println(fighter1.name + " wins this match");
                winner = fighter2;
                jester.CommentOnEnd(winner, expected, last);
                break;
            }
            else if (f1Health > 0 && f2Health <= 0){
                //TODO: Add jester comment about Fighter 1 being the winner
                //System.out.println(fighter2.name + " wins this match");
                winner = fighter1;
                jester.CommentOnEnd(winner, expected, last);
                break;
            }
            else if (f1Health <= 0 && f2Health <= 0){
                //TODO: Add jester comment about both fighters being dead and starting over
                jester.CommentOnTie();
                System.out.println("Press Enter to continue");
                try{System.in.read();}
                catch(Exception e){}
                tieCount++;
                roundCount = 0;
                f1Health = 10;
                f2Health = 10;
                f1HalfHealth = false;
                f2HalfHealth = false;
                tieStated = false;
            }

        }
    }

    private void SignalMiddleToJester(Fighter subject)
    {
        jester.CommentOnMiddle(subject);
    }
}
