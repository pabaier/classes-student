import java.util.*;
/**
 * A class to serve as a superclass for all ticket classes. Contains
 * the date of the event as well as the name of the event it is for.
 *
 * @author Richard Marshall
 * 
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private CalendarDate dateOfEvent;
    private String nameOfEvent;

    /**
     * Constructor for objects of class Ticket
     * 
     * @param name name of the event as a String
     * @param date the date the event takes place on as a Calendar date
     */
    public Ticket(String name, CalendarDate date)
    {
        nameOfEvent = name;
        dateOfEvent = date;
    }

    
    public CalendarDate getDateOfEvent()
    {
        return dateOfEvent;
    }
    
    public String getNameOfEvent()
    {
        return nameOfEvent;
    }
    
    /**
     * 
     * Returns the price of the ticket, but since ticket class is
     * not valid for pricing it will be used to override in subclasses
     * 
     * @return    0.0 since the superclass ticket should not have a valid price
     */
    public double getPrice() {
      return 0.0;  
    }
    
    @Override
    public String toString() {
        return "Event: " +  nameOfEvent + ", Date of Event: " + dateOfEvent.getMonthName() + " " + dateOfEvent.getDay() + ", " + dateOfEvent.getYear();
    }
}
