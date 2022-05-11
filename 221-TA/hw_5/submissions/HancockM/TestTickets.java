
/**
 * Driver for HW5 ticket superclass
 *
 * @author Matt Hancock
 * @version 1 11/7/2017
 */
public class TestTickets
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class TestTickets
     */
    public static void main(String[] args)
    {
        // initialise instance variables
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),new CalendarDate(2018, 3, 27));
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
    }


}
