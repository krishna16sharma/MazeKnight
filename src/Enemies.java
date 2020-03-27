public class Enemies {
    private String Name="???";
    private int health=50;
    private int armor=25;
    private int damage=10;

    public Enemies() throws InterruptedException {
        this.Encounter();
    }
    public int Attack(Knight k){
        int dmg=(this.damage*this.damage)/(this.damage+k.armor);
        k.health-=dmg;
        if(k.health<0){
            k.health=0;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void SplAction(Enemies e) throws InterruptedException{

    }
}
