
/**
 * A superclass for three types of tickets
 * 
 * Ashley Woods
 */
public class Ticket
{
    private String nameOfEvent;
    private CalendarDate dateOfEvent;
    
    public Ticket(String NameOfEvent, CalendarDate DateOfEvent) {
        nameOfEvent = NameOfEvent;
        dateOfEvent = DateOfEvent;
    }
    
    public String getNameOfEvent() {
        return this.nameOfEvent;
    }
    
    public CalendarDate getDateOfEvent() {
        return this.dateOfEvent;
    }
    
    public double getPrice() {
        return 0;
    }
    
    public String toString() {
        return "Event: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent();
    }
}
