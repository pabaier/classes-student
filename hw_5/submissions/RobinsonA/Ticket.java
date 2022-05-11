
/**
 * Ariel Robinson
 * The super class 
 * returns the name of the event and the date
 *
 * 
 */
import java.util.Scanner;
public class Ticket
{
    // instance variables 

    private String eventName;
    private CalendarDate eventDate;
    private final double PRICE=0;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String eventName,CalendarDate eventDate)
    {
        this.eventName=eventName;
        this.eventDate=eventDate;

    }
    //return name of event
    public String getNameOfEvent(){

        return eventName;
    }
    //return date of event
    public CalendarDate getDateOfEvent(){
        return eventDate;
    }
    //return price
    public double getPrice(){
        return PRICE;

    }
    //toString method returns the String of the event name and date
    public String toString(){
        return "Event: " + eventName +"," + "Date of Event: " + eventDate.toString()  ;
    }
}
