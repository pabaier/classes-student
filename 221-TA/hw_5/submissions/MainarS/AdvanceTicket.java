import java.lang.*;
public class AdvanceTicket extends Ticket{
    
    private CalendarDate p;
    public AdvanceTicket(String name, CalendarDate d, CalendarDate p){
        super(name, d);
        this.p = p;
    }
    public double getPrice(){
        double var = 0.0;
        if(p.daysUntil(d) >= 10){
           var = 30.0;
           return var;
        }
        var = 40.0;
        return var;
    }
    public String toString(){
        return "Advance Ticket: " + super.toString() + ", Purchase Date: "
                + this.p + ", Price: $" + this.getPrice() + "0";
    }


}
