/* Sydney Jackson
 * StudentAdvanceTicket class is derived from AdvanceTicket, 
 * differing in ticket price and tells the 
 * user that ID is required for event entry
 */
public class StudentAdvanceTicket extends AdvanceTicket
{   
    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased){
        super(nameOfEvent, dateOfEvent, datePurchased);
    }
    public double getPrice(){
        double studentPrice = (super.getPrice() / 2);
        return studentPrice; 
        
    }
    public String toString(){
        return "Student Advance Ticket: " + super.toString() + " (ID Required)";         
    }
}