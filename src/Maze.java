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
    public static void main(String[] args) throws InterruptedException {
        Scanner skip = new Scanner(System.in);
        System.out.println("Welcome to MazeKnight!\nDo you want to read the introduction?\n(Y)es\t(N)o");
        char ip = skip.next().toLowerCase().charAt(0);
        Maze m = new Maze();
        if(ip=='y') {
            m.Intro();
        }
        int encounterRate = 0;  //Chance to encounter enemy
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maze[i][j]='-';
                if(i==x && j==y){
                    maze[i][j]='X';
                }
                System.out.print(maze[i][j]+" ");
            }System.out.println();
        }
        Knight knight=new Knight();

        while(knight.alive.equals("yes")) {
            knight.move(x, y);
            knight.map();
            if(x==0 && y==4){
                if(dragonEncounter == 0) {
                    System.out.println("There is a castle!\nIt is quiet here.");
                    delay(2000);
                    System.out.println("Almost too quiet...");
                    delay(500);
                }
                System.out.println("You sense something above...");
                delay(500);
                if(dragonEncounter == 1){
                    System.out.println("It\'s back!");
                    delay(100);
                }
                dragonEncounter=1;
                dragon d = new dragon();
                Battle b =new Battle(knight,d);
            }
            if(x==2&&y==3){
                System.out.println("You find a wooden chest well hidden inside\na hollow tree trunk.");
                if(cArmor==0) {
                    System.out.print("You try to open it.");
                    delay(2000);
                    System.out.print(".");
                    delay(2000);
                    System.out.println(".");
                    delay(2000);
                    System.out.println("The chest opened with a creak.\nYou found a Chain Mail Armor!");
                    delay(500);
                    System.out.println("You equipped the Chain Mail Armor!");
                    cArmor=1;
                    knight.armor=80;
                }
                else{
                    delay(1000);
                    System.out.println("It\'s the chest that you opened before...You\nare slightly disappointed.");
                    delay(1000);
                }
            }
            if(x < 3 && y < 2){
                encounterRate = (int) (Math.random() * 8);
                if(encounterRate > 5){
                    Serpent serpent = new Serpent();
                    Battle b = new Battle(knight,serpent);
                }
                else if(dSword == 1 && gsDefeated == 0){
                    System.out.println("***Rumble Rumble***");
                    Maze.delay(1000);
                    System.out.println("Knight:\n\tSomething is underground!");
                    Maze.delay(2000);
                    System.out.println("A giant serpent emerged from the ground!");
                    giantSerpent gs = new giantSerpent();
                    Battle b = new Battle(knight,gs);
                }
            }
            if(x>=2 && y<2){
                encounterRate = (int) (Math.random() * 10);
                if(bcDefeated==0){
                    if(x == 4 && y == 0){
                        Maze.delay(1000);
                        System.out.println("It\'s an inn");
                        Maze.delay(1000);
                        if(innDiscovered == 0) {
                            System.out.println("Knight:\n\tI can probably get refreshed inside...");
                            Maze.delay(2000);
                            System.out.println("...");
                            Maze.delay(1000);
                            System.out.println("Knight:\n\tThat\'s funny...It is locked from the inside.");
                            Maze.delay(2000);
                            innDiscovered=1;
                        }
                        System.out.println("Inn keeper:\n\tGaah! A b-bandit\'s at my door!");
                        Maze.delay(1000);
                        System.out.println("\tWhy won't that moron leave already?");
                        Maze.delay(1000);
                        System.out.println("Knight:\n\tI can hear you, you know?");
                    }
                    if(encounterRate>8 && bcEncountered==0){
                        System.out.println("???:\n\tOi!");
                        Maze.delay(2000);
                        System.out.println("...!");
                        Maze.delay(1000);
                        System.out.println("???:\n\tI'm the one in charge around these parts!");
                        Maze.delay(2000);
                        System.out.println("\tHand over all your belongings if you want to live!");
                        Maze.delay(3000);
                        System.out.println("Knight:\n\tI refuse.");
                        Maze.delay(1000);
                        System.out.println("Bandit Chief:\n\t(W-What?)");
                        Maze.delay(1000);
                        System.out.println("\t(This guy is kinda scary...but my reputation\'s at stake here!)");
                        Maze.delay(4000);
                        bcEncountered=1;
                        banditChief bc = new banditChief();
                        Battle b = new Battle(knight,bc);
                    }
                    else if(encounterRate>8 && bcEncountered==1){
                        Maze.delay(1000);
                        System.out.println("???:\n\tGAAH!");
                        Maze.delay(1000);
                        System.out.println("Bandit Chief: Y-you again?");
                        Maze.delay(1000);
                        System.out.println("Knight:\n\t I just decided to spare you last time...");
                        Maze.delay(2000);
                        System.out.println("\tIt\'s annoying but I'll fight you!");
                        banditChief bc = new banditChief();
                        Battle b = new Battle(knight,bc);
                    }
                    else if(encounterRate>5){
                        bandit bandit = new bandit();
                        Battle b = new Battle(knight,bandit);
                    }
                }
                else{
                    if(x == 4 && y == 0){
                        Maze.delay(1000);
                        System.out.println("Inn keeper:\n\tWelcome, Brave knight!");
                        Maze.delay(1000);
                        int randDialogue = (int) (Math.random()*5);
                        if(randDialogue <= 1) {
                            System.out.println("You slept for some time and woke up feeling refreshed");
                            Maze.delay(2000);
                            System.out.println("Inn Keeper:\n\tI used to be an adventurer like you.\n\tBut then I took an " +
                                    "arrow to the knee");
                        }
                        else if(randDialogue <=4){
                            System.out.println("You had some food and drinks...\nYou are feeling energetic again!");
                            Maze.delay(2000);
                            System.out.println("Inn Keeper:\n\tYou sure showed the Bandits who\'s the boss around these parts!");
                            Maze.delay(3000);
                            System.out.println("\tThis is the least I can do!");
                        }
                        knight.health=100;
                        knight.status="healthy";
                        Maze.delay(1000);
                        System.out.println("Inn keeper:\n\tFeel free to come here again!");
                    }
                }
            }
            if(x==1 && y==4){
                System.out.println("You see charred trees nearby...");
                delay(1000);
                System.out.println("Knight:\n\tI sense danger...\n\tHope my equipment is sufficient to deal\n\t" +
                        "with whatever threat I encounter....");
                delay(3000);
            }
            if(x==1&&y==3){
                if(witchDefeated==0) {
                    witch w = new witch();
                    Battle b = new Battle(knight, w);
                }
                else{
                    delay(1000);
                    System.out.println("It\'s the witch's hut...");
                    delay(1000);
                    if(potion ==0) {
                        Scanner input = new Scanner(System.in);
                        System.out.println("You found a bottle of potion.");
                        delay(1000);
                        System.out.println("Knight:\n\tShould I consume this?\n(Y)es\t(N)o");
                        char inp = input.next().toLowerCase().charAt(0);
                        if(inp=='y') {
                            Maze.delay(1000);
                            System.out.println("You consumed the potion.\nYour Health was restored!");
                            knight.health=100;
                            potion = 1;
                        }
                    }
                }
            }
            if(x>=3){
                if(x==4 && y>=3 && cArmor == 1 && wSword == 0){
                    System.out.println("You spot a river...");
                    delay(2000);
                    System.out.println("you decide to quench your thirst...");
                    delay(3000);
                    System.out.println("As you bend down to drink water, your sword falls into the river.");
                    delay(5000);
                    System.out.print("...!");
                    delay(2000);
                    System.out.println("\nA fairy appears from the river!");
                    delay(1000);
                    System.out.println("Fairy:\n\tBrave knight! Is this silver sword yours?");
                    delay(4000);
                    System.out.println("Knight:\n\tNope! Neither is the gold sword which you'll bring soon.");
                    delay(4000);
                    System.out.println("Fairy\n\tOh! You seem to know the everything, Mr.Know-it-all....Not fun at all...");
                    delay(2000);
                    System.out.println("Take this new sword and get outta my sight!");
                    delay(2000);
                    System.out.println("You received the Warrior\'s sword!!");
                    knight.damage=20;
                    wSword=1;
                    delay(1000);
                    System.out.println("Knight:\n\tAlright! I can take on stronger opponents now!");
                }
                else if(x==4 && y>=3 && cArmor==0 && wSword == 0){
                    System.out.println("There\'s a river...");
                    delay(500);
                    System.out.println("But it is bear territory...better leave it alone.");
                }
                if(y>=3){
                    encounterRate = (int) (Math.random() * 10);
                    if(encounterRate>7){
                        bear bear = new bear();
                        Battle b = new Battle(knight,bear);
                    }
                }
            }
            if(knight.alive.equals("no")){
                delay(1000);
                System.out.println("You died bravely...");
                Achievements();
            }
        }
    }
}
