
/**
 * AdvanceTicket, extention of Ticket Class
 *
 * Ashley Woods
 */
public class AdvanceTicket extends Ticket
{
    private CalendarDate datePurchased;
    public AdvanceTicket(String NameOfEvent, CalendarDate DateOfEvent, CalendarDate DatePurchased)
    {
        super(NameOfEvent, DateOfEvent);
        datePurchased = DatePurchased;
    }
    
    public double getPrice() {
        int daysUntil = 0;
        double price = 0.0;
        if (this.datePurchased.daysUntil(this.getDateOfEvent()) >= 10) {
            price = 30.0;
        }
        else {
            price = 40.0;
        }
        return price;
    }
    
    public String toString() {
        return "Advance Ticket: Event: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent() + ", Purchase Date: " + datePurchased +", Price: $" + getPrice();
    }
}
