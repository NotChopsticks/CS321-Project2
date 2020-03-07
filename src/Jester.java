import java.util.Random;

public class Jester {

    public Jester() {
    }

    public void CommentOnStart(Fighter expected) {
        Random rand = new Random();
        int response;
        response = rand.nextInt(4);
        
        switch(response) {
        case 0:
        System.out.println("It looks to me like " + expected.name + " is the better fighter! But we'll see how it goes! \n");
        break;
        case 1:
        System.out.println("My money's on " + expected.name + "! But hey let's have a good clean match! \n");
        break;
        case 2:
        System.out.println("Wow! " + expected.name + "Looks like the clear winner to me! \n");
        break;
        case 3:
        System.out.println("Here come the fighters and Oh! " + expected.name + " has already got this match in the bag, I can tell! \n");
        break;
        }
    }

    public void CommentOnMiddle(Fighter subject) {
        Random rand = new Random();
        int response;
        response = rand.nextInt(4);
        
        switch(response) {
        case 0:
        System.out.println(subject.name + " doesn't look so good to me! I think it's just about over! \n");
        break;
        case 1:
        System.out.println("Man, " + subject.name + " is really on the ropes! \n");
        break;
        case 2:
        System.out.println("Looks like " + subject.name + " can't take much more! \n");
        break;
        case 3:
        System.out.println("You sure you won't forfeit, " + subject.name + "? Nah just kidding, we don't allow that! \n");
        break;
        }
    }

    public void CommentOnEnd(Fighter winner, Fighter expected, boolean last) {
        if(winner == expected) {
            if(last) {
                Random rand = new Random();
                int response;
                response = rand.nextInt(4);
                
                switch(response) {
                case 0:
                System.out.println(winner.name + " has won the whole tournament! I knew it the whole time! \n");
                break;
                case 1:
                System.out.println("Our ultimate winner is " + winner.name + "! Congratulations! Now back to the dungeons with you! \n");
                break;
                case 2:
                System.out.println(winner.name + " did it! Our champion, ladies and gentlemen! \n");
                break;
                case 3:
                System.out.println("Outstanding work in this tournament, " + winner.name + "! See you again next week in our champion's bracket! \n");
                break;
                }
            }
            else {
                Random rand = new Random();
                int response;
                response = rand.nextInt(4);
                
                switch(response) {
                case 0:
                System.out.println("Good work, " + winner.name + "! I knew you'd win! Now on to the next round! \n");
                break;
                case 1:
                System.out.println("Haha I knew " + winner.name + " would win! Let's see how the next round goes! \n");
                break;
                case 2:
                System.out.println(winner.name + " wins! I called it! Can I pick 'em or what?");
                break;
                case 3:
                System.out.println("Just like I said, " + winner.name + " has won! Man I'm good! \n");
                break;
                }
            }
        }
        else{
            if(last){
                Random rand = new Random();
                int response;
                response = rand.nextInt(2);
                
                switch(response) {
                case 0:
                System.out.println("I CAN HARDLY BELIEVE IT! WHAT A MATCH!!! " + winner.name + " HAS WON THE TOURNAMENT AGAINST ALL ODDS!!! \n");
                break;
                case 1:
                System.out.println("IN A STROKE OF PURE BRILLIANCE AND SKILL YOU, " + winner.name + ", HAVE WON THE TOURNAMENT! Tell us, friend! What will you do with your 5 silver in victory earnings? \n");
                break;
                }
            }
            else{
                Random rand = new Random();
                int response;
                response = rand.nextInt(2);
                
                switch(response) {
                case 0:
                System.out.println("AMAZING! WHAT AN UPSET! " + winner.name + " HAS WON! " + winner.name + " GOES ON TO THE NEXT ROUND! \n");
                break;
                case 1:
                System.out.println("Holy cow! " + winner.name + " actually won! C'mon, dude, you're making me look bad! \n");
                break;
            }
        }
        }
    }

    public void CommentOnTie() {
        Random rand = new Random();
        int response;
        response = rand.nextInt(4);
        
        switch(response) {
        case 0:
        System.out.println("Goodness me! A tie! Well that won't do, let's try that again! \n");
        break;
        case 1:
        System.out.println("C'mon guys! A tie? Really? Ah well, let's take it from the top! \n");
        break;
        case 2:
        System.out.println("What? A tie? Alright alright, guys, get back up! This is no time to be laying around! Let's go again! \n");
        break;
        case 3:
        System.out.println("Awwwww a tie? Well it can't be helped! One more time, guys! Or else you'll both be in the pit for a week! \n");
        break;
        }
    }

}
