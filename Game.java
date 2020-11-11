import java.util.*;

public class Game {

    public static final String[] DIRECTIONS = new String[] {"north", "east", "south", "west"};
    public static final String[] PLAYER_INIT_INVENTORY = new String[] {"torch", "matches", "knife", "book"};

    private FSM theFSM;
    private Player thePlayer;

    public Game() {

        theFSM = makeTinyCaveSystem();
        thePlayer = new Player(PLAYER_INIT_INVENTORY);

    } // constructor

    private FSM makeTinyCaveSystem() {
        
        int[][] transitionTable = {
            //   N   E   S   W
                {0,  1,  0,  2},        // 0 state (start state)
                {2, -1,  0, -1},        // 1
                {2,  1,  3,  0},        // 2
                {-1,-1, -1, -1}         // 3 final stae no way out

        };

        State[] States = {

            new State("You are in a room with a big zero painted on the floor.", new String[] {"keys", "iPad"}),
            new State("You are in a bright yellow room." , new String[] {}),
            new State("This is a round room" , new String[] {}),
            new State("As you enter the room a rockfail closes the entrance", new String[]{})
        };

        FSM result = new FSM(States, transitionTable, DIRECTIONS);
        return result;

    } // makeTinyCaveSystem 

    private void describeSituation() {

        System.out.printf("%s\n%s\n%s", 
                        theFSM.getState().getDescription(), 
                        theFSM.getExitDescription(), 
                        thePlayer.getThings());

    } // describeSituation

    public void runGameLoop() {

        List <String> verbsRequiringObjects = new LinkedList<>();

        for (String verb: new String[] {"go", "read", "drop", "take", "throw"}) {

            verbsRequiringObjects.add(verb);
        
        }

        Scanner in = new Scanner(System.in);

        describeSituation();

        while (true) {

            System.out.print("\nWhat do you want to do? ");
            String response = in.nextLine().toLowerCase();

            System.out.println();

            
            String[] words = response.split(" ");
            // Split the users's input into a verb and another word
            if (words.length > 2) {

                System.out.print("The most I can cope with is two words at a time");
                continue;
            
            }

            String theVerb = words[0];
            String theObject = "";

            boolean verbNeedsAnObject = verbsRequiringObjects.contains(theVerb);

            if (verbNeedsAnObject && words.length == 1) {

                System.out.printf("%s what or where? \n", theVerb);
                continue;
            
            }

            if (!verbNeedsAnObject && words.length == 2) {

                System.out.println("I don't know how to do that");

            }

            if (verbNeedsAnObject) theObject = words[1];

            try {

                switch(theVerb) {
                    case "die":
                    case "exit":
                    case "quit": return;

                    case "go":
                        theFSM.doTransition(theObject);
                        describeSituation();
                        break;

                    case "help":
                        System.out.println("Valid verbs are go, drop, take, look, help, throw, read, quit, ");
                        System.out.println("and prehaps some others. Some verbs must be followed by another");
                        System.out.println("object word to make sense, e.g. 'go west', or 'read book'");
                        break;

                    case "drop":
                        thePlayer.removeThing(theObject);
                        theFSM.getState().addThing(theObject);
                        System.out.println("OK");
                        break;

                    case "take":
                        theFSM.getState().removeThing(theObject);
                        thePlayer.addThing(theObject);
                        System.out.println("OK");
                        break;

                    case "look":
                        describeSituation();
                        break;

                    case "read":
                        if (theObject.equals("book")) {
                            
                            if (thePlayer.hasThing(theObject) || theFSM.getState().hasThing(theObject)) {
                             
                                System.out.println("The title is 'Think Java'. It looks quite boring!");
                            
                            } else {

                                System.out.printf("There is no %s here to read.\n");

                            }

                        } else {

                            System.out.printf("Nobody can read a %s. \n", theObject);

                        }
                        break;

                    default:
                        System.out.println("Huh?");
                        break;
                } //switch
            } //try 
            catch(Exception e) {

                System.out.print(e.getMessage());
            
            }
        
            in.close();
        }// runGameLoop


    } // runGameLoop

}// class Game