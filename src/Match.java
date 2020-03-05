public class Match {

    Fighter fighter1;
    Fighter fighter2;
    Jester jester;
    Fighter winner;

    public Match(Fighter f1, Fighter f2)
    {
       fighter1 = f1;
       fighter2 = f2;
    }

    public void PlayMatch()
    {
        // These are the function calls that will be used in every combat turn to get the
        // attack and defense performances for each fighter.
        // Figured I'd include these cause they're long and there's a lot of 
        // parentheses.
        fighter1.getAttackPerformance(fighter1.strongerThan(fighter2.strength), fighter1.fasterThan(fighter2.speed));
        fighter2.getAttackPerformance(fighter2.strongerThan(fighter1.strength), fighter1.fasterThan(fighter1.speed));

        fighter1.getDefensePerformance(fighter1.longerReachThan(fighter2.reach), fighter1.fasterThan(fighter2.speed));
        fighter2.getDefensePerformance(fighter2.longerReachThan(fighter1.reach), fighter1.fasterThan(fighter1.speed));
    }

    private void SignalMiddleToJester()
    {

    }
}
