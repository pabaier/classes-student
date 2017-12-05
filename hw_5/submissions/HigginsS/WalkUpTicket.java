
/**
 * Write a description of class WalkUpTicket here.
 *
 * Steven Higgins
 * 
 */
public class WalkUpTicket extends Ticket
{
    private final double WALK_UP_TICKET_PRICE = 50.0;
    public WalkUpTicket(String eventName, CalendarDate date){
        super(eventName, date);
    }
    public double getPrice(){
        return WALK_UP_TICKET_PRICE;
    }
    public String toString(){
        return String.format("Walk-up Ticket: " + super.toString() + " Price: $%.2f", getPrice());
    }
}
