
/**
 * Represents tickets purchased in advance by students (half off)
 *
 * Jonathan Rabiu
 *
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
   public StudentAdvanceTicket(String nameofEvent, CalendarDate dateofEvent, CalendarDate datePurchased){   
       super(nameofEvent,dateofEvent,datePurchased);
   }   
   
   @Override
   public double getPrice(){
       super.getPrice();
       ticketPrice = ticketPrice/2;
       return ticketPrice;
   }
   
   @Override
   public String toString(){
       return "Student " +super.toString() + " (ID Required)";
    }
}
