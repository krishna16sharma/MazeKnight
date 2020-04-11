import java.util.Scanner;

public class GameSystem {
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
                m.maze[i][j]='-';
                if(i==m.x && j==m.y){
                    m.maze[i][j]='X';
                }
                System.out.print(m.maze[i][j]+" ");
            }System.out.println();
        }
        Knight knight=new Knight();

        while(knight.alive.equals("yes")) {
            knight.move(m.x, m.y);
            knight.map();
            if(m.x==0 && m.y==4){
                if(m.dragonEncounter == 0) {
                    System.out.println("There is a castle!\nIt is quiet here.");
                    m.delay(2000);
                    System.out.println("Almost too quiet...");
                    m.delay(500);
                }
                System.out.println("You sense something above...");
                m.delay(500);
                if(m.dragonEncounter == 1){
                    System.out.println("It\'s back!");
                    m.delay(100);
                }
                m.dragonEncounter=1;
                dragon d = new dragon();
                Battle b =new Battle(knight,d);
            }
            if(m.x==2&&m.y==3){
                System.out.println("You find a wooden chest well hidden inside\na hollow tree trunk.");
                if(Maze.cArmor==0) {
                    System.out.print("You try to open it.");
                    m.delay(2000);
                    System.out.print(".");
                    m.delay(2000);
                    System.out.println(".");
                    m.delay(2000);
                    System.out.println("The chest opened with a creak.\nYou found a Chain Mail Armor!");
                    m.delay(500);
                    System.out.println("You equipped the Chain Mail Armor!");
                    Maze.cArmor=1;
                    knight.setArmor(80);
                }
                else{
                    m.delay(1000);
                    System.out.println("It\'s the chest that you opened before...You\nare slightly disappointed.");
                    m.delay(1000);
                }
            }
            if(m.x < 3 && m.y < 2){
                encounterRate = (int) (Math.random() * 8);
                if(encounterRate > 5){
                    Serpent serpent = new Serpent();
                    Battle b = new Battle(knight,serpent);
                }
                else if(Maze.dSword == 1 && Maze.gsDefeated == 0){
                    System.out.println("***Rumble Rumble***");
                    Maze.delay(1000);
                    System.out.println("Knight:\n\tSomething is underground!");
                    Maze.delay(2000);
                    System.out.println("A giant serpent emerged from the ground!");
                    giantSerpent gs = new giantSerpent();
                    Battle b = new Battle(knight,gs);
                }
            }
            if(m.x>=2 && m.y<2){
                encounterRate = (int) (Math.random() * 10);
                if(Maze.bcDefeated==0){
                    if(m.x == 4 && m.y == 0){
                        Maze.delay(1000);
                        System.out.println("It\'s an inn");
                        Maze.delay(1000);
                        if(Maze.innDiscovered == 0) {
                            System.out.println("Knight:\n\tI can probably get refreshed inside...");
                            Maze.delay(2000);
                            System.out.println("...");
                            Maze.delay(1000);
                            System.out.println("Knight:\n\tThat\'s funny...It is locked from the inside.");
                            Maze.delay(2000);
                            Maze.innDiscovered=1;
                        }
                        System.out.println("Inn keeper:\n\tGaah! A b-bandit\'s at my door!");
                        Maze.delay(1000);
                        System.out.println("\tWhy won't that moron leave already?");
                        Maze.delay(1000);
                        System.out.println("Knight:\n\tI can hear you, you know?");
                    }
                    if(encounterRate>8 && Maze.bcEncountered==0){
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
                        Maze.bcEncountered=1;
                        banditChief bc = new banditChief();
                        Battle b = new Battle(knight,bc);
                    }
                    else if(encounterRate>8 && Maze.bcEncountered==1){
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
                    if(m.x == 4 && m.y == 0){
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
                        knight.setHealth(100);
                        knight.status="healthy";
                        Maze.delay(1000);
                        System.out.println("Inn keeper:\n\tFeel free to come here again!");
                    }
                }
            }
            if(m.x==1 && m.y == 4){
                System.out.println("You see charred trees nearby...");
                Maze.delay(1000);
                System.out.println("Knight:\n\tI sense danger...\n\tHope my equipment is sufficient to deal\n\t" +
                        "with whatever threat I encounter....");
                Maze.delay(3000);
            }
            if(m.x==1&&m.y==3){
                if(Maze.witchDefeated==0) {
                    witch w = new witch();
                    Battle b = new Battle(knight, w);
                }
                else{
                    Maze.delay(1000);
                    System.out.println("It\'s the witch's hut...");
                    Maze.delay(1000);
                    if(Maze.potion ==0) {
                        Scanner input = new Scanner(System.in);
                        System.out.println("You found a bottle of potion.");
                        Maze.delay(1000);
                        System.out.println("Knight:\n\tShould I consume this?\n(Y)es\t(N)o");
                        char inp = input.next().toLowerCase().charAt(0);
                        if(inp=='y') {
                            Maze.delay(1000);
                            System.out.println("You consumed the potion.\nYour Health was restored!");
                            knight.setHealth(100);
                            Maze.potion = 1;
                        }
                    }
                }
            }
            if(m.x>=3){
                if(m.x==4 && m.y>=3 && Maze.cArmor == 1 && Maze.wSword == 0){
                    System.out.println("You spot a river...");
                    Maze.delay(2000);
                    System.out.println("you decide to quench your thirst...");
                    Maze.delay(3000);
                    System.out.println("As you bend down to drink water, your sword falls into the river.");
                    Maze.delay(5000);
                    System.out.print("...!");
                    Maze.delay(2000);
                    System.out.println("\nA fairy appears from the river!");
                    Maze.delay(1000);
                    System.out.println("Fairy:\n\tBrave knight! Is this silver sword yours?");
                    Maze.delay(4000);
                    System.out.println("Knight:\n\tNope! Neither is the gold sword which you'll bring soon.");
                    Maze.delay(4000);
                    System.out.println("Fairy\n\tOh! You seem to know the everything, Mr.Know-it-all....Not fun at all...");
                    Maze.delay(2000);
                    System.out.println("Take this new sword and get outta my sight!");
                    Maze.delay(2000);
                    System.out.println("You received the Warrior\'s sword!!");
                    knight.setDamage(20);
                    Maze.wSword=1;
                    Maze.delay(1000);
                    System.out.println("Knight:\n\tAlright! I can take on stronger opponents now!");
                }
                else if(m.x==4 && m.y>=3 && Maze.cArmor==0 && Maze.wSword == 0){
                    System.out.println("There\'s a river...");
                    Maze.delay(500);
                    System.out.println("But it is bear territory...better leave it alone.");
                }
                if(m.y>=3){
                    encounterRate = (int) (Math.random() * 10);
                    if(encounterRate>7){
                        bear bear = new bear();
                        Battle b = new Battle(knight,bear);
                    }
                }
            }
            if(knight.alive.equals("no")){
                Maze.delay(1000);
                System.out.println("You died bravely...");
                Maze.Achievements();
            }
        }
    }
}
