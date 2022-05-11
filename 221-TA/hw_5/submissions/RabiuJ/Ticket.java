
/**
 * Superclass for all three types of tickets
 *
 * Jonathan Rabiu
 * 
 */
public class Ticket
{
    private String eventName;
    protected CalendarDate date = new CalendarDate();
    protected double ticketPrice;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String nameofEvent, CalendarDate dateofEvent)
    {
        eventName = nameofEvent;
        date = dateofEvent;      
    }

    public String getNameOfEvent(){
        return eventName;
    }
    
    public CalendarDate getDateOfEvent(){
        return date;
    }
    
    public double getPrice(){
        return ticketPrice;
    }
    
    public String toString(){
        return "Event: " + eventName + ", Date of Event: " + date;
    }
}
