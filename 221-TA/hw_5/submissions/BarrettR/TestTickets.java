
/**
 * Tests ticket classes for HW5
 *
 * @author Ryan Barrett
 * @version 11/4/17
 */
public class TestTickets
{
    public static void main(String []args){
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
                new CalendarDate(2018, 3, 27));
                
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t1.getPrice());
        System.out.println(t2.getPrice());
        System.out.println(t3.getPrice());
        System.out.println(t4.getPrice());
        System.out.println(t5.getPrice());
        return;
    }
}
