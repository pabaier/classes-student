
/**
 * constructor for Advance Ticket, which is a subclass of Ticket.
 *
 * @author Matt Hancock
 * @version 1 11/7/2017
 */
public class AdvanceTicket extends Ticket
{
    // instance variables - replace the example below with your own
    private String nameOfEvent = "";
    private CalendarDate dateOfEvent;
    private CalendarDate datePur;
    
    /**
     * Constructor for objects of class AdvanceTicket
     */
    public AdvanceTicket(String name, CalendarDate date, CalendarDate datePurchased)
    {
        super(name,date);
        nameOfEvent = name;
        dateOfEvent = date;
        datePur = datePurchased;
    }
    public double getPrice()
    {
        double price = 0.0;
        if (datePur.daysUntil(dateOfEvent) > 10){
            price = 30.0;
        }
        else if(datePur.daysUntil(dateOfEvent) < 10){
            price = 40.0;
        }
        return price;
    }
    public String toString(){
        
        return "Advance Ticket: " + super.toString() + ", Puchase date: " + datePur.monthString() + " " + datePur.getDay() + ", " + datePur.getYear() + ", Price: $" + this.getPrice();
    }
}
