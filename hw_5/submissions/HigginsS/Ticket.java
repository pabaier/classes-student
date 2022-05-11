
/**
 * Write a description of class Ticket here.
 *
 * Steven Higgins
 * 
 */
public class Ticket
{
    private String eventName;
    private CalendarDate date;
    public Ticket(String eventName, CalendarDate date)
    {
        this.eventName = eventName;
        this.date = date;
    }
    public String getNameOfEvent(){
        return eventName;
    }
    public CalendarDate getDateOfEvent(){
        return date;
    }
    public double getPrice(){
        return 0.0;
    }
    public String toString(){
        return "Event: " + eventName + ", Date of Event: " + date;
    }
}
