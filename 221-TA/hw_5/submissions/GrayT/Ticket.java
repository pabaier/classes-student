/*
 * Tyler Gray
 * Super Ticket Class
 * Holds event name and date obj
 * 
 * 
 * 
 * 
 */
public class Ticket {

	protected String nameOfEvent;
	protected CalendarDate dateOfEvent;
	
	
	public Ticket(String name, CalendarDate date) {
		nameOfEvent = name;
		dateOfEvent = date;		
	}
	
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	
	public double getPrice() {
		return 0.0;
	}
	
	public CalendarDate getDateOfEvent() {
		return dateOfEvent;
	}
	
	public String toString() {
		return "Event: " + nameOfEvent + ", Date of Event: " +  dateOfEvent.toString() ;
		
	}
	
	
	
	
	
	
}
