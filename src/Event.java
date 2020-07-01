public class Event extends Post {
	
	private static int currEventPostSrNum = 1;
	private String venue;
	private String eventDate;
	private int capacity;
	private int attendeeCount;

	public Event(String title, String description, String creatorID, String venue, String date, int capacity) {
		
		super(Globals._EVENT_ID_PREFX+currEventPostSrNum, title, description, creatorID);
		this.setVenue(venue);
		this.setEventDate(eventDate);
		this.setCapacity(capacity);
		currEventPostSrNum += 1;
	}
	
	@Override
	public String getPostDetails() {
		StringBuilder detailsStr = new StringBuilder(super.getPostDetails());
		detailsStr.append("Venue:\t\t"+getVenue());
		detailsStr.append("Date:\t\t"+getEventDate());
		detailsStr.append("Capacity:\t\t"+getCapacity());
		detailsStr.append("Attendees:\t\t"+getAttendeeCount());
		
		return detailsStr.toString();
	}

	public boolean handleReply(Reply reply) {
		return true;
	}

	
	public String getReplyDetails() {
		return "";
	}
	
	// Getters - Setters Starts Here
	
	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAttendeeCount() {
		return attendeeCount;
	}

	public void setAttendeeCount(int attendeeCount) {
		this.attendeeCount = attendeeCount;
	}

	// Getters - Setters Ends Here
	
	
}

