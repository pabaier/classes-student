
/**
 * Creates an a ticket that is bought in advance
 *
 * @author Lexus Hartung
 */
import java.text.DecimalFormat;
public class AdvanceTicket extends Ticket{
    private double price;
    private CalendarDate dateTicketPurchased;
    
    //Constructor for objects of class AdvanceTicket
    public AdvanceTicket(String nameOfEvent, CalendarDate getDateOfEvent,
    CalendarDate dateTicketPurchased){
        super(nameOfEvent, getDateOfEvent);
        this.dateTicketPurchased = dateTicketPurchased;
    }

    //Calculates and returns the price of a ticket bought in advance
    public double getPrice(){
        int time = dateTicketPurchased.daysUntil(getDateOfEvent);
        if (time >= 10){
            price = 30;
        }
        else{
            price = 40;
        }
        return price;
    }
    
    //Constructs a string for an advanced ticket
    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return super.toString() + ", Purchase Date: " + dateTicketPurchased 
        + ", Price: $" + format.format(this.getPrice());
    }
}
