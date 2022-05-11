/*
 * Jonathan E. Anderson
 * The Base class for all tickets.
 */

public class Ticket{
   String eventName = "";
   CalendarDate eventDate; 
   double ticketPrice = 0;
   
   public Ticket(String event, CalendarDate date){
       eventName = event;
       eventDate = date;
    }
    
   public CalendarDate getDayOfEvent(){
       this.eventDate = eventDate;
       return eventDate;
    }
    
   public String getNameofEvent(){
       this.eventName = eventName;
       return eventName;
    }
    
   public double getPrice(){
       this.ticketPrice = ticketPrice;
       return ticketPrice;
    }
    
   public String toString(){
       return "Event: " + eventName + ", Date of Event: " + eventDate;
    }
    
}