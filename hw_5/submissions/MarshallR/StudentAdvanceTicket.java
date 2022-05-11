
/**
 * A class for advance tickets with student pricing
 *
 * @author Richard Marshall
 */
public class StudentAdvanceTicket extends AdvanceTicket
{

    /**
     * Constructor for objects of class StudentAdvanceTicket
     */
    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate dateOfPurchase)
    {
        super(nameOfEvent, dateOfEvent, dateOfPurchase);
    }

    /**
     * returns the price of the ticket which is half of the normal price
     * @return    the price of the ticket 15.0 for 10 days or less before the event, 20.0 for more
     */
    @Override
    public double getPrice()
    {
        return super.getPrice() / 2.0;
    }
    
    /**
     * new toString Method
     * Changes the name of the ticket type at the front and adds a reminder of 
     * the student ID requirment to the back
     */
    @Override
    public String toString() { // Changes the name of the ticket type at the front and adds a reminder of the student ID requirment to the back
        return "Student " + super.toString() + " (ID Required)";
    }
}
