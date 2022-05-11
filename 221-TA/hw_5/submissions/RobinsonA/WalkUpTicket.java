
/**
 * Ariel Robinson
 *
 * subclass of the ticket super class
 * price is always 50.00
 */
import java.text.NumberFormat;
public class WalkUpTicket extends Ticket
{
    // instance variables 

    private final double PRICE=50.00;

    /**
     * Constructor for objects of class WalkupTicket
     */
    public WalkUpTicket(String eventName, CalendarDate eventDate){
        super(eventName,eventDate);

    }
    //returns the price
    public double getPrice(){
        return PRICE;

    }
    //toString returns the WalkUp Ticket display using Ticket superlcass

    public String toString(){
        return "Walk-up Ticket: "+super.toString() + ",Price: " +NumberFormat.getCurrencyInstance().format(getPrice());

    }
}
