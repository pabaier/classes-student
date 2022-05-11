
/**
 * Write a description of class StudentAdvanceTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    public StudentAdvanceTicket(String NameOfEvent, CalendarDate DateOfEvent, CalendarDate DatePurchased) {
        super(NameOfEvent, DateOfEvent, DatePurchased);
    }
    
    public double getPrice() {
        double price = super.getPrice();
        return price / 2;
    }
    
    public String toString() {
        return "Student Advance Ticket: " + super.toString() + " (ID Required)";
    }
    
}
