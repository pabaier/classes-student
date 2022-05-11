
/**
 * Creates an a ticket that is bought in advance by a student
 *
 * @author Lexus Hartung
 */
public class StudentAdvanceTicket extends AdvanceTicket{
    private double price;
    
    //Constructor for objects of class StudentAdvanceTicket
    public StudentAdvanceTicket(String nameOfEvent, CalendarDate getDateOfEvent,
    CalendarDate dateTicketPurchased){
        super(nameOfEvent, getDateOfEvent, dateTicketPurchased);
    }

    //Calculates and returns the price for a ticket bought in advance by a 
    //student
    public double getPrice(){
        price = super.getPrice();
        price = price/ 2;
        return price;
    }
    
    //Constructs a string for a ticket bought in advance by a student 
    public String toString(){
        return super.toString() + " (ID Required)";
    }
}
