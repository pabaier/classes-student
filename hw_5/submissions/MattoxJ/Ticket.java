
/**
 * Superclass for tickets
 *
 * @author Jacob Mattox
 * @version 11/6/17
 */
public class Ticket
{
    //instance variables
    private String nameOfEvent;
    private CalendarDate dateOfEvent;
    
    //constructor to instantiate variables
    public Ticket(String event, CalendarDate c){
        nameOfEvent = event;
        dateOfEvent = c;
    }
    //getter methods to return variables
    public String getNameOfEvent(){
        return nameOfEvent;
    }
    
    public CalendarDate getDateOfEvent(){
        return dateOfEvent; 
    }
    
    public double getPrice(){
        double price = 0;
        return price;
    }
    //to string to give event name and date in readable format
    public String toString(){
        return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent;
    }
    
}
