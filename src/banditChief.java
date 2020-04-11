public class banditChief extends Enemies {
    public banditChief() throws InterruptedException{
        this.setName("Bandit Chief");
        this.setHealth(80);
        this.setDamage(15);
    }

    @Override
    public void Encounter() throws InterruptedException {
        Maze.delay(100);
        System.out.println("Bandit Chief:\n\t Then prepare to face the chief of bandits!!");
        Maze.delay(1000);
        System.out.println("It\'s the Bandit Chief!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        Maze.delay(1000);
        System.out.println("Bandit Chief:\n\tI-I'll kill you!!");
        Maze.delay(2000);
        System.out.println("Bandit Chief:\n\tHAAAA!!");
        int dmg=(int)(20*20)/(20+ k.getArmor());
        k.setHealth(k.getHealth()-dmg);
        if(k.getHealth() <0){
            k.setHealth(0);
        }
        System.out.println("You took "+dmg+" damage!");
    }
}
