
/**
 * WalkupTicket class, extention of Ticket class
 *
 * Ashley Woods
 */
public class WalkUpTicket extends Ticket
{
    public WalkUpTicket(String NameOfEvent, CalendarDate DateOfEvent) {
        super(NameOfEvent, DateOfEvent);
    }
    
    public double getPrice() {
        return 50.00;
    }
    
    public String toString() {
        return "Walk-up Ticket: " + super.toString() + ", Price: $" + this.getPrice();
    }
}
