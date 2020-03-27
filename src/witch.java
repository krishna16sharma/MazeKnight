public class witch extends Enemies{
    public witch() throws InterruptedException{
        this.setName("Witch");
        this.setHealth(30);
        this.setArmor(20);
        //this.Encounter();
    }

    @Override
    public void Encounter() throws InterruptedException{
        System.out.println("Witch:\n\tNever should have come here!");
        Maze.delay(100);
        System.out.println("It's a witch!");
    }
    public void SplAction(Enemies e) throws InterruptedException {
        Maze.delay(100);
        this.setHealth(30);
        System.out.println("The witch drank some potion!");
        System.out.println("Witch:\n\tHehehe! I'm alright now!!");
    }
}
