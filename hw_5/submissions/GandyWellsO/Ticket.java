
/**
 * Super class for Cofc's Ticket system
 *
 * Orianna Gandy-Wells
 * 
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private String nameOfEvent;
    private CalendarDate dayOfEvent;

   
     
    public Ticket(String nameOfEvent, CalendarDate dayOfEvent)
    {
        this.nameOfEvent = nameOfEvent;
        this.dayOfEvent = dayOfEvent;
        
    }
    public String getNameOfEvent(){
        return nameOfEvent;
    }
    public double getPrice(){
        double price = 0.0;
        return price;
    }
    public CalendarDate getDateOfEvent(){
        return dayOfEvent;
    }
    public String toString(){
        return "Event: " + nameOfEvent + ", Date of Event: " + dayOfEvent; 
    }

}
