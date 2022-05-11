
public class WalkUpTicket extends Ticket{
	
	public WalkUpTicket(String nameofEvent, CalendarDate dateofEvent) {
		super(nameofEvent, dateofEvent);
		
	}

	public double getPrice(){
		return 50;
	}
	
	public String toString(){
		
		return super.toString() + ", Price: $" + this.getPrice();
	}
}
