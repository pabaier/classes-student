
/**
 * Write a description of class AdvanceTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdvanceTicket extends Ticket
{
    private CalendarDate datePurchased;
    public AdvanceTicket(String event, CalendarDate date, CalendarDate datePurch)
    {
        super(event, date);
        datePurchased = datePurch;
    }
    
    public double getPrice() {
        double rtnVal = 0.0;
        if (datePurchased.daysUntil(super.getDateOfEvent()) >= 10) {
            rtnVal = 30.00;
        } else if (datePurchased.daysUntil(super.getDateOfEvent()) < 10 && datePurchased.daysUntil(super.getDateOfEvent()) > 0) {
            rtnVal = 40.00;
        }
        return rtnVal;
    }
    /*
    The toString method should return a String that looks like the following. It should use Ticket’s toString and add what it needs to add.
"Advance Ticket: Event: Elvis Presley Not-live, Date of Event December 19, 2017, Purchase Date: November 3, 2017, Price: $30.00"

     */
    public String toString(){
        return "Advance Ticket: " + "Event Name: " + super.getNameOfEvent() + ", Date of Event: " + super.getDateOfEvent() + ", Price: " + getPrice();
    }
        
    
    


   
}
