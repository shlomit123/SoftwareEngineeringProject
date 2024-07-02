package petSim;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		// Create a lion object
		Lion lionn = new Lion("Lionel", 0, 0, 0);
		
		// Create foodList and create banana food.
		ArrayList<Food> foodList = new ArrayList<Food>(0);
		Food banana = new Food("banana", 5, 5);
		foodList.add(banana);
	
		// Print lion name and feed it
		System.out.println("Weclome your new Lion, " + lionn.getName());
		lionn.feed(foodList.get(0));
		
	}
}
