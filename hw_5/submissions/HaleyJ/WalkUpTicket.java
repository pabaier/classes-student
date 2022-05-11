
/**
 * Write a description of class WalkUpTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WalkUpTicket extends Ticket

{
   
    public WalkUpTicket(String eventName,CalendarDate date)
    {
        super(eventName,date);

    }

    public double getPrice()
    {
        // put your code here
        return 50.00;
    }

    public String toString(){
        return "Walk-up Ticket: Event: " + super.getNameOfEvent() + ", Date of Event: " + super.getDateOfEvent() +  ", Price: $50.00";
    }
}
