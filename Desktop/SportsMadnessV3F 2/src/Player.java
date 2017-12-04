public class Player {
	// instance variables
	private Viewer userInteract;
	private final int INSERT = 1;
	private final int PRINT_ALL = 5;
	private final int PRINT_INDIV = 3;
    private final int PRINT_SPORT = 4;
	private final int QUIT = -1;
	private final int REMOVE = 2;
	private ListADT myList;
	private String userChoice;

	/**
	 * Constructor for objects of class StatsApp
	 */
	public Player() {
		// initialize instance variables
		userInteract = new Viewer();
		userChoice = userInteract.getStringChoice("Would you like to use an array or link?");
		if (userChoice.equalsIgnoreCase("array")) {

			myList = new AList(); // see constructor for parameters

		} else if (userChoice.equalsIgnoreCase("links")) {

			myList = new LList(); // see constructor for parameters

		}
	}

	public void start(){
        userInteract.printPrompt("Welcome to AnchorFlame Tech's Athlete database!");
        int choice = userInteract.getNumberChoice(this.topMenu());
        while (choice != QUIT) {
            if (choice == INSERT){
                String last = userInteract.getStringChoice("Last name: ");
                String first = userInteract.getStringChoice("First name: ");
                String playerType = userInteract.getStringChoice(
                        "Soccer, football, or basketball? ");
                int statistic;
                if (playerType.equalsIgnoreCase("soccer")){
                    statistic = userInteract.getNumberChoice("Number of goals: ");
                    myList.insert(new SoccerPlayer(last, first, statistic));
                } else if (playerType.equalsIgnoreCase("basketball")){
                    statistic = userInteract.getNumberChoice("Number of points: ");
                    myList.insert(new BasketballPlayer(last, first, statistic));
                } else if (playerType.equalsIgnoreCase("football")){
                    statistic = userInteract.getNumberChoice("Number of touchdowns: ");
                    myList.insert(new FootballPlayer(last, first, statistic));
                } else {
                	userInteract.printPrompt("Sorry, we don't include " + 
                        playerType + ". Try again.");
                }
            } else if (choice == REMOVE){
            	int count = 0;
            	String lastUser = userInteract.getStringChoice("Player's last name: ");
                String firstUser = userInteract.getStringChoice("Player's first name: ");
                for (int i = 0; i <myList.size(); i++){
                	 
                	String last = myList.getValue(i).getLastName();
                	String first = myList.getValue(i).getFirstName();
                	if (last.equalsIgnoreCase(lastUser) && first.equalsIgnoreCase(firstUser)){
                		  myList.remove(myList.getValue(i));
                		  userInteract.printPrompt(first + " " + last + " successfully deleted.\n");
                		  count ++;
                	}
                	

                }
               if (count == 0)
            	   userInteract.printPrompt(firstUser + " " + lastUser+ " not found. Try again.\n");
                
            } else if (choice == PRINT_INDIV){
            	int count = 0;
            	String lastUser = userInteract.getStringChoice("Player's last name: ");
                String firstUser = userInteract.getStringChoice("Player's first name: ");
                for (int i = 0; i <myList.size(); i++){
                	 
                	String last = myList.getValue(i).getLastName();
                	String first = myList.getValue(i).getFirstName();
                	if (last.equalsIgnoreCase(lastUser) && first.equalsIgnoreCase(firstUser)){
                		  userInteract.printPrompt(myList.getValue(i).toString());
                		  count ++;
                		  }
                	
                		
                }
               if (count == 0)
            	   userInteract.printPrompt(firstUser + " " + lastUser+ " not found. Try again.\n");
               
            } else if (choice == PRINT_SPORT){
                int count = 0;
            	String typeUser = userInteract.getStringChoice("Which type of players: ");
                for (int i = 0; i <myList.size(); i++){
                	String type = myList.getValue(i).getType();
                	if (type.equalsIgnoreCase(typeUser)){
                		  userInteract.printPrompt(myList.getValue(i).toString());
                		  count++;
                		  
                       	
                }
                	
                }
                	if (count == 0)
                		 userInteract.printPrompt(typeUser + " type not found. Try again.\n");
                		
            
            	
            } else if (choice == PRINT_ALL){
            	for (int i = 0; i <myList.size(); i++){
                   	userInteract.printPrompt(i + " :" + myList.getValue(i).toString());
                   }
             }
            choice = userInteract.getNumberChoice(this.topMenu());
        }
        userInteract.printPrompt("Goodbye and thanks for playing!");
    }

	public String topMenu() {
		String result = "Enter the number of your choice. You can:\n";
		result += "1) add a player\n";
		result += "2) remove a player\n";
		result += "3) print stats for one player\n";
		result += "4) print stats for all players " + "in a given sport\n";
		result += "5) print stats for all players\n";
		result += "Enter -1 to quit.";
		return result;
	}

	public void printIndividualStats(Athlete athlete) {
		userInteract.printPrompt(athlete.toString());
	}

}
