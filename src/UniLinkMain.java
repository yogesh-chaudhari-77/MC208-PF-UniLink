import java.util.ArrayList;
import java.util.Iterator;

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
		driver.loadTestData();
		
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
			this.loggedInUser = this.scannerUtil.readString("Please enter username : ");
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
		
		return scannerUtil.readInt("Please Enter Your Choice :");

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
			Job retJob = this.createNewJobPost();
			if(retJob != null) {
				System.out.println("Success! Your job has been created with id "+retJob.getID());
			}
		break;
		
		case Globals._NEW_SALE_POST:
			Sale retSale = this.createNewSalePost();
			if(retSale != null) {
				System.out.println("Success! Your sale has been created with id "+retSale.getID());
			}
		break;
		
		case Globals._REPLY_TO_POST:
			if(this.handleReply()) {
				System.out.println("Your reply has been saved successfully");
			}
		break;
			
		// Displays only the posts that have been created by the logged in user
		case Globals._DISPLAY_MY_POSTS:
			this.displayUsersPost();
		break;
		
		// Displays all the posts in the system. 
		case Globals._DISPLAY_ALL_POSTS:
			this.displayAllPosts();
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

	// Creates a New Event Post and adds into the Post arraylist
	public Event createNewEventPost() {
		
		System.out.println("Enter details of the event below:");
		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		String venue = scannerUtil.readString("Venue:");
		String dateStr = scannerUtil.readString("Date [dd-mm-yyyy]:");
		int capacity = scannerUtil.readInt("Capacity:");
		
		Event newEvent = new Event(title, description, this.loggedInUser, venue, dateStr, capacity);
		this.allPosts.add(newEvent);
		return newEvent;
	}
	
	
	// Creates a New Job Post and adds into the Post arraylist
	public Job createNewJobPost() {
		
		System.out.println("Enter details of the job below:");
		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		double proposedPrice = scannerUtil.readDouble("Proposed Price:");

		Job newJob = new Job(title, description, this.loggedInUser, proposedPrice);
		this.allPosts.add(newJob);
		return newJob;
	}
	
	
	// Creates a New Sale Post and adds into the Post arraylist
	public Sale createNewSalePost() {
		
		System.out.println("Enter details of the item to sale below: ");

		String title = scannerUtil.readString("Title: ");
		String description = scannerUtil.readString("Description:");
		double askingPrice = scannerUtil.readDouble("Asking Price:");
		double minRaise = scannerUtil.readDouble("Minimum Raise:");
		
		Sale newSale = new Sale(title, description, this.loggedInUser, askingPrice, minRaise);
		this.allPosts.add(newSale);
		return newSale;
	}

	
	public void displayUsersPost() {
		for(Post p : this.allPosts) {
			if(p.getCreatorID().contentEquals(loggedInUser)) {
				System.out.println(p.getPostDetails());
				System.out.println(Globals.LINE_SEPERATOR);
			}
		}
	}
	
	
	public void displayAllPosts() {
		for(Post p : this.allPosts) {
			System.out.println(p.getPostDetails());
		}
	}
	
	
	// Handles the generic reply request
	public boolean handleReply() {
		
		this.displayAllPosts();
		String postID = scannerUtil.readString("Please enter post ID :");
		
		Post postRef = null;
		for (int i = 0, postListLen = this.allPosts.size(); i < postListLen; i++) {
			if(this.allPosts.get(i).getID().contentEquals(postID)) {
				postRef = this.allPosts.get(i);
				break;
			}
		}
		
		if(postRef instanceof Event) {
			this.handleEventReply();
		}else if (postRef instanceof Job){
			this.handleJobReply();
		}else if(postRef instanceof Sale) {
			this.handleSaleReply();
		}
		
		return true;
	}

	
	// If the selected object turns out to be Event object then this will be called
	public void handleEventReply() {
		
	}
	
	
	// If the selected object turns out to be Job object then this will be called
	public void handleJobReply() {
			
	}
	
	
	// If the selected object turns out to be Sale object then this will be called
	public void handleSaleReply() {
		
	}

	
	public void loadTestData() {
		
		this.allPosts.add(new Event("Welcome Day", "Formal Event", "S1", "RMIT Building 80", "20-09-2020", 100));
		this.allPosts.add(new Event("Orientation Day", "Formal Event", "S2", "RMIT Building 80", "21-09-2020", 50));
		this.allPosts.add(new Event("Welcome Bash", "Party", "S3", "RMIT Building 80", "22-09-2020", 60));
		
		this.allPosts.add(new Job("Software Developer", "Data Mine Field", "S1", 10000));
		this.allPosts.add(new Job("Data Scientist", "rockspace hires", "S2", 23000));
		this.allPosts.add(new Job("App Developer", "vTrendit.com", "S3", 30000));
		
		this.allPosts.add(new Sale("Iphone4", "Iphone Sale", "S1", 500, 10));
		this.allPosts.add(new Sale("MacbookPro", "Macbook Sale", "S2", 450, 20));
		this.allPosts.add(new Sale("WB", "WhiteBoard", "S3", 300, 15));
		
		System.out.println(this.allPosts.size());
	}
}
