package petSim;

public class Game {
	 private String name;
	 private int energyConsumeValue;
	public Game(String name, int energyConsumeValue) {
	     this.name = name;
	     this.energyConsumeValue = energyConsumeValue;
	 }

	 // Getters and setters
	 public String getName() {
	     return name;
	 }

	 public void setName(String name) {
	     this.name = name;
	 }

	 public int getEnergyConsumeValue() {
	     return energyConsumeValue;
	 }

	 public void setEnergyValue(int energyConsumeValue) {
	     this.energyConsumeValue = energyConsumeValue;
	 }
}
