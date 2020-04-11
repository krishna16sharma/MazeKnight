public class Enemies extends Character{
    private String Name="???";


    public Enemies() throws InterruptedException {
        setHealth(50);
        setArmor(25);
        setDamage(10);
        this.Encounter();
    }
    public int Attack(Knight k){
        int dmg=(this.getDamage() * this.getDamage())/(this.getDamage() + k.getArmor());
        k.setHealth(k.getHealth()-dmg);
        if(k.getHealth() <0){
            k.setHealth(0);
        }
        return dmg;
    }
    public void Encounter() throws InterruptedException {
        Maze.delay(200);
        System.out.println("An enemy!");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void SplAction(Enemies e,Knight knight) throws InterruptedException{

    }
}
