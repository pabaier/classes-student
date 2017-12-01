import java.text.NumberFormat;
/**
 *
 *Orianna Gandy-Wells
 *
 */
public class WalkUpTicket extends Ticket
{   
  
    public WalkUpTicket(String nameOfEvent, CalendarDate dayOfEvent){
        super(nameOfEvent, dayOfEvent);
    }
    public double getPrice(){
        double price = 50.00;
        return price;
        
    }
    public String toString(){
        return "Walk up Ticket: Event: " + super.getNameOfEvent() + ", Date of Event: " + super.getDateOfEvent() + ", Price: " + NumberFormat.getCurrencyInstance().format(getPrice());
    }
   
}