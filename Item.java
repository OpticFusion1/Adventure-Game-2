

public class Item {

	private String name;

	public Item (String name) {

		this.name = name;
		
	}

	public boolean equals(Object that) {

		if (that instanceof Item) {
			
			return this.name.equals( ((Item) that) .name);

		} else {

			return false;

		}

	}

	public String toString() {

		return this.name;
	
	} //toString
	
}// Item Class