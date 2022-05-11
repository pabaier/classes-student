
/**
 * Write a description of class AdvanceTicket here.
 *
 * Claire Gerwatowski
 * 3 Nov 2017
 */
import java.text.NumberFormat;
public class AdvanceTicket extends Ticket
{
    private String name;
    private CalendarDate date;
    private CalendarDate purchased;
    final double advPriceEarly = 30.00;
    final double advPrice = 40.00;
    NumberFormat priceFormat = NumberFormat.getCurrencyInstance();
    
    public AdvanceTicket(String s, CalendarDate d, CalendarDate p)
    {
        super(s,d);
        name = s;
        date = d;
        purchased = p;
    }
    
    public double getPrice()
    {
        if (purchased.daysUntil(date)>=10) {
            return advPrice;
        }
        else {
            return advPriceEarly;
        }
    }
    
    public String toString()
    {
        return ("Advanced Ticket: " + super.toString() + ",\nPurchase Date: " + purchased + 
        ", Price: " + priceFormat.format(getPrice()));
    }
    
    
}
