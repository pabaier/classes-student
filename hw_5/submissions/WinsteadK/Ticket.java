/*
 * Name: Kyle Winstead
 * Assignment: Homework 5
 * Date: 9 November 2017
 */



public class Ticket {

	//instance variables:
	private String nameOfEvent;
	private CalendarDate dateOfEvent;
	
	//constructor:
	public Ticket(String nameOfEvent, CalendarDate dateOfEvent) {
		
		//instance var	  local variables
		this.nameOfEvent = nameOfEvent;
		this.dateOfEvent = dateOfEvent;
	}

	private String nameOfEvent(String eventName) {
		
		return nameOfEvent;

}
	
	public String getNameOfEvent() {
		return nameOfEvent; 
}

	public double getPrice() {
		return 0.0;
}

	public String getNameOfEvent;

	public CalendarDate getDateOfEvent() {
		return dateOfEvent;
	
}	
	//can use super on this because already created:
	public String toString() {
		return ("Event: " + getNameOfEvent() + " Date of event: " + getDateOfEvent());
}
}




