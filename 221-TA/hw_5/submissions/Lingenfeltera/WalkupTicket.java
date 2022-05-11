
/**
 * Ticket Superclass.
 * Initializes Ticket objects
 * getter methods getNameOfEvent() and and getDateOfEvent() to return event and date respectively
 * getPrice method to get price (though this will be overridden in subclasses)
 * toString method to return name and date of event as Event: name of event, Date of Event: Month Day Year
 * 
 * @author:  Andrea Lingenfelter-
 */


import java.text.NumberFormat;

public class WalkupTicket extends Ticket{
    protected String eventName;
    protected CalendarDate eventDate;
    final double PRICE = 50.00;
    
    public WalkupTicket(String name, CalendarDate date){
        super(name, date);
        this.eventName = name;
        this.eventDate = date;
    }
   
    
        public double getPrice(){ 
        return PRICE;
    }
    
    public String toString(){
        return ("Walkup Ticket: " + super.toString() +  ", Price: " +  NumberFormat.getCurrencyInstance().format(PRICE));
    }
}
