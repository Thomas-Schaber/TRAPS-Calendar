
public class Event {
	private String eventName;
	private String eventVenue;
	private int venueCapacity;
	private int ticketsSold;
	private int ticketPrice;
	private int overhead;
	private String eventDate; //2020-05-01 format
	
	public Event() {
		
	}
	
	public Event(String eventName, String eventVenue) {
		this.eventName = eventName;
		this.eventVenue = eventVenue;
	}
	
	public Event(String eventName, String eventVenue, int venueCapacity, String eventDate, int ticketsSold, int ticketPrice, int overhead) {
		this.eventName = eventName;
		this.eventVenue = eventVenue;
		this.venueCapacity =  venueCapacity;
		this.eventDate = eventDate;
		this.ticketsSold = ticketsSold;
		this.ticketPrice = ticketPrice;
		this.overhead = overhead;
	}
	
	public boolean sellTickets(int numberOftickets) {
		if(numberOftickets > 0 && ticketsSold + numberOftickets <= venueCapacity) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getProfit() {
		return (ticketsSold * ticketPrice) - overhead;
	}
	
	public int getBreakEvenPoint() {
		return overhead / ticketPrice;
	}
	
	public int compareName​(Event other) {
		
		return this.eventName.compareTo(other.eventName);
		}
	
	public int compareDate​(Event other) {
		return this.eventDate.compareTo(other.eventDate);
		}
	
	public int compareProfit​(Event other) {
		return this.getProfit() - other.getProfit();
		}
	
	public String getEventName(){
		return eventName;
		}
	
	public void setEventName​(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventVenue(){
		return eventVenue;
	}
	
	public void setEventVenue​(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	
	public int getTicketsSold() {
		return ticketsSold;
	}
	
	public void setTicketsSold​(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}
	
	public int getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice​(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public int getOverhead() {
		return overhead;
	}
	
	public void setOverhead​(int overhead) {
		this.overhead = overhead;
	}
	
	public String getDate(){
		return eventDate;
	}
	
	public void setDate​(String date) {
		this.eventDate = date;
	}
	
	public String toString() {
		String s1 = "Event Name = " + eventName + ", Venue = " + eventVenue  + ", Venue Capacity = " + venueCapacity  + ", Tickets Sold = " + ticketsSold + ", Ticket Price = $" + ticketPrice + ", Overhead = $" + overhead + ", Event Date = " + eventDate + "\n";
		return s1;
	}
	
	public int getVenueCapacity() {
		return venueCapacity;
	}
	
	public void setVenueCapacity​(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}
	
	
	
}
