/*
 * Tyler Gray
 * Advanced Ticket Class
 * Extends Ticket Class
 * adds price to the ticket\
 * determines how many days between the ticket sale and event day to calcualte dicounted price
 * 
 */
public class AdvanceTicket extends Ticket {
	
	private CalendarDate datePurchased; 
	private final double TENDAYOUTPRICE = 30.00;
	private final double TENDAYLESSPRICE = 40.00;


	public AdvanceTicket(String name, CalendarDate date, CalendarDate purchDate) {
		super(name, date);
		datePurchased = purchDate;
	}
	@Override
	public double getPrice() {
		
		if(dateOfEvent.getDaysBetween( datePurchased) > 10) {
			return TENDAYOUTPRICE;
		}
		return TENDAYLESSPRICE;
			
	}
	@Override
	public String toString() {
		
		return "Advance Ticket: " +  super.toString() + ", Purchase Date: " + datePurchased.toString() + ", Price: $" + String.format("%.2f", getPrice());    
	}
	
	//Really should be inside the CalendarDate Class but not sure how this is being graded
	/* private int getDaysBetweenDates(CalendarDate dayOfEvent, CalendarDate purchaseDate) {
	 
		
		int ct = 0;
		CalendarDate tempDate = purchaseDate;
		while(!tempDate.equals(dayOfEvent)) {
			ct ++;
			tempDate.nextDay();
		}
		return ct;
	}
	*/
	
	
	

}
