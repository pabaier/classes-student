/*
 * Name: Kyle Winstead
 * Assignment: Homework 5
 * Date: 9 November 2017
 */public class AdvanceTicket extends Ticket {
	
	
	private CalendarDate datePurchased;
	
	public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased){
		super(nameOfEvent,dateOfEvent);
		this.datePurchased = datePurchased;
		
	}
	public CalendarDate getDatePurchased() {
		return datePurchased;
}



	public double getPrice() {
		if(getDatePurchased().daysUntil(getDateOfEvent()) >= 10) {
			double b = 30.00;
			return b;
		}
		if(getDatePurchased().daysUntil(getDateOfEvent()) < 10) {
			double a = 40.00;
			return a;
		}
	return 0.0;
}
	public String toString() {
		 return ("Advance Ticket: " + super.toString() + ", " +"Purchase Date: "+ getDatePurchased() + ", Price: $"+ (String.format("%.2f", getPrice())));
}

}

