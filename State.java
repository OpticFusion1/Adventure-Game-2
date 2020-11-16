import java.util.*;

public class State {

	private String description;
	private List<Item> inventory;

	public State(String theDescription, Item[] initalThings) {

		description = theDescription;
		inventory = new LinkedList<>();

		for (Item item: initalThings) {
			inventory.add(item);
		}

	}

	public void removeThing(Item thing) throws Exception {

		if (!inventory.contains(thing)) {

			throw new Exception(String.format("There is no %s in your inventory", thing));
			
		} else {
			
			inventory.remove(thing);

		}
	
	}

	public void addThing(Item thing) throws Exception {

		if (inventory.contains(thing)) {
			// we will throw an error
			throw new Exception("You already have this item");
		
		} else {

			inventory.add(thing);
		}

	} //addThing

	public void setDescription(String theDescription) {
		
		description = theDescription;

	} //setDescription

	public String getDescription() {

		if (inventory.size() > 0) {

			return String.format("%s\n There are some things here %s", description, inventory);

		} else {

			return description;
		
		} 

	} //getDescription

	public boolean hasThing(Item thing) {

		return inventory.contains(thing);

	}// hasThing

} //class State
