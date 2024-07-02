package petSim;

//Example subclass of Pet
public class Lion extends Pet {

 public Lion(String name, int health, int energy, int xp) {
     super(name, health, energy, xp);
 }

 @Override
 public void play() {
     System.out.println(getName() + " is playing!");
     setEnergy(getEnergy() - 10);
     setXp(getXp() + 5);
 }

 @Override
 public void feed(Food food) {
     System.out.println(getName() + " is eating!");
     setHealth(food.getHealthValue() + 10);
     setEnergy(food.getEnergyValue() + 10);
 }

 @Override
 public void sleep() {
     System.out.println(getName() + " is sleeping!");
     setEnergy(getEnergy() + 20);
 }
}
