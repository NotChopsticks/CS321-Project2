public class Match {
    /**
     * One of two fighters in the match
     */
    Fighter fighter1;
    /**
     * The other fighter in the match
     */
    Fighter fighter2;
    /**
     * The jester that will comment on the match
     */
    Jester jester;
    /**
     * The fighter object that stores the winner of the match
     */
    Fighter winner;
    /**
     * Number of rounds
     */
    int roundCount;
    /**
     * Number of ties that have occurred 
     */
    int tieCount;
    /**
     * The expected winner of the match
     */
    Fighter expected;

    /**
     * constructor for the match
     */
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

    /**
     * method that plays one match of two fighters
     * uses method calls from other classes to play the match
     * @param last
     */
    public void PlayMatch(boolean last)
    {
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

            if(f1Health <= 5 && !f1HalfHealth && f2Health > 0 && f1Health > 0){
                SignalMiddleToJester(fighter1);
                f1HalfHealth = true;
            }
            else if(f2Health <= 5 && !f2HalfHealth && f2Health > 0 && f1Health > 0){
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
                System.out.println("Press Enter to continue \n");
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

    /**
     * Signals that a fighter has dropped below half of their health
     * @param subject
     */
    private void SignalMiddleToJester(Fighter subject)
    {
        jester.CommentOnMiddle(subject);
    }
}
