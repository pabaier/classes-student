/*
 * Name: Kyle Winstead
 * Assignment: Homework 5
 * Date: 9 November 2017
 */
public class WalkUpTicket extends Ticket {
	


	private static final double price = 50.0;
	

	
	
	public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent) {
		super(nameOfEvent, dateOfEvent);
}

	public double getPrice() {
		return price;
}
	public String toString() {
		return ("Walk-up Ticket: " + super.toString() + ", " + "$" + (String.format("%.2f", getPrice())));
	}


}
