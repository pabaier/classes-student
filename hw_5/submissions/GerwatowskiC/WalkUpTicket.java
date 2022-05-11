
/**
 * Write a description of class WalkUpTicket here.
 *
 * Claire Gerwatowski
 * 3 Nov 2017
 */
import java.text.NumberFormat;
public class WalkUpTicket extends Ticket
{
    private String name;
    private CalendarDate date;
    private double price = 50.00;
    NumberFormat priceFormat = NumberFormat.getCurrencyInstance();

    public WalkUpTicket(String s, CalendarDate d)
    {
        super(s,d);
        name = s;
        date = d;
    }

    public double getPrice()
    {
        return price;
    }
    
    public String toString()
    {
        return ("Walk-up Ticket: " + super.toString() +
        ", Price: " + priceFormat.format(getPrice()));
    }
    
    
}
