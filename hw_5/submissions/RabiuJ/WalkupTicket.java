
/**
 * Represents tickets bought at the door
 * 
 * Jonathan Rabiu
 * 
 */
public class WalkupTicket extends Ticket
{
    public WalkupTicket(String nameofEvent, CalendarDate dateofEvent){
        super(nameofEvent, dateofEvent);   
    }
    
    @Override
    public double getPrice(){
        ticketPrice = 50.00;
        return ticketPrice;
    }
    
    @Override
    public String toString(){
        return "Walk-up Ticket: " + super.toString() + ", Price: " + "$" + String.format("%.2f",ticketPrice);
    }
}
