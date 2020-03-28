import java.util.Scanner;
public class Battle {
    Enemies e;
    Knight knight;
    //public static int e_count;    //Turn counter for enemies
    //public static int k_count;    //Turn counter for the knight
    boolean eTurn;
    int splChance;
    Scanner battle=new Scanner(System.in);//For getting input during battle

    public Battle(Knight knight,Enemies e) throws InterruptedException {
        this.e=e;
        this.knight=knight;
        //Start Battle
        //this.copyStats(e);
        //this.copyStats(knight);
        this.choice(knight);    //Calls function for Knight's turn
    }

    public boolean isVictorious(Knight k,Enemies enemies) throws InterruptedException{   //Checks if player wins
        if(enemies.getHealth()==0){
            System.out.println("You defeated "+enemies.getName()+"!");
            if(e.getName().equals("Serpent")){
               Maze.sCounter+=1;
               if(Maze.sCounter>=3 && Maze.wSword==1 && Maze.dSword==0){
                   Maze.delay(1000);
                   System.out.println("The serpent spat something out!");
                   Maze.delay(1000);
                   System.out.println("Unbelievable! You found a sword!");
                   Maze.delay(1000);
                   System.out.println("Not just any sword! The legendary Dragonbane Sword!");
                   Maze.delay(2000);
                   System.out.println("You equipped the Dragonbane Sword!");
                   knight.damage=30;
                   Maze.dSword=1;
                   System.out.println("Knight:\n\tThis sword is especially strong against dragons...");
               }
            }
            if(enemies.getName().equals("Witch")){
                Maze.witchDefeated = 1;
            }
            else if(enemies.getName().equals("Bandit Chief")){
                Maze.bcDefeated = 1;
            }
            else if(enemies.getName().equals("Dragon")){
                Maze.dragDefeated =1;
                System.out.println("Knight:\n\tHuff...argh!\n\tI-I did it...");
                Maze.delay(2000);
                System.out.println("The dragon lies motionless...");
                Maze.delay(1000);
                System.out.println("Knight:\n\tNo way!\n\tIt\'s just unconscious?");
                Maze.delay(1000);
                System.out.println("Do you want to kill it?\n(Y)es\t(N)o");
                Scanner input = new Scanner(System.in);
                char inp = input.next().toLowerCase().charAt(0);
                if(inp=='y') {
                    Maze.delay(1000);
                    System.out.println("Knight:\n\tThis is for the best...");
                    Maze.delay(1000);
                    System.out.println("You killed the dragon!");
                    Maze.dragKilled = 1;
                }
                else{
                    Maze.delay(1000);
                    System.out.println("Knight:\n\tIt has learnt its lesson...\n\tSo, I guess I'll spare it this time.");
                    Maze.delay(3000);
                    System.out.println("\tI should save the princess now.");
                }
                Maze.delay(1000);
                System.out.println("Knight:\n\tLet me tend to my wounds a bit...");
                knight.health+=30;
                finalBattle();
            }
            else if(enemies.getName().equals("Giant Serpent")){
                Maze.gsDefeated = 1;
                Maze.delay(1000);
                System.out.println("Knight:\n\tIt is dead...");
                Maze.delay(2000);
                System.out.println("You notice something bulging in its stomach.");
                Maze.delay(1000);
                System.out.println("You make a cut in its stomach...");
                Maze.delay(2000);
                System.out.println("No way!");
                Maze.delay(1000);
                System.out.println("You found the legendary Dragonbane Armor!");
                Maze.delay(1000);
                System.out.println("You equipped the Dragonbane Armor!");
                System.out.println("Knight:\n\tI hear that this armor is the best in the land.");
                Maze.delay(1000);
                knight.armor=100;
                Maze.dArmor=1;
            }
            if(enemies.getName().equals("Princess")){
                Maze.princessDefeated = 1;
                Maze.delay(1000);
                System.out.println("Knight:\n\tThis ends NOW!");
                Maze.delay(1000);
                System.out.println("Princess:\n\tNOOOO!");
                Maze.delay(1000);
                System.out.println("Knight:\n\tHYAAAH!");
                Maze.delay(1000);
                System.out.println("You killed the evil princess!");
                Maze.delay(1000);
                System.out.println("Knight:\n\tIt\'s finally over.!");
                Maze.delay(1000);
                System.out.println("Knight:\n\tBut who would\'ve thought....");
                Maze.delay(2000);
                System.out.println("\tI have a lot explaining to do to the King...");
                Maze.delay(2000);
                System.out.println("And so...");
                Maze.delay(1000);
                System.out.println("The King heard all you had to say...");
                Maze.delay(3000);
                System.out.println("The King had his doubts...");
                Maze.delay(3000);
                System.out.println("But the disappearances of certain books from the library,");
                Maze.delay(3000);
                System.out.println("the strange behavior of the dragon and the unusual amount of wealth in that castle,");
                Maze.delay(4000);
                System.out.println("all proved your point.");
                Maze.delay(2000);
                System.out.println("You were rewarded handsomely and were hailed as the hero that you dreamt to be!");
                Maze.delay(2000);
                System.out.println("THE END");
                Maze.Achievements();
            }
            return true;
        }
        return false;
    }
    public boolean isDefeated(Knight knight){      //Checks if player loses
        if(knight.health==0){
            System.out.println("You were defeated!");
            knight.alive="no";              //Knight dies
            return true;
        }
        return false;
    }
    /*public void copyStats(Enemies e){
        int arm = e.getArmor();
        int dmg = e.getDamage();
    }
    public void copyStats(Knight k){
        int arm = k.armor;
        int dmg = k.damage;
        String st  = k.status;
    }*/
    public void finalBattle() throws InterruptedException{
        Maze.delay(1000);
        System.out.println("You make your way inside the castle, to the top.\nYou check all rooms along the way.");
        Maze.delay(2000);
        System.out.println("On your way you see most rooms with chests full of jewel and coins.\nOther rooms look normal.");
        Maze.delay(4000);
        System.out.println("Knight:\n\tThis dragon seems to have an eye for gold and jewels.");
        Maze.delay(2000);
        System.out.println("Knight:\n\tThis is the last room...");
        Maze.delay(2000);
        System.out.println("\tPrincess!\n\tI\'ve come to rescue you!");
        Maze.delay(3000);
        System.out.println("Princess:\n\tYOU RUINED EVERYTHING!!");
        Maze.delay(1000);
        System.out.println("Knight:\n\tHuh?");
        Maze.delay(2000);
        System.out.println("Princess:\n\tDon\'t tell me that you thought a dragon\n\tis capable of identifying valuables.");
        Maze.delay(3000);
        System.out.println("\tDon\'t you see?\n\tI\'m the one who is controlling the dragon!");
        Maze.delay(2000);
        System.out.println("Knight:\n\tBut how?");
        Maze.delay(1000);
        System.out.println("Princess:\n\tI recently learnt magic from the royal library.\n\tI then realised that I could " +
                "become the richest in the land.");
        Maze.delay(5000);
        System.out.println("\tBut YOU RUINED MY DREAM!");
        Maze.delay(1000);
        System.out.println("\tYou also know my plan. So...");
        Maze.delay(2000);
        System.out.println("\tyou\'ll die here!");
        Maze.delay(1000);
        System.out.println("Knight:\n\tI will fight for justice! You\'ll be the one to die!");
        Maze.delay(2000);
        Princess p = new Princess();
        Battle b = new Battle(knight,p);
    }

