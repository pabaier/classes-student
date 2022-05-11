
/**
 * constructor for a student Advance Ticket, which is a subclass of AdvanceTicket, which is a subclass of Ticket.
 *
 * @author Matt Hancock
 * @version 1 11/7/2017
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    // instance variables - replace the example below with your own
    private String nameOfEvent = "";
    private CalendarDate dateOfEvent;
    private CalendarDate datePur;

    /**
     * Constructor for objects of class studentAdvanceTicket
     */
    public StudentAdvanceTicket(String name, CalendarDate date, CalendarDate datePurchased)
    {
        super(name,date, datePurchased);
        nameOfEvent = name;
        dateOfEvent = date;
        datePur = datePurchased;
    }
    public double getPrice()
    {
        double price = 0.0;
        if (datePur.daysUntil(dateOfEvent) > 10){
            price = 15.0;
        }
        else if(datePur.daysUntil(dateOfEvent) < 10){
            price = 20.0;
        }
        return price;
    }
    public String toString(){
        
        return "Student " + super.toString() + " (ID Required)" ;
    }
}
