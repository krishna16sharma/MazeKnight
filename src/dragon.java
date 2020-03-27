public class dragon extends Enemies{
    boolean aggressive=false;

    public dragon() throws InterruptedException{
        this.setName("Dragon");
        this.setHealth(300);
        this.setDamage(80);
        this.setArmor(100);
        //this.Encounter();
    }
    @Override
    public void Encounter() throws InterruptedException{
        System.out.println("Dragon:\n\tGRRRRAAAAHHH!!");
        Maze.delay(100);
        System.out.println("It's a huge dragon!");
    }
    public void SplAction(Enemies e) throws InterruptedException{
        if(this.getHealth()<=200 && !this.aggressive) {
            Maze.delay(100);
            System.out.println("Dragon:\nGRRROOOOAAH!");
            this.setDamage(100);
            this.setArmor(70);
            this.aggressive=true;
            Maze.delay(100);
            System.out.println("The dragon is more aggressive!");
            Maze.delay(100);
            System.out.println("But it seems to have let it's guard down...");
        }
    }
}
