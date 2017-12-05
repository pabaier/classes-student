
/**
 * Write a description of class Ticket here.
 *
 * Claire Gerwatowski
 * 3 Nov 2017
 */
public class Ticket
{
    private String name;
    private CalendarDate date;
    
    public Ticket(String s, CalendarDate d)
    {
        name = s;
        date = d;
    }
    
    public String getNameOfEvent()
    {
        return name;
    }
    
    public CalendarDate getDateOfEvent()
    {
        return date;
    }
    
    public double getPrice()
    {
        return 0;
    }
    
    public String toString()
    {
        return ("Event: " + name + ", Date of Event: " + date);
    }
    
    
    
}
