
/*
 * Jonathan E. Anderson
 * Further extend ticket to tickets bought in advance
 * Calculates ticket price
 */
public class AdvanceTicket extends Ticket{
    String eventName = super.eventName;
    CalendarDate eventDate = super.eventDate;
    CalendarDate currentDate = new CalendarDate();
    double ticketPrice = this.getPrice();
    
    public AdvanceTicket(String event, CalendarDate date, CalendarDate curDate){
        super(event, date);
        currentDate = curDate;
    }
    
    public double getPrice(){
       if (currentDate.daysUntil(eventDate) < 10){
           ticketPrice = 40;
        } else {
            ticketPrice = 30;
        }
        return ticketPrice;
    }
    
    public String toString(){
       return "Event: " + eventName + ", Date of Event: " + eventDate + "Price: " + ticketPrice;
    }
}