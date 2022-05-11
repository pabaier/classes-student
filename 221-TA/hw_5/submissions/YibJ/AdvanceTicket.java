
/**
 * Write a description of class AdvanceTicket here.
 * tickets purchased in advance depending how far in advance 
 * Julie Yib
 */
import java.text.NumberFormat;
import java.util.*;
public class AdvanceTicket extends Ticket
{
    private double price;
    private CalendarDate datePurchased;
    public AdvanceTicket (String name, CalendarDate date, CalendarDate datePurchased){
        super(name, date);
        this.datePurchased = datePurchased;
    }
    public double getPrice(){
        if (datePurchased.daysUntil(getDateOfEvent()) >= 10){
            price = 30.00;
        }
        if (datePurchased.daysUntil(getDateOfEvent()) < 10){
            price = 40.00;
        }
        return price;
    }
    public String toString(){
        return "Advance Ticket: " + super.toString() + " Price: " 
        + NumberFormat.getCurrencyInstance().format(getPrice());
    }
}
