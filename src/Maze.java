/* This class runs the new game.
 */
public class Maze {
    public static char[][] maze= new char[5][5];
    public static int x=4,y=1;//x=row , y= column
    static int cArmor=0;     //Flag for ChainMail Armor
    static int dragonEncounter=0;     //Flag to check if dragon was encountered.
    static int wSword=0;
    static int witchDefeated=0;
    //Function to generate delay. Makes it more comfortable to read texts
    //Will need to specify throws Interrupted Exception while using
    public static void delay(int t) throws InterruptedException{
        Thread.sleep(t);
    }
    //Main Function
    public static void main(String[] args) throws InterruptedException {
        Maze m = new Maze();
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
                    System.out.println("Fairy\n\tOh! You seem to know the drill....Not fun at all...");
                    delay(1000);
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
                    int encounterRate = (int) (Math.random() * 10);
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
            knight.map();
        }
    }
}