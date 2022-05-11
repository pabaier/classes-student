import java.text.NumberFormat;
/**
 * Write a description of class AdvanceTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdvanceTicket extends Ticket
{
    private CalendarDate purchaseDate;
    
    public AdvanceTicket(String nameOfEvent, CalendarDate dayOfEvent, CalendarDate purchaseDate)
    {
        super(nameOfEvent, dayOfEvent);
        this.purchaseDate = purchaseDate;
    }
    public double getPrice(){
        double price = 0;
        int days = this.purchaseDate.daysUntil(super.getDateOfEvent());
        
        if (days >= 10){
            price = 30.0;
        }
        if (days< 10){
            price = 40.0;
        }
        return price;
    }
    public String toString(){
        return "Advance Ticket: Event: " + super.getNameOfEvent() + ", Date of Event: " + super.getDateOfEvent() + ", Date of purchase: " + purchaseDate +", Price: " + NumberFormat.getCurrencyInstance().format(getPrice());
    }
}
