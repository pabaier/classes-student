
/**
 * Write a description of class StudentAdvanceTicket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentAdvanceTicket extends AdvanceTicket
{

    public StudentAdvanceTicket(String event, CalendarDate date, CalendarDate datePurch)
    {
        super(event, date, datePurch);

    }

    public double getPrice() {
        double rtnVal = 0.0;
        if (super.getPrice() == 30.00) {
            rtnVal = super.getPrice() / 2;
        } else if (super.getPrice() == 40.00) {
            rtnVal = super.getPrice() / 2;
        }
        return rtnVal;
    }
    /*
    The toString method should return a String that looks like the following. It should use Ticket’s toString and add what it needs to add.
"StudentAdvance Ticket: Event: Elvis Presley Not-live, Date of Event December 19, 2017, Purchase Date: November 3, 2017, Price: $30.00"

     */
    public String toString(){
        return "Student Advance Ticket: " + "Event Name: " + super.getNameOfEvent() + ", Date of Event: " + super.getDateOfEvent() + ", Price: " + getPrice() + "(ID Required)";
    }






}
