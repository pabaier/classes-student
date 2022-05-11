
/**
 * Creates a ticket bought at the door
 *
 * @author Lexus Hartung
 */
import java.text.DecimalFormat;
public class WalkUpTicket extends Ticket{
    private double price;

    //Constructor for objects of class WalkUpTicket
    public WalkUpTicket(String nameOfEvent, CalendarDate getDateOfEvent){
        super(nameOfEvent, getDateOfEvent);
        price = 50.00;
    }
    
    //Returns the price for a walk up ticket
    public double getPrice(){
        return price;
    }
    
    //Constructs a string for a walk up ticket
    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return super.toString() + ", Price: $" + format.format(price);
    }
}
