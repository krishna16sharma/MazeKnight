public class giantSerpent extends Enemies {
    public giantSerpent() throws InterruptedException{
        this.setName("Giant Serpent");
        this.setHealth(100);
        this.setDamage(20);
        this.setArmor(35);
    }

    @Override
    public void Encounter() throws InterruptedException {
        Maze.delay(100);
        System.out.println("Giant Serpent:\n\tYou shall meet the same fate as the one I devoured a few years before!!");
        Maze.delay(2000);
        System.out.println("Knight:\n\tHmmm? Who was it?");
        Maze.delay(1000);
        System.out.println("Giant Serpent:\n\tAn adventurer like you...But he had no weaponsss..\n\tonly an armor.");
        Maze.delay(2000);
        System.out.println("\tHe put up a good fight neverthelesssss...");
        Maze.delay(1000);
        System.out.println("\tAnyway...\n\tPREPARE TO BE DEVOURED!");
        Maze.delay(1000);
        System.out.println("It\'s a giant serpent!");
    }
    public void SplAction(Enemies e,Knight k) throws InterruptedException{
        System.out.println("Giant Serpent:\n\tWe serpentsss can regenerate and heal.");
        Maze.delay(1000);
        System.out.println("The giant serpent regenerated some health!");
        e.setHealth(e.getHealth()+20);
        if(e.getHealth()>100){
            e.setHealth(100);
        }
    }
}
