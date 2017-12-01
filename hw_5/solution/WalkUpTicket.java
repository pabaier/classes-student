import java.text.NumberFormat;

/**
 * Extends Ticket and sets a price for tickets.
 *
 * @author Jacob Mattox
 * @version 11/7/17
 */
public class WalkUpTicket extends Ticket
{
    //class that extends Ticket by adding a useable getPrice method
    public WalkUpTicket(String name, CalendarDate c){
        super(name, c);
    }
    
    public double getPrice(){
        double price = 50;
        return price;
    }
    //uses the Ticket class and adds additional output
    public String toString(){
        return "Walk-up Ticket: " + super.toString() + ", Price: " 
            + NumberFormat.getCurrencyInstance().format(getPrice());
    }
    
    
}
