public class bear extends Enemies{

    public bear() throws InterruptedException{
        this.setName("Bear");
        this.setHealth(120);
        this.setDamage(40);
    }
    @Override
    public void Encounter() throws InterruptedException {
        Maze.delay(100);
        System.out.println("Bear:\n\tGrrrroah!!");
        Maze.delay(100);
        System.out.println("It\'s a bear!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        Maze.delay(100);
        System.out.println("The bear sharpened its claws!!");
        this.setDamage(this.getDamage()+5);
    }
}