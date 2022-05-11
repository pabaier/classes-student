
/**
 * Write a description of class AdvanceTicket here.
 *
 * Steven Higgins
 * 
 */
public class AdvanceTicket extends Ticket
{
    private final double TEN_DAYS_PLUS_BEFORE = 30.0;
    private final double LESS_TEN_DAYS_BEFORE = 40.0;
    private CalendarDate purchaseDate;
    
    public AdvanceTicket(String eventName, CalendarDate date, CalendarDate purchaseDate)
    {
        super(eventName, date);
        this.purchaseDate = purchaseDate;
    }
    public CalendarDate datePurchased(){
        return purchaseDate;
    }
    public double getPrice(){
        double price = 0.0;
        if(purchaseDate.daysUntil(getDateOfEvent()) >= 10){
            price = TEN_DAYS_PLUS_BEFORE;
        }
        else if(purchaseDate.daysUntil(getDateOfEvent()) < 10 && 
        purchaseDate.daysUntil(getDateOfEvent()) > 0){
            price = LESS_TEN_DAYS_BEFORE;
        }
        return price;
    }
    public String toString(){
        return String.format("Advance Ticket: " + super.toString() + " Price: $%.2f", getPrice());
    }
}
