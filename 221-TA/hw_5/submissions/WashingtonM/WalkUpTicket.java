/*
 * Creates a walk-up ticket that inherits from Ticket
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

import java.text.NumberFormat;
public class WalkUpTicket extends Ticket {
	
	
	public WalkUpTicket(String name, CalendarDate date) {
		super(name, date); //Ticket's constructor	
	}
	
	@Override
	//overrides the method in Ticket
	public double getPrice() {
		final double PRICE = 50.00; //the price for tickets bought the day of the event
		return PRICE;
	}
	
	@Override
	//uses the toString in Ticket and adds in it's own features while converting a price to currency
	public String toString(){
		return "Walk-up Ticket: " + super.toString() + ", Price: " + 
				NumberFormat.getCurrencyInstance().format(getPrice());
	}
}
