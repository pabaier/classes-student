
/**
 * Write a description of class TestTickets here.
 *
 * Claire Gerwatowski
 * 3 Nov 2017
 */
public class TestTickets
{
    public static void main(String[] args)
    {
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
        new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
        new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
        new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
        new CalendarDate(2018, 3, 27));
        System.out.println("T1: " + t1);
        System.out.println("Testing get name method: " + t1.getNameOfEvent());
        System.out.println("");
        System.out.println("T2: " + t2);
        System.out.println("Testing get price method: " + t2.getPrice());
        System.out.println("");
        System.out.println("T3: " + t3);
        System.out.println("Testing get date method: " + t3.getDateOfEvent());
        System.out.println("");
        System.out.println("T4: " + t4);
        System.out.println("");
        System.out.println("T5: " + t5);
    }
}
