import java.util.* ;

public class Main {

	public static void main(String[] args) {			

		Player me = new Player(new String[] {"Bicycle", "Orange", "Jupiter"});

		System.out.println(me.getThings());

		try {

			me.addThing("Orange");

		} catch(Exception e) {

			System.out.println(e.getMessage());

		}
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("This is working");
	}

}