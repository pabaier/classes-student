/**
 * StudentAdvanceTicket Subclass.
 * Initializes AdvanceTicket objects
 * getter methods getNameOfEvent() and and getDateOfEvent() to return event and date respectively
 * also stores date purchased
 * getPrice method to get price (calls AdvanceTicket.getPrice() then divides by 2)
 * toString method that adds Student to front of string and (ID Required) to end of string
 * @author:  Andrea Lingenfelter-
 */
public class StudentAdvanceTicket extends AdvanceTicket {
    public StudentAdvanceTicket(String name, CalendarDate date, CalendarDate datePurchased){
        super(name, date, datePurchased);
        
        this.price = (getPrice(datePurchased, date))/2;
    }
    
    public String toString(){
        return("Student " + super.toString() + " (ID required)");
    }

}
