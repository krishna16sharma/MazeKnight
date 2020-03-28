public class bandit extends Enemies{
    public bandit() throws InterruptedException{
        this.setName("Bandit");
        this.setHealth(50);
        this.setDamage(15);
    }

    @Override
    public void Encounter() throws InterruptedException {
        Maze.delay(100);
        System.out.println("Bandit:\n\t Give me everything you got!!");
        Maze.delay(1000);
        System.out.println("It\'s a bandit!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        Maze.delay(1000);
        System.out.println("Bandit:\n\tYou won't get away!!");
        Maze.delay(2000);
        System.out.println("Bandit:\n\tTAKE THIS!!");
        int dmg=(int)(20*20)/(20+k.armor);
        k.health-=dmg;
        if(k.health<0){
            k.health=0;
        }
        System.out.println("You took "+dmg+" damage!");
    }
}
