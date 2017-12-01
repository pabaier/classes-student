
/**
 * Write a description of class StudentAdvanceTicket here.
 *
 * @author Jacob Mattox
 * @version 11/8/17
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    //extends AdvanceTicket and uses its constructor to create a Ticket instance
    public StudentAdvanceTicket(String name, CalendarDate eventC, CalendarDate todayC){
        super(name, eventC, todayC);
    }
    public StudentAdvanceTicket(CalendarDate eventC, String name, CalendarDate todayC){
        super(name, eventC, todayC);
    }
    public StudentAdvanceTicket(CalendarDate eventC, CalendarDate todayC, String name){
        super(name, eventC, todayC);
    }
    //uses AdvanceTicket to calculate student ticket price
    public double getPrice(){
        double price;
        price = super.getPrice()/2;
        
        return price;
    }
    //uses AdvanceTicket toString and adds additional information
    public String toString(){
        return "Student " + super.toString() + " (ID required)";
    }

}
