
/**
 * Creates a base line ticket 
 *
 * @author Lexus Hartung
 */
public class Ticket{
    protected String nameOfEvent;
    protected CalendarDate getDateOfEvent;
    
    // Constructor for objects of class Ticket
    public Ticket(String nameOfEvent, CalendarDate getDateOfEvent){
        this.nameOfEvent = nameOfEvent;
        this.getDateOfEvent = getDateOfEvent;
    }

    //Returns the events name
    public String getNameOfEvent(){
        return nameOfEvent;
    }
    
    //Returns the date of the event
    public CalendarDate getDateOfEvent(){
        return getDateOfEvent;
    }
    
    //Gives a price for a base ticket
    public double getPrice(){
        return 0.0;
    }
    
    //Constructs a string for a base ticket
    public String toString(){
        return "Event: " + nameOfEvent + ", Date of Event: " + getDateOfEvent;
    }
}
