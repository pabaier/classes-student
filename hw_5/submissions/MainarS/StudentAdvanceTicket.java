
public class StudentAdvanceTicket extends AdvanceTicket{
    
    public StudentAdvanceTicket(String name, CalendarDate d, CalendarDate p){
        super(name, d, p);
    }
    public double getPrice(){
        return super.getPrice()/2.0;
    }
    public String toString(){
        return "Student Advance Ticket: " + super.toString() + "(ID Required)";
    }
}
