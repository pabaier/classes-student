
/**
 * Write a description of class StudentAdvanceTicket here.
 *
 * Steven Higgins
 * 
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    public StudentAdvanceTicket(String eventName, CalendarDate date, CalendarDate purchaseDate)
    {
        super(eventName, date, purchaseDate);
    }
    public double getPrice(){ 
        return super.getPrice() / 2;
    }
    public String toString(){
        return String.format("Student " + super.toString() + "(ID Required)");
    }

}
