/*
 * Creates an advance tickets that inherits from Ticket
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

import java.text.NumberFormat;

public class AdvanceTicket extends Ticket {
	private CalendarDate purchaseDate;
	
	public AdvanceTicket(String name, CalendarDate eventDate, CalendarDate purchaseDate) {
		super(name, eventDate); //Ticket's constructor
		this.purchaseDate = purchaseDate;
	}
	@Override
	//overrides the method in Ticket
	public double getPrice() {
		double price = 0.0;
		//price for tickets purchased 10 or more days in advance
		final double TEN_DAYS_PRICE = 30.0;
		//price for tickets purchased less than 10 days in advance
		final double LESS_THAN_TEN_PRICE = 40.0;
		if (purchaseDate.daysUntil(getDateOfEvent()) >= 10) {
			price = TEN_DAYS_PRICE;
		}
		else {
		price = LESS_THAN_TEN_PRICE;
		}
		return price;
	}
	@Override
	//uses Ticket's toString and adds in the purchase date and converts the double price to currency
	public String toString () {
		return "Advance Ticket: " + super.toString() + ", Purchase Date: " + purchaseDate.toString() + ", " + "Price: " + 
				NumberFormat.getCurrencyInstance().format(getPrice()); 
	}

}
