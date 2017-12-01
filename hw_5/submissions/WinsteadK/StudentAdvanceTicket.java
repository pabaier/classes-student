/*
 * Name: Kyle Winstead
 * Assignment: Homework 5
 * Date: 9 November 2017
 */
public class StudentAdvanceTicket extends AdvanceTicket {

	
	
	public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
		super(nameOfEvent, dateOfEvent, datePurchased);
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		String a = ("Student Advance Ticket: " + super.toString()  + ", Price: $"+ (String.format("%.2f", getPrice()))+ " (ID Required)" );
		return a;
}


	public double getPrice() {
		double price = super.getPrice();
		price = price/2;
		return price;
}

}
