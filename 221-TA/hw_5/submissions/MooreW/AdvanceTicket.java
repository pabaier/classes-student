
public class AdvanceTicket extends Ticket{
	
	private CalendarDate datePurchased;


	public AdvanceTicket(String nameofEvent, CalendarDate dateofEvent, CalendarDate datePurchased) {
		super(nameofEvent, dateofEvent);
		
	}
	
	public double getPrice(){
		if (this.getDateOfEvent().getDay() - datePurchased.getDay() >= 10){
			return 30;
		}
		else{
			return 40;
		}
	}
	
	public String toString(){
		return super.toString() + ", Puchase Date: " + datePurchased + ", Price: $" + this.getPrice();
	}
	
	

}
