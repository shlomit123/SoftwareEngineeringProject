package petSim;

//Abstract class for Food
public class Food {
 private String name;
 private int healthValue;
 private int energyValue;

 // Constructor
 public Food(String name, int healthValue, int energyValue) {
     this.name = name;
     this.healthValue = healthValue;
     this.energyValue = energyValue;
 }

 // Getters and setters
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public int getHealthValue() {
     return healthValue;
 }

 public void setHealthValue(int healthValue) {
     this.healthValue = healthValue;
 }

 public int getEnergyValue() {
     return energyValue;
 }

 public void setEnergyValue(int energyValue) {
     this.energyValue = energyValue;
 }

 // Abstract method to be implemented by subclasses
 public void consume(Pet pet) {
	 
}
}

