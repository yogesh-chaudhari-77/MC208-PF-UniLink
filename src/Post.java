import java.util.ArrayList;

public abstract class Post {
	private String ID;
	private String title;
	private String description;
	private String creatorID;
	private String status;
	private ArrayList<Reply> replies;
	
	public Post() {
		this.creatorID = "";
		this.title = "";
		this.description = "";
		this.creatorID = "";
		this.status = Globals._POST_STATUS_DEFAULT; 
		this.replies = new ArrayList<Reply>();
	}
	
	
	public Post(String ID, String title, String description, String creatorID) {
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.creatorID = creatorID;
		this.status = Globals._POST_STATUS_DEFAULT; 
		this.replies = new ArrayList<Reply>();
	}
	
	// Returns the basic details of the Post
	public String getPostDetails() {
		
		StringBuilder detailsStr = new StringBuilder("");
		detailsStr.append("ID:\t\t"+getID()+"\n");
		detailsStr.append("Title:\t\t"+getTitle()+"\n");
		detailsStr.append("Description:\t"+getDescription()+"\n");
		detailsStr.append("Creator ID:\t"+getCreatorID()+"\n");
		detailsStr.append("Status:\t\t"+getStatus()+"\n");
		
		return detailsStr.toString();
	}

	
	public abstract boolean handleReply(Reply reply);
	

	// Getter - Setters Starts here
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(String creatorID) {
		this.creatorID = creatorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Reply> getReplies() {
		return replies;
	}

	public void setReplies(ArrayList<Reply> replies) {
		this.replies = replies;
	}	
	
	// Getter - Setters Ends here
	
}
