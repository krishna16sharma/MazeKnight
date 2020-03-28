public class Serpent extends Enemies{
    public Serpent() throws InterruptedException{
            this.setName("Serpent");
            this.setHealth(40);
            this.setDamage(15);
            this.setArmor(30);
       }

       @Override
        public void Encounter() throws InterruptedException {
            Maze.delay(100);
            System.out.println("Serpent:\n\t Hissss!!");
            Maze.delay(1000);
            System.out.println("It\'s a serpent!");
        }
        public void SplAction(Enemies e,Knight k) throws InterruptedException{
            Maze.delay(1000);
            System.out.println("The serpent regenerated some health!");
            e.setHealth(e.getHealth()+20);
            if(e.getHealth()>40){
                e.setHealth(40);
            }
        }
}
