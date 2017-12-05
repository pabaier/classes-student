/*Tyler Gray
 * WalkUpTicket Class extends Ticket
 * Adds a WalkUp ticket price to the ticket
 * 
 * 
 * 
 */
public class WalkUpTicket extends Ticket {
	
	private final double WALKUPPRICE = 30.0;

	public WalkUpTicket(String name, CalendarDate date) {
		super(name, date);
		
	}
	@Override
	public double getPrice() {
		return WALKUPPRICE;
	}
	@Override
	public String toString() {
		return super.toString() + ", Price: $" + String.format("%.2f", getPrice());
		
	}
	

}
