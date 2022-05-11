
/**
 * A class for walk up tickets, using the Ticket class as a superclass
 * has different toString and getPrice methods
 *
 * @author Richard Marshall
 */
public class WalkUpTicket extends Ticket
{
    

    /**
     * Constructor for objects of class WalkUpTicket
     * 
     * @param name name of the event as a String
     * @param date the date the event takes place on as a Calendar date
     */
    public WalkUpTicket(String name, CalendarDate date)
    {
        super(name, date);
    }

    /**
     *  returns the price of walk up tickets which is always 50.00
     *
     * @return    50.00
     */
    @Override
    public double getPrice()
    {
        return 50.00;
    }
    
    /**
     * new toString Method
     * adds the ticket type in front and the price in the back from 
     * the super method
     */
    @Override
    public String toString() { 
        return "Walk-up Ticket: " + super.toString() + " Price: $" + String.format("%.2f", getPrice());
    }
}
