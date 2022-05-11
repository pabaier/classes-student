//@ author: Stefan Veloff
//I discussed this assignment with: Mackenzie S. & Anthony M.(CSCI LAB) as well as Kyle W.

// Advance ticket purchased 10 >= days before the event 
public class AdvanceTicket extends Ticket {
	
	
	private CalendarDate datePurchased;
	
	public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased){
		super(nameOfEvent,dateOfEvent);
		this.datePurchased = datePurchased;
		
	}
	public CalendarDate getDatePurchased() {
		return datePurchased;
}


	//gettter:
	public double getPrice() {
		//if statement (if days until is greater than 10):
		if(getDatePurchased().daysUntil(getDateOfEvent()) >= 10) {
			//thought that typing .00 would avoid using the %.2f
			double a = 30.00;
			//return statement:
			return a;
		}
		//if statement (if the date purchased is less than 10 days before the day of the event):
		if(getDatePurchased().daysUntil(getDateOfEvent()) < 10) {
			//thought that typing .00 would avoid using the %.2f
			double b = 40.00;
			//return statemnet:
			return b;			
		}
	return 0.0;
}
	public String toString() {
		return ("Advance Ticket: " + super.toString() + ", " +"Purchase Date: "+ getDatePurchased() +", " + "Price: "+"$" + (String.format("%.2f", getPrice())));
}

}

