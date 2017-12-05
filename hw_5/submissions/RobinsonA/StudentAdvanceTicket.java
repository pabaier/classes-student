
/**
 * Ariel Robinson
 *inherits from the AdvanceTicket class
 *The price determined in the AdvancedTicket class the student price is half of it
 */
public class StudentAdvanceTicket extends AdvanceTicket
{

    /**
     * Constructor for objects of class StudentAdvanceTicket
     */
    public StudentAdvanceTicket(String eventName, CalendarDate eventDate, CalendarDate purchaseDate)
    {
        super(eventName, eventDate, purchaseDate);

    }
    //returns price
    public double getPrice(){
        return super.getPrice()/2;

    }
    //toString uses the superclass to string method and adds the ID requirement
    public String toString(){
        return "Student " + super.toString() + "(ID required)" ;
    }

}
