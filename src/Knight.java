import java.util.ArrayList;
import java.util.Scanner;

public class Knight {
    Scanner sc = new Scanner(System.in);
    int health;
    int armor;
    int damage;
    public String alive;
    public String status;
    ArrayList bag = new ArrayList<>();

    Knight(){   //Initialize stats for Knight
        health=100;
        armor=10;
        damage=10;
        status="healthy";
        alive="yes";
    }
    Maze m= new Maze();
    public void map(){      //Shows Map

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i==m.x && j==m.y){
                    m.maze[i][j]='X';
                }
                else{
                    m.maze[i][j]='-';
                }
                System.out.print(m.maze[i][j]+" ");
            }System.out.println();
        }
    }
    //Function to move in the direction specified
    public void move(int x, int y){
        System.out.println("Enter Direction (N/S/E/W)");
        char direction=sc.next().toLowerCase().charAt(0);
        switch(direction){
            case 'n':
                if(m.x-1>=0&&m.x-1<5)
                    m.x=m.x-1;
                else
                    invalid();
                break;
            case 's':
                if(m.x+1>=0&&m.x+1<5)
                    m.x=m.x+1;
                else
                    invalid();
                break;
            case 'e':
                if(m.y+1>=0&&m.y+1<5)
                    m.y=m.y+1;
                else
                    invalid();
                break;
            case 'w':
                if(m.y-1>=0&&m.y-1<5)
                    m.y=m.y-1;
                else
                    invalid();
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }
    public void invalid(){
        System.out.println("Can't go there.");
    }

    //Knight attacks enemies.
    public int Attack(Enemies e){
        int h=e.getHealth();
        int dmg=(int)(this.damage*this.damage)/(this.damage+e.getArmor());  //damage calculation
        h-=dmg;
        if(h<0){
            h=0;
        }
        e.setHealth(h);
        return dmg;
    }
}


