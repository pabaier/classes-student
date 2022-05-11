
/**
 * Write a description of class TestTickets here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestTickets
{
    public static void main()
    {
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate (2018, 4, 1), new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println("t4: " + t4);
        System.out.println("t5: " + t5);
    }
}
