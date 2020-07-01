import java.util.ArrayList;

public class UniLinkMain {
	
	private static boolean quit = false;
	private String loggedInUser = "";
	private ScannerUtil scannerUtil = ScannerUtil.createInstance().consoleReader();
	
	private ArrayList<Post> allPosts = null;
	
	public UniLinkMain() {
		this.allPosts = new ArrayList<Post>();
	}
	
	public static void main(String[] args) {
		
		UniLinkMain driver = new UniLinkMain();

		driver.run();

		// Closing open resources
		driver.scannerUtil.closeReader();

		System.exit(0);
	}

	// Show menu -> Get user Choice -> Perform Operation -> repeate
	public void run() {

		do {
			int userChoice;
			
			if(loggedInUser == null || loggedInUser == "" || loggedInUser.isBlank() || loggedInUser.isEmpty()) {
				this.showLoginSubmenu();
				userChoice = this.getChoice();
				this.executePrimaryOperation(userChoice);	
			}
			
			this.showMenu();
			userChoice = this.getChoice();
			this.executeOperation(userChoice);

		}while(quit != true);

	}

	public void showLoginSubmenu() {
		System.out.println("\t\t\t Menu \t\t\t");
		System.out.println(Globals.LINE_SEPERATOR);
		System.out.println("1.  Login In \n"
						 + "2.  Quit 	 \n"
				);
	}
	
	public void executePrimaryOperation(int userChoice) {
		
		switch(userChoice) {
		case Globals._LOG_IN :		// 1 
			break;
			
		case Globals._QUIT :		// 2
			break;
		}
	}

	// Prints Menu
	public void showMenu() {
		System.out.println("\t\t\t Menu \t\t\t");
		System.out.println(Globals.LINE_SEPERATOR);
		System.out.println("1.  New Event Post 				\n"
							+ "2.  New Job Post				\n"
							+ "3.  New Sale Post			\n"
							+ "4.  Reply to Post			\n"
							+ "5.  Display my posts			\n"
							+ "6.  Display all posts		\n"
							+ "7.  Close Post				\n"
							+ "8.  Delete Post				\n"
							+ "9.  Logout					\n"
				);
	}


	// Get user choice in terms of operation. It will 
	public int getChoice() {

		System.out.print("Please Enter Your Choice : ");
		return scannerUtil.readInt("Please Enter Choice Again :");

	}
	
public void executeOperation(int userChoice) {
		
		switch(userChoice) {
		
		case Globals._NEW_EVENT_POST :
			Event retEvent = this.createNewEventPost();
			if(retEvent != null) {
				System.out.println("Success! Your event has been created with id "+retEvent.getID());
			}
		break; 
		
		case Globals._NEW_JOB_POST :
			if(this.createNewJobPost() != null) {
				System.out.println();
			}
		break;
		
		case Globals._NEW_SALE_POST:
			if(this.createNewSalePost() != null) {
				System.out.println("");
			}
		break;
		
		case Globals._REPLY_TO_POST:
		break;
			
		case Globals._DISPLAY_MY_POSTS:
		break;
		
		case Globals._DISPLAY_ALL_POSTS:
		break;
		
		case Globals._CLOSE_POST:
		break;
		
		case Globals._DELETE_POST:
		break;
		
		case Globals._LOGOUT:
		break;
		
		default :
			System.err.println("Please select from above options");
		}
	}

	
	public Event createNewEventPost() {
		
		System.out.println("Enter details of the event below:");
		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		String venue = scannerUtil.readString("Venue:");
		String dateStr = scannerUtil.readString("Date [dd-mm-yyyy]:");
		int capacity = scannerUtil.readInt("Capacity:");
		
		this.allPosts.add(new Event(title, description, this.loggedInUser, venue, dateStr, capacity));
	}
	
	
	public Job createNewJobPost() {
		
		System.out.println("Enter details of the job below:");
		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		double proposedPrice = scannerUtil.readDouble("Proposed Price:");

		this.allPosts.add(new Job(title, description, this.loggedInUser, proposedPrice));
	}
	
	
	public Sale createNewSalePost() {
		
		System.out.println("Enter details of the item to sale below: ");

		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		double askingPrice = scannerUtil.readDouble("Asking Price:");
		double minRaise = scannerUtil.readDouble("Minimum Raise:");
		
		this.allPosts.add(new Sale(title, description, this.loggedInUser, askingPrice, minRaise));
	}
}
