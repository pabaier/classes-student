
/**
 * Write a description of class Ticket here.
 *
 * @author Matt Hancock
 * @version 1 11/7/2017
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private String nameOfEvent;
    private CalendarDate dateOfEvent;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String name, CalendarDate date)
    {
        nameOfEvent = name;
        dateOfEvent = date;
        
    }
    public String getNameOfEvent()
    {
        return this.nameOfEvent;
    }
    public double getPrice()
    {
        double price = 0.0;
        return price;
    }
    public CalendarDate getDateOfEvent()
    {
        return this.dateOfEvent;
    }
    public String toString(){
        return "Event: "+this.nameOfEvent + ", " +this.dateOfEvent.monthString() + " " +this.dateOfEvent.getDay() + ", " + this.dateOfEvent.getYear() + "";
    }

    
}
