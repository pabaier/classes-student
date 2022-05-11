
/**
 * Write a description of class WalkUpTicket here.
 * tickets purchased the day of 
 * Julie Yib
 */
import java.text.NumberFormat;
public class WalkUpTicket extends Ticket
{
    private double price;
    
    public WalkUpTicket(String name, CalendarDate date){
        super (name, date);
    }
    public double getPrice(){
        double price = 50;
        return price;
    }
    public String toString(){
        return "Walk-up Ticket: "+ super.toString() + " Price: " 
        + NumberFormat.getCurrencyInstance().format(getPrice());
    }
}
 