
public class Sale extends Post {
	
	private static int currSalePostSrNum = 1;
	double askingPrice;
	double highestOffer;
	double minRaise;
	
	public Sale() {
		this.askingPrice = 0;
		this.highestOffer = 0;
		this.minRaise = 0;
	}
	
	// Constructor 2
	public Sale(String title, String description, String creatorID, double askingPrice, double minRaise) {
		
		super(Globals._SALE_ID_PREFX+currSalePostSrNum, title, description, creatorID);
		this.setAskingPrice(askingPrice);
		this.setMinRaise(minRaise);
		this.highestOffer = 0;
		currSalePostSrNum += 1;
	}
	
	
	@Override
	public boolean handleReply(Reply reply) {

		return false;
	}
	
	@Override
	public String getPostDetails() {
		StringBuilder detailsStr = new StringBuilder(super.getPostDetails());
		
		detailsStr.append("Asking Price:\t\t"+getAskingPrice());
		detailsStr.append("Highest Offer:\t\t"+getHighestOffer());
		detailsStr.append("Minimum Raise:\t\t"+getMinRaise());
		
		return detailsStr.toString();
	}
	
	public String getReplyDetails() {
		return "";
	}
	
	
	// Getters - Setters Starts Here 
	public double getAskingPrice() {
		return askingPrice;
	}

	
	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}

	
	public double getHighestOffer() {
		return highestOffer;
	}

	
	public void setHighestOffer(double highestOffer) {
		this.highestOffer = highestOffer;
	}

	
	public double getMinRaise() {
		return minRaise;
	}

	
	public void setMinRaise(double minRaise) {
		this.minRaise = minRaise;
	}
	// Getter - Setters
}
