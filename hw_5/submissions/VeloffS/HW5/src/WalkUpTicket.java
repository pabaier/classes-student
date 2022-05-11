//@ author: Stefan Veloff
//I discussed this assignment with: Mackenzie S. & Anthony M.(CSCI LAB) as well as Kyle W.
//this is a walk up ticket class that extends to the super class Ticket.java:
//If a ticket is purchased at the booth (walk-up) then the price will be $50.00
//
public class WalkUpTicket extends Ticket {
	


	private static final double price = 50.0;
	
	public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent) {
		super(nameOfEvent, dateOfEvent);
}
	//getter:
	public double getPrice() {
		return price;
}
	//to string method:
	public String toString() {
		//return statement:
		return ("Walk-up Ticket: " + super.toString() + ", " + "$" + (String.format("%.2f", price)));
	}


}
