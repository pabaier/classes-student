
import java.text.NumberFormat;
/*
 * Orianna Gandy-Wells
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
  
   
    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dayOfEvent, CalendarDate purchaseDate)
    {
        super(nameOfEvent, dayOfEvent, purchaseDate);
       
    }
    public double price(){
        double price = super.getPrice() / 2;
        return price;
    }
    public String toString(){
        
        return "Student " + super.toString() + " (ID Required)";
    }
}
