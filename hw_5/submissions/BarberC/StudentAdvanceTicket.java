//@author Carson Barber

public class StudentAdvanceTicket extends AdvanceTicket
{
   
    public StudentAdvanceTicket(String eventName, CalendarDate eventDate, CalendarDate purchaseDate){
        super(eventName, eventDate, purchaseDate);
    }
    
    public double getPrice(){
        return super.getPrice()/2;
    }
    public String toString(){
        return "Student " + super.toString() + " (ID Required)";
    }
}
