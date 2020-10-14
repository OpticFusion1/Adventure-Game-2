import java.util.*;

public class State {
	private String description;
	private List<String> inventory;

	public State description(String theDescription, String[] initalThings) {
		description = theDescription;

		for (String item: initalThings) {
			inventory.add(item);
		}

	}

	public void removeThing(String thing) {

		if (!inventory.contains(thing)) {

			throw new Exception(String.format("There is no %s in your inventory", thing));
		}
	}

	public void addThing(String thing) {

		if (inventory.contains(thing)) {
			// we will throw an error
			throw new Exception("You already have this item");
		
		} else {

			inventory.add(thing);
		}

	}

	public void setDescription(String theDescription) {
		
		description = theDescription;

	}	

	public String getDescription() {

		if (inventory.length > 0) {

			return String.format("%s\n There are some things here %s", description, inventory);

		} 

	}

	public boolean hasThing(String thing) {

		return inventory.contains(thing);

	}

}