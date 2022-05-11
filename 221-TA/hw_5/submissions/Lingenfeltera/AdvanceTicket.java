/**
 * AdvanceTicket Subclass.
 * Initializes AdvanceTicket objects
 * getter methods getNameOfEvent() and and getDateOfEvent() to return event and date respectively
 * also stores date purchased
 * getPrice method to get price ($30 if more than 10 days until show, less than 10 days $40)
 * toString method to return name and date of event as Advance Ticket: Event: name of event, Date of Event: Month Day Year, Purchase Date: 
 * Month Day Year, Price: $xx.00
 * 
 * @author:  Andrea Lingenfelter-
 */

import java.text.NumberFormat;

public class AdvanceTicket extends Ticket{
    
    protected double price = 0.0;
    protected CalendarDate datePurchased;
    
    final double EARLY_PRICE = 30.00;
    final double REG_PRESALE_PRICE = 40.00;
    
    public AdvanceTicket(String name, CalendarDate date, CalendarDate datePurchased){
        super(name, date);
        this.datePurchased = datePurchased;
        this.price = getPrice(datePurchased, date);
    }
    
    public double getPrice(CalendarDate datePurchased, CalendarDate dateOfEvent){
        
        int daysUntil = datePurchased.daysUntil(dateOfEvent);
        
        if (daysUntil < 10){
            price = REG_PRESALE_PRICE;
        }
        else {
            price = EARLY_PRICE;
        }
        
        return price;
    }
  
     
    public String toString(){
        return ("Advance Ticket: " + super.toString() +  ", Purchase Date: " 
        + datePurchased.toString() + 
        ", Price: " +  NumberFormat.getCurrencyInstance().format(price));
 
    }
}
