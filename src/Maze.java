/* This class runs the new game.
 */
public class Maze {

    public static char[][] maze= new char[5][5];
    public static int x=4,y=1;//x=row , y= column
    static int cArmor=0;     //Flag for ChainMail Armor
    static int dragonEncounter = 0;     //Flag to check if dragon was encountered.
    static int bcEncountered = 0;       //Flag to check if Bandit Chief was encountered
    static int innDiscovered=0;
    static int wSword=0;
    static int witchDefeated=0;
    static int bcDefeated=0;
    //Function to generate delay. Makes it more comfortable to read texts
    //Will need to specify throws Interrupted Exception while using
    public static void delay(int t) throws InterruptedException{
        Thread.sleep(t);
    }
    //Main Function
    public static void main(String[] args) throws InterruptedException {
        Maze m = new Maze();
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
                    System.out.println("It's a quiet clearing.");
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
                        System.out.println("\n\tWhy won't that moron leave already?");
                        Maze.delay(1000);
                        System.out.println("Knight:\n\tI can hear you, you know?");
                    }
                    if(encounterRate>8 && bcEncountered==0){
                        Maze.delay(1000);
                        System.out.println("???:\n\tOi!");
                        Maze.delay(1000);
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
                            System.out.println("\n\tThis is the least I can do!");
                        }
                        knight.health=100;
                        knight.status="healthy";
                        Maze.delay(1000);
                        System.out.println("Inn keeper:\n\tFeel free to come here again!");
                    }
                }
            }
            if(x==1&&y==3){
                if(witchDefeated==0) {
                    witch w = new witch();
                    Battle b = new Battle(knight, w);
                }
                else{
                    delay(1000);
                    System.out.println("It\'s the witch's hut...");
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
            }
        }
    }
}
