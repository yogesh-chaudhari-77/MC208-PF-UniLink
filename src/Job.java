
public class Job extends Post {
	
	private static int currJobPostSrNum = 1;
	private double proposedPrice;
	private double lowestPrice;

	// Constructor 1
	public Job() {
		this.proposedPrice = 0;
		this.lowestPrice = 0;
	}
	
	public Job(String title, String description, String creatorID, double proposedPrice) {
		
		super(Globals._SALE_ID_PREFX+currJobPostSrNum, title, description, creatorID);
		this.setProposedPrice(proposedPrice);
		this.setLowestPrice(0);
		currJobPostSrNum += 1;
	}
	
	
	@Override
	public boolean handleReply(Reply reply) {
		return false;
	}
	
	@Override
	public String getPostDetails()
	{
		StringBuilder detailsStr = new StringBuilder(super.getPostDetails());
		
		detailsStr.append("Proposed Price:\t"+getProposedPrice());
		detailsStr.append("Lowest Price:\t"+getLowestPrice());
		
		return detailsStr.toString();
	}
	
	
	public String getReplyDetails() {
		return "";
	}
	
	
	// Getter - Setters Starts Here
	
	public double getProposedPrice() {
		return proposedPrice;
	}
	
	
	public void setProposedPrice(double proposedPrice) {
		this.proposedPrice = proposedPrice;
	}
	
	
	public double getLowestPrice() {
		return lowestPrice;
	}
	

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	// Getters - Setters Ends Here
	
}
