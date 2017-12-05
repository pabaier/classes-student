/* Sydney Jackson
 * AdvanceTicket class is derived from Ticket class,
 * includes Ticket methods and variables, and private variables
 * and methods including CalendarDate variable dayPurchased
 */
public class AdvanceTicket extends Ticket
{
    private CalendarDate datePurchased;
    private static final double EARLIEST = 30.0;
    private static final double LATEST = 40.0;
    
    public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate dayPurchased){
        super(nameOfEvent, dateOfEvent);
        datePurchased = dayPurchased;
        
    }
    
    public String toString()
    {
        return "Advance Ticket: " + super.toString() + "Purchase Date: " + this.datePurchased + ", Price: $" + this.getPrice() + "0";
    }
    @Override
    public double getPrice()
    {   double advancePrice = 0;
        if(datePurchased.daysUntil(super.getDateOfEvent()) >= 10){
            advancePrice = EARLIEST;
        }
        else if(datePurchased.daysUntil(super.getDateOfEvent()) < 10){
            advancePrice = LATEST;
        }
        return advancePrice;
    }
}