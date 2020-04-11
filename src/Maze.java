import java.util.Scanner;

/* This class runs the new game.
 */
public class Maze {

    public static char[][] maze= new char[5][5];
    public static int x=4,y=1;//x=row , y= column
    static int cArmor = 0;     //Flag for ChainMail Armor
    static int dArmor = 0;
    static int dragonEncounter = 0;     //Flag to check if dragon was encountered.
    static int bcEncountered = 0;       //Flag to check if Bandit Chief was encountered
    static int innDiscovered=0;
    static int wSword=0;
    static int dSword=0;
    static int witchDefeated=0;
    static int bcDefeated=0;
    static int gsDefeated=0;
    static int dragDefeated=0;
    static int dragKilled = 0;
    static int princessDefeated = 0;
    static int potion = 0;
    static int sCounter=0;  //Counter for serpents killed
    //Function to generate delay. Makes it more comfortable to read texts
    //Will need to specify throws Interrupted Exception while using
    public static void delay(int t) throws InterruptedException{
        Thread.sleep(t);
    }

    //Display achievements after game is over
    public static void Achievements() throws InterruptedException{
        delay(1000);
        System.out.println("Achievements:");
        delay(2000);
        if(cArmor == 1){
            System.out.println("Chain Mail Armor found!");
        }
        if(dArmor == 1){
            System.out.println("Dragonbane Armor found!");
        }
        if(wSword == 1){
            System.out.println("Warrior\'s Sword found!");
        }
        if(dSword == 1){
            System.out.println("Dragonbane Sword found!");
        }
        if(witchDefeated == 1){
            System.out.println("Witch defeated! \t");
        }
        if(bcDefeated == 1){
            System.out.println("Bandits Begone! Bandit King defeated!");
        }
        if(gsDefeated == 1){
            System.out.println("You're Hissstory! Giant Serpent defeated!");
        }
        if(dragDefeated == 1){
            System.out.println("Conqueror of dragons! Dragon defeated!");
        }
        if(dragKilled == 1 && dragDefeated == 1){
            System.out.println("Dragon Slayer! Dragon Killed!");
        }
        if(dragDefeated == 1 && dragKilled == 0){
            System.out.println("Dragon\'s friend! Didn\'t kill dragon.");
        }
        if(princessDefeated == 1){
            System.out.println("True Knight! Evil princess defeated!");
        }
        delay(1000);
        System.out.println("Thanks for playing!");
        delay(2000);
        System.exit(0);
    }
    //Main Function
    public void Intro() throws InterruptedException{
        System.out.println("Once upon a time, in a kingdom far, far away,");
        delay(2000);
        System.out.println("there lived a very troubled King.");
        delay(3000);
        System.out.println("The kingdom was once attacked by a dragon and it\'s wealth was looted.");
        delay(4000);
        System.out.println("Even the princess went missing after the dragon attacked for the first time");
        delay(4000);
        System.out.println("The dragon returned frequently and looted the kingdom and the neighboring kingdoms");
        delay(5000);
        System.out.println("Many tried to fend it off but they died in battle with the beast.");
        delay(2000);
        System.out.println("You are a knight who didn\'t get an opportunity to showcase your talent");
        delay(4000);
        System.out.println("You\'ve always wanted to be recognised by the King.");
        delay(2000);
        System.out.println("So you set out to the forest where the dragon was sighted to slay it,");
        delay(2000);
        System.out.println("and find the princess.");
    }

}
