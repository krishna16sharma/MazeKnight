public class dragon extends Enemies{
    boolean aggressive=false;

    public dragon() throws InterruptedException{
        this.setName("Dragon");
        this.setHealth(150);
        this.setDamage(40);
        if(Maze.dSword == 1){
            if(Maze.dArmor == 1){
                this.setDamage(40);
            }
            this.setArmor(20);  //dSword is effective against dragons
        }
        else {
            this.setArmor(50);
        }
        //this.Encounter();
    }
    @Override
    public void Encounter() throws InterruptedException{
        System.out.println("Dragon:\n\tGRRRRAAAAHHH!!");
        Maze.delay(100);
        System.out.println("It's a huge dragon!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        if(this.getHealth()<60 && !this.aggressive) {
            Maze.delay(1000);
            System.out.println("Dragon:\nGRRROOOOAAH!");
            this.setDamage(this.getDamage()+20);
            this.setArmor(this.getArmor()-10);
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
            int dmg=(int)(50*50)/(50+k.armor);
            k.health-=dmg;
            System.out.println("You took "+dmg+" damage!");
        }
    }
}
