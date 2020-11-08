import java.util.*;

public class FSM {

	private State[] theStates;
	private State currentState;
	private int currentStateIndex;

	private int[][] transitionTable;
	private List<String> transitionVerbs;

	public FSM(State[] states, int[][] transitionTable, String[] eventVerbs) {

		theStates = states;
		this.transitionTable = transitionTable;
		currentState = states[0];

		transitionVerbs = new LinkedList<>();

		for (String event: eventVerbs) {
			transitionVerbs.add(event);
		}


	} // constructor

	public State getState() {

		return currentState;
	
	} //get State

	public void doTransition(String eventVerb) throws Exception{

		int index =  transitionVerbs.indexOf(eventVerb);

		if (index < 0) {

			throw new Exception("Go where?");
		
		} //if

		// if this doesn't make sense to you go back to the first lecture 
		int newState = transitionTable[currentStateIndex][index];

		if (newState >= 0) {

			currentStateIndex = newState;
			currentState = theStates[currentStateIndex];


		} else {

			throw new Exception("THAT'S NOT POSSIBLE");
		
		} // if

	}

	public String getExitDescription() {

		String exitDescription = "You can go ";
		String separator = "";
		for (int col = 0; col < transitionVerbs.size(); col++) {

			if (transitionTable[currentStateIndex][col] >= 0 ) {
				
				exitDescription += separator + transitionVerbs.get(col);
				separator = ", ";

			} //if
		
		} //for

		if (separator == "") return "There is no way out";

		// Returning what is the permitted transitions taht are allowed from the state
		return exitDescription;

	} //getExitDescription;


} //FSM class