package petSim;

//Example subclass of Pet
public class Lion extends Pet {

 public Lion(String name, int health, int energy, int xp, int level) {
     super(name, health, energy, xp, level);
 }

 @Override
 public void play() {
     System.out.println(getName() + " is playing!");
     setEnergy(getEnergy() - 10);
     setXp(getXp() + 5);
 }

 @Override
 public void feed(Food food) {
     System.out.println(getName() + " is eating " + food.getName() + " !");
     setHealth(getHealth() + food.getHealthValue());
     setEnergy(getEnergy() + food.getEnergyValue());
 }
 
 public void play(Game game) {
     System.out.println(getName() + " is playing " + game.getName() + " !");
     setEnergy(getEnergy() - game.getEnergyConsumeValue());
 }

 @Override
 public void sleep() {
     System.out.println(getName() + " is sleeping!");
     setEnergy(getEnergy() + 20);
 }
}
