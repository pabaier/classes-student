
/**
 * A class for tickets bought in advance based on the Ticket class
 *
 * @author Richard Marshall
 */
public class AdvanceTicket extends Ticket
{
    // instance variables - replace the example below with your own
    private CalendarDate dateOfPurchase;

    /**
     * Constructor for objects of class AdvanceTicket
     */
    public AdvanceTicket(String nameofEvent, CalendarDate dateOfEvent, CalendarDate datePurchased)
    {
        super(nameofEvent, dateOfEvent);
        dateOfPurchase = datePurchased;
    }

    /**
     * returns the price based on the date of purchase.
     * @return    The price of the ticket. 30.0 if it was purchased at least 10 days before the event, otherwise it will be 40.0.
     */
    @Override
    public double getPrice()
    {
        CalendarDate dateBought = dateOfPurchase;
        double price = 40.0; // this is the price unless it was bought less than 10 days in advanced,
        //we'll use this as the default and check how long its been 
        //since its bought and change if needed
        
        if (dateOfPurchase.daysUntil(getDateOfEvent()) >= 10) { //checks the number of days until the event from date purchased to see if its 10 or more
            //if this is true then we return 30.0 instead
            price = 30.0;
        }
        
        return price;
    }
    /**
     * New toString method
     * Adds the ticket type at the front and the price at 
     * the back to the super.toString method as well as the
     * date purchased
     */
    @Override
    public String toString() {
        return "Advanced Ticket: " + super.toString() + " Date of Purchase: " + dateOfPurchase.getMonthName() + " " + dateOfPurchase.getDay() + ", " + dateOfPurchase.getYear() + " Price: $" + String.format("%.2f", getPrice());
    }
}
