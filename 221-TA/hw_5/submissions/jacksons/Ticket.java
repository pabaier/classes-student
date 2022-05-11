/* Sydney Jackson
 * Ticket class is the super class of the program. 
 */
public class Ticket {
    private String nameOfEvent;
    private CalendarDate dateOfEvent;
    public Ticket(String eventName, CalendarDate eventDay)
    {
        nameOfEvent = eventName;
        dateOfEvent = eventDay;
        
    }

    public String getNameOfEvent()
    {
        return nameOfEvent;
    }
    public CalendarDate getDateOfEvent()
    {
        return dateOfEvent;
    }
    public double getPrice()
    {
        return 0.0;
    }
    public String toString(){
        return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent + ", ";
    }
}
