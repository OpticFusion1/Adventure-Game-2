import java.util.*;

public class State {

	private String description;
	private List<String> inventory;

	public State(String theDescription, String[] initalThings) {

		description = theDescription;
		inventory = new LinkedList<>();

		for (String item: initalThings) {
			inventory.add(item);
		}

	}

	public void removeThing(String thing) throws Exception {

		if (!inventory.contains(thing)) {

			throw new Exception(String.format("There is no %s in your inventory", thing));
			
		} else {
			
			inventory.remove(thing);
		}
	
	}

	public void addThing(String thing) throws Exception {

		if (inventory.contains(thing)) {

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

	public boolean hasThing(String thing) {

		return inventory.contains(thing);

	} // hasThing

} //class State
