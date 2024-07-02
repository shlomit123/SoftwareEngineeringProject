package petSim;

//Abstract class for Pet
public abstract class Pet {
 private String name;
 private int health;
 private int energy;
 private int xp;
 private int level;

 // Constructor
 public Pet(String name, int health, int energy, int xp, int level) {
     this.name = name;
     this.health = health;
     this.energy = energy;
     this.xp = xp;
     this.level = level;
 }

 // Getters and setters
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getHealth() {
     return health;
 }

 public void setHealth(int health) {
     this.health = health;
 }

 public int getEnergy() {
     return energy;
 }

 public void setEnergy(int energy) {
     this.energy = energy;
 }

 public int getXp() {
     return xp;
 }

 public void setXp(int xp) {
     this.xp = xp;
 }
 
 public int getLevel() {
     return level;
 }

 public void setLevel(int level) {
     this.level = level;
 }
 
 public void levelUp() { this.level += 1; }

 // Abstract methods to be implemented by subclasses
 public abstract void play();

 public abstract void feed(Food food);

 public abstract void sleep();

 // Method to display pet's status
 public void displayStatus() {
     System.out.println("Name: " + name);
     System.out.println("Health: " + health);
     System.out.println("Energy: " + energy);
     System.out.println("XP: " + xp);
     System.out.println("Level: " + level);
 }
}

