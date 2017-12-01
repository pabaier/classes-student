/* 
 * Jonathan E. Anderson
 * Walk up ticket class further specifies the type of ticket
 */

public class WalkUpTicket extends Ticket{
    String eventName = super.eventName;
    CalendarDate eventDate = super.eventDate; 
    double ticketPrice = 50;
    
    public WalkUpTicket(String event, CalendarDate date){
        super(event, date);
    }
    
    public double getPrice(){
       this.ticketPrice = ticketPrice;
       return ticketPrice;
     }
    
    public String toString(){
       return "Event: " + eventName + ", Date of Event: " + eventDate + "Price: " + ticketPrice;
     }
    
}