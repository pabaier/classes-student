
/**
 * Write a description of class Ticket here.
 *The inheritance class ticket
 * Julie Yib
 */
public class Ticket
{
    private String nameOfEvent;
    private CalendarDate dateOfEvent;
   
    public Ticket(String name, CalendarDate date){
        this.nameOfEvent = name ;
        this.dateOfEvent = date;
    }
    public String getNameOfEvent(){
        return nameOfEvent;
    }
    public CalendarDate getDateOfEvent(){
        return dateOfEvent;
    }
    public double getPrice(){
        double price = 0;
        return price;
    }
    public String toString(){
        return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent.getMonthOfYear() + " " 
        + dateOfEvent.getDay() + ", " + dateOfEvent.getYear();
    }
}
