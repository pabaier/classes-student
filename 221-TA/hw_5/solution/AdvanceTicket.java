import java.text.NumberFormat;
/**
 * Write a description of class AdvanceTicket here.
 *
 * @author Jacob Mattox
 * @version 11/8/17
 */
public class AdvanceTicket extends Ticket
{
    //class to extend Ticket and add a date purchased variable 
    private CalendarDate datePurchased;
    //constructor using Ticket class constructor and adding datePurchased variable
    public AdvanceTicket(String name, CalendarDate eventC, CalendarDate todayC){
        super(name, eventC);
        datePurchased = todayC;
    }
    
    public AdvanceTicket(CalendarDate eventC, String name, CalendarDate todayC){
        super(name, eventC);
        datePurchased = todayC;
    }

    public AdvanceTicket(CalendarDate eventC, CalendarDate todayC, String name){
        super(name, eventC);
        datePurchased = todayC;
    }
    //calculates the price of the event based on time before the event
    public double getPrice(){
        double price = 30;
        if(datePurchased.daysUntil(this.getDateOfEvent())< 10){
            price = 40;
        }
        return price;
    }
    //uses Ticket class string and adds additional information
    public String toString(){
        return "Advance Ticket: " + super.toString() + " Purchase Date: " + datePurchased 
            + ", Price: " + NumberFormat.getCurrencyInstance().format(getPrice());
    }
}
