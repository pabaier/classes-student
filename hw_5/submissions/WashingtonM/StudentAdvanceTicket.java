/*
 * Creates a student ticket that inherits from AdvanceTicket
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

public class StudentAdvanceTicket extends AdvanceTicket{
	
	public StudentAdvanceTicket(String name, CalendarDate eventDate, CalendarDate purchaseDate) {
		super(name, eventDate, purchaseDate); //AdvanceTicket's constructor
	}
	@Override
	//overrides the method in AdvanceTicket
	public double getPrice() {
		return super.getPrice()/2; //returns half the price of the advance ticket
	}
	@Override
	//uses the toString of AdvanceTickets ands adds in things just for students
	public String toString () {
		return "Student " + super.toString() + " (ID Required)"; 
	}
	

}
