
/**
 * Constructor for a walk up ticket, which is a subclass of ticket.
 *
 * @author Matt Hancock
 * @version 1 11/7/2017
 */
public class WalkUpTicket extends Ticket
{
    // instance variables - replace the example below with your own
    private String s;

    /**
     * Constructor for objects of class WalkUpTicket
     */
    public WalkUpTicket(String name, CalendarDate date)
    {
        super(name,date);
    }
    public double getPrice()
    {
        double price = 50.0;
        return price;
    }    
    public String toString(){
        
        return "Walk-Up Ticket: " + super.toString() + ", Price: $" + this.getPrice();
    }
}
