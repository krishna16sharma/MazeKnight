public class dragon extends Enemies{
    boolean aggressive=false;

    public dragon() throws InterruptedException{
        this.setName("Dragon");
        this.setHealth(300);
        this.setDamage(70);
        this.setArmor(100);
        //this.Encounter();
    }
    @Override
    public void Encounter() throws InterruptedException{
        System.out.println("Dragon:\n\tGRRRRAAAAHHH!!");
        Maze.delay(100);
        System.out.println("It's a huge dragon!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        if(this.getHealth()<=200 && !this.aggressive) {
            Maze.delay(1000);
            System.out.println("Dragon:\nGRRROOOOAAH!");
            this.setDamage(90);
            this.setArmor(70);
            this.aggressive=true;
            Maze.delay(1000);
            System.out.println("The dragon is more aggressive!");
            Maze.delay(500);
            System.out.println("But it seems to have let it's guard down...");
        }
        else{
            Maze.delay(1000);
            System.out.println("Dragon:\n\tGRRRRR...");
            Maze.delay(1000);
            System.out.println("The dragon hurled a huge ball of fire towards you!");
            int dmg=(int)(80*80)/(80+k.armor);
            k.health-=dmg;
            System.out.println("You took "+dmg+" damage!");
        }
    }
}
