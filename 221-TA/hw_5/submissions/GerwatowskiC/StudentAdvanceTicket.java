
/**
 * Write a description of class StudentAdvanceTicket here.
 *
 * Claire Gerwatowski
 * 3 Nov 2017
 */
import java.text.NumberFormat;
public class StudentAdvanceTicket extends AdvanceTicket
{
    private String name;
    private CalendarDate date;
    private CalendarDate purchased;
    private AdvanceTicket advStu;
    
    NumberFormat priceFormat = NumberFormat.getCurrencyInstance();
    
    public StudentAdvanceTicket(String s, CalendarDate d, CalendarDate p)
    {
        super(s,d,p);
        name = s;
        date = d;
        purchased = p;
    }
    
    public double getPrice()
    {
        return (super.getPrice()/2);
    }
    
    public String toString()
    {
        return ("Student Advanced Ticket: " + super.toString() + " (ID Required)");
    }
    
}
