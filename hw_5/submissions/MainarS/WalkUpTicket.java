import java.util.*;
import java.lang.*;

public class WalkUpTicket extends Ticket {

    private final double price = 50.0;
    
    public WalkUpTicket(String name, CalendarDate d) {
        super(name,d);
        
    }
    
    public double getPrice(){
        return price;
    }
    
    public String toString(){
        return "Walk-up Ticket: " + super.toString() + ", Price: $" + price + "0";
        
    }
    
}