    public void e_Fight() throws InterruptedException{        //Enemy's Turn of the fight

        if(e.getHealth()>0){//Knight's didn't win yet, so enemy's turn
            if(eTurn == false) {
                if(splChance > 3) {
                    e.SplAction(e,knight);
                    eTurn = true;
                }
            }
            if(eTurn == false) {
                System.out.println("You took " + e.Attack(knight) + " damage!");
            }
         /*   if(isDefeated(knight)==false){      //Checks if Knight survives attack.
                choice(knight);
            }*/
        }
    }
    //Knight's turn
    public void choice(Knight knight) throws InterruptedException{
        while(!isVictorious(knight,e) && !isDefeated(knight)) {
            System.out.println("Your condition:");
            System.out.println("Health: " + knight.health + "    status: " + knight.status);
            Maze.delay(300);
            System.out.println(e.getName() + "'s condition:");
            System.out.println("Health: " + e.getHealth());
            Maze.delay(300);
            System.out.println("What will you do?\n(F)ight\t(R)un");
            String action = battle.next();
            action = action.toLowerCase();
            char ch = action.charAt(0);
            eTurn = false;    //flag to check if enemy has used up a turn
            splChance = (int) (Math.random() * 5);     //Chance of using special action
            if (ch == 'f') {
                System.out.println(e.getName() + " took " + knight.Attack(e) + " damage!");   //Knight attacks
                this.e_Fight();
                Maze.delay(200);
            }
            if (ch == 'r') {
                int chance = (int) (Math.random() * 5);
                if(e.getName().equals("Giant Serpent")){
                    Maze.delay(1000);
                    System.out.println("Giant Serpent:\n\tYou can\'t run from me!");
                    this.e_Fight();
                }
                if(e.getName().equals("Princess")){
                    Maze.delay(1000);
                    System.out.println("The door is sealed shut with magic!");
                    Maze.delay(1000);
                    System.out.println("Your best option is to fight!");
                }
                else if (chance >= 3) {
                    System.out.println("Fled successfully!");
                    break;
                    //knight.map();
                }
                else {
                    System.out.println("Couldn't flee!");
                    this.e_Fight();
                }
            }
        }
    }

}
