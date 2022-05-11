//@author Carson Barber

public class WalkUpTicket extends Ticket
{   
    final static double walkUpPrice = 50;
    
    public WalkUpTicket(String eventName, CalendarDate dateOf){
        super(eventName, dateOf);
    }
    
    public double getPrice(){
        return walkUpPrice;
    }
    
    public String toString(){
        return "Walk-up Ticket: " + super.toString() + ", Price: " + getPrice();
    }
}
