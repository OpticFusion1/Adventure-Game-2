import java.util.*;

public class Player {

	private List <Item> inventory;

	public Player (Item[] initialThings) {

		inventory = new LinkedList<>();
		for (Item item: initialThings) {

			inventory.add(item);
		
		}

	} //constructor

	public String getThings() {

		return String.format("You are carrying:\n%s", inventory);
	
	}

	public void removeThing(Item thing) throws Exception{

		if (!inventory.contains(thing)) {

			throw new Error("There isn't one here");

		} else {

			inventory.remove(thing);
		
		}

	} // removeThing

	public void addThing(Item thing) throws Exception {

		if (inventory.contains(thing)) {

			throw new Error("There is already one in your inventory");
		
		} else {

			inventory.add(thing);
	
		}

	} // addThings

	public boolean hasThing(Item item) {

		return inventory.contains(item);

	}

} // Player class