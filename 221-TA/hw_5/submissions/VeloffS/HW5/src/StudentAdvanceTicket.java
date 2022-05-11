//@ author: Stefan Veloff
//I discussed this assignment with: Mackenzie S. & Anthony M. (CSCI LAB) as well as Kyle W.


//Student Advance Tickets:
public class StudentAdvanceTicket extends AdvanceTicket {

	private CalendarDate datePurchased;
	
	public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased) {
		super(nameOfEvent, dateOfEvent, datePurchased);
		this.datePurchased = datePurchased;
	}
	
	public double getPrice() {
		double price = super.getPrice();
		price = price/2;
		return price;
	}	
	
	public String toString() {
		String txt = ("Student" + super.toString() + ""  + " (ID Required)");
		return txt;
}


	

}
