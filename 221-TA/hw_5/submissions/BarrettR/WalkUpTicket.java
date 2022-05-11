//Ryan Barrett
//WalkUpTicket class for HW5
public class WalkUpTicket extends Ticket {
	private double price;

	public WalkUpTicket(String event, CalendarDate date) {
		super(event, date);
		price = 50.00;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return super.toString() + ", Price: $" + this.getPrice();
	}
}