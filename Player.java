import java.util.*;

public class Player {

	private List <String> inventory;

	public Player (String[] initialThings) {

		inventory = new LinkedList<>();
		for (String item: initialThings) {

			inventory.add(item);
		
		}

	} //constructor

	public String getThings() {

		return String.format("You are carrying:\n%s", inventory);
	
	}

	public void removeThing(String thing) throws Exception{

		if (!inventory.contains(thing)) {

			throw new Error("There isn't one here");

		} else {

			inventory.remove(thing);
		
		}

	}

	public void addThing(String thing) throws Exception {

		if (inventory.contains(thing)) {

			throw new Error("There is already one in your inventory");
		
		} else {

			inventory.add(thing);
	
		}

	}

	public boolean hasThing(String item) {

		return inventory.contains(item);

	}

} // Player class