//@ author: Stefan Veloff
//I discussed this assignment with: Mackenzie S. & Anthony M.(CSCI LAB) as well as Kyle W.
//This is a program that helps create types of tickets for campus events:
//This ticket class serves as the SUPERCLASS for all of these three different types of tickets.
//There are three types of tickets: walk-up tickets, advance tickets, and student advance tickets:

//import statement:
import java.util.*;


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
	//name of event:
	private String nameOfEvent(String eventName) {
		//return statement:
		return nameOfEvent;

}
	//getter:
	public String getNameOfEvent() {
		//returns the name of the event:
		return nameOfEvent; 
}
	//getter:
	public double getPrice() {
		//return statement:
		return 0.0;
}

	public String getNameOfEvent;

	public CalendarDate getDateOfEvent() {
		// returns the date of the event:
		return dateOfEvent;
	
}	
	//can use super on this because already created:
	public String toString() {
		return ("Event: " + getNameOfEvent() +"," + " Date of Event: " + getDateOfEvent());
}
}

