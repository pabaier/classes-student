/*
 * Creates the super class Ticket
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

public class Ticket {
	private String nameOfEvent = "";
	private CalendarDate dateOfEvent;
	
	//constructor for Ticket
	public Ticket(String name, CalendarDate date) {
		nameOfEvent = name;
		dateOfEvent = date;
	}
	
	//returns the name of the event
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	//returns the price
	public double getPrice() {
		double price = 0.0;
		return price;
	}
	//returns the date of the given event
	public CalendarDate getDateOfEvent() {
		
		return dateOfEvent;
	}
	
	@Override
	//overrides the default toString in java and also uses the toString in CalendarDate
	public String toString() {
		return "Event: " + getNameOfEvent() + ", Date of Event: " + dateOfEvent.toString();
	}
	
	
}
