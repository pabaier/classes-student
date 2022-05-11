
/**
 * Ariel Robinson
 * subclass of the ticket class
 * determines price based on how many days from purchase date to the event
 */
import java.text.NumberFormat;
public class AdvanceTicket extends Ticket
{
    // instance variables 
    private CalendarDate purchaseDate;
    private final double FORTYPRICE=40.00;
    private final double THIRTYPRICE=30.00;
    private double price;
    /**
     * Constructor for objects of class AdvanceTicket
     */
    public AdvanceTicket(String eventName, CalendarDate eventDate, CalendarDate purchaseDate)
    {
        super(eventName,eventDate);
        this.purchaseDate=purchaseDate;

    }
    //returns price

    public double getPrice(){

        if(purchaseDate.daysUntil(super.getDateOfEvent()) >= 10){

            price=THIRTYPRICE;

        }
        else{
            price=FORTYPRICE;

        }
        return price;

    }
    //toString method returns a String of the eventName, purchase date, price and eventDate

    public String toString(){
        return "Advance Ticket: "+  super.toString() + ",Purchase Date: " + purchaseDate.toString()  + ",Price: " +NumberFormat.getCurrencyInstance().format(getPrice());

    }

}
