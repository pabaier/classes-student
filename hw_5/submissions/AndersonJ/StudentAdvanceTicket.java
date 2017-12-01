
/*
 * Jonathan E. Anderson
 * Further extend advanceticket to tickets bought in advance by students
 * Calculates ticket price
 */
public class StudentAdvanceTicket extends AdvanceTicket{
    String eventName = super.eventName;
    CalendarDate eventDate = super.eventDate;
    CalendarDate currentDate;
    double ticketPrice = this.getPrice();
    
    public StudentAdvanceTicket(String event, CalendarDate date, CalendarDate curDate){
        super(event, date, curDate);
    }
    
    public double getPrice(){
        ticketPrice = super.getPrice() / 2;

        return ticketPrice;
    }
    
    public String toString(){
       return "Event: " + eventName + ", Date of Event: " + eventDate + "Price: " + ticketPrice + " (ID required)";
    }
}