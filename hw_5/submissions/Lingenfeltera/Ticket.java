/**
 * Ticket Superclass.
 * Initializes Ticket objects
 * getter methods getNameOfEvent() and and getDateOfEvent() to return event and date respectively
 * getPrice method to get price (though this will be overridden in subclasses)
 * toString method to return name and date of event as Event: name of event, Date of Event: Month Day Year
 * 
 * @author:  Andrea Lingenfelter-
 */

import java.util.*;

public class Ticket {
    protected String nameOfEvent;
    protected CalendarDate dateOfEvent;
       
    /*public Ticket(){
        this.nameOfEvent = getNameOfEvent();
        this.dateOfEvent = getDateOfEvent();
    }
    */
    public Ticket(String name, CalendarDate date){
        this.nameOfEvent = name;
        this.dateOfEvent = date;
    }
    
    public void setNameOfEvent(String name){
        nameOfEvent = name;
    }
    
    public String getNameOfEvent(){
        return nameOfEvent;
    }
    
    public void setDate(CalendarDate date) {
        dateOfEvent = date;
    }
    
    public CalendarDate getDateOfEvent(){
        return dateOfEvent;
    }
    
    public double getPrice(){ 
        return 0;
    }
    
    public String toString(){
        return ("Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent);
    }
}
