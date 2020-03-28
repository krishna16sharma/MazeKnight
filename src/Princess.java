public class Princess extends Enemies{
    boolean wrongBook = true;
    boolean dragonAttack = true;
    public Princess() throws InterruptedException{

        this.setName("Princess");
        this.setHealth(70);
        this.setArmor(25);
        this.setDamage(25);
    }

    @Override
    public void Encounter() throws InterruptedException{
        Maze.delay(1000);
        System.out.println("Princess:\n\tI\'m not going to let you leave this place alive!");
        Maze.delay(1000);
        System.out.println("It's the princess!");
        Maze.delay(1000);
        System.out.println("The door to the room is sealed shut with magic!");
        Maze.delay(1000);
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException {
        if(wrongBook && Maze.dragKilled == 1){
           Maze.delay(1000);
           System.out.println("Princess:\n\tThis spell will fry you alive!");
           Maze.delay(1000);
           k.health+=40;
           System.out.println("Knight:\n\tHuh? That didn't hurt.");
           Maze.delay(1000);
           System.out.println("Princess:\n\tEek! I\'m still holding the book of healing spells!\n\tI wanted to heal my dragon..");
           Maze.delay(3000);
           wrongBook=false;
        }
        else if(dragonAttack && Maze.dragKilled == 0){
            dragonAttack = false;
            Maze.delay(1000);
            System.out.println("???:\n\tGROOOH!");
            Maze.delay(1000);
            System.out.println("The wall collapsed!\nIt\'s the dragon!");
            Maze.delay(3000);
            System.out.println("The Dragon hurled a fireball at the princess!");
            int dmg=(int)(50*50)/(50+this.getArmor());
            Maze.delay(2000);
            System.out.println("Princess:\n\tAAAAH!");
            this.setHealth(this.getHealth()-dmg);
            if(this.getHealth()<0){
                this.setHealth(1);  //Don't let the dragon kill
            }
            System.out.println("Princess:\n\tGAAH!\n\tGo to sleep you filthy reptile!");
            Maze.delay(2000);
            System.out.println("The dragon fell asleep!");
            Maze.delay(2000);
            System.out.println("Princess:\n\tThis fight would be over quickly if I was able\n\tto find a" +
                    " spell to put humans to sleep too..");
            Maze.delay(4000);
            System.out.println("Princess: Or even better...A spell to kill them instantly!");
            Maze.delay(2000);
        }
        else {
            Maze.delay(1000);
            System.out.println("Princess:\n\tTake this!");
            Maze.delay(1000);
            System.out.println("Sparks fly towards you!");
            int dmg = (int) (35 * 35) / (35 + k.armor);
            k.health -= dmg;
            if(k.health<0){
                k.health=0;
            }
            System.out.println("You took " + dmg + " damage!");
        }
    }
}
