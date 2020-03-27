import java.util.Scanner;
public class Battle {
    Enemies e;
    Knight knight;
    public static int e_count;    //Turn counter for enemies
    public static int k_count;    //Turn counter for the knight
    boolean eTurn;
    int splChance;
    Scanner battle=new Scanner(System.in);//For getting input during battle


    public Battle(Knight knight,Enemies e) throws InterruptedException {
        this.e=e;
        this.knight=knight;
        this.e_count=0;
        this.k_count=0;
        //Start Battle
        this.copyStats(e);
        this.copyStats(knight);
        this.choice(knight);    //Calls function for Knight's turn
    }

    public boolean isVictorious(Knight k,Enemies enemies){   //Checks if player wins
        if(enemies.getHealth()==0){
            System.out.println("You defeated "+enemies.getName()+"!");
            k_count=0;
            e_count=0;
            //k.map();
            if(enemies.getName().equals("Witch")){
                Maze.witchDefeated=1;
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
    public void copyStats(Enemies e){
        int arm = e.getArmor();
        int dmg = e.getDamage();
    }
    public void copyStats(Knight k){
        int arm = k.armor;
        int dmg = k.damage;
        String st  = k.status;
    }
    public void e_Fight() throws InterruptedException{        //Enemy's Turn of the fight

        if(e.getHealth()>0){//Knight's didn't win yet, so enemy's turn
            if(eTurn == false) {
                if(splChance > 3) {
                    e.SplAction(e);
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
            System.out.println("What will you do?\n(F)ight\t(I)tem\t(R)un");
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
                if (chance >= 3) {
                    System.out.println("Fled successfully!");
                    break;
                    //knight.map();
                } else {
                    System.out.println("Couldn't flee!");
                    this.e_Fight();
                }
            }
        }
    }

}
