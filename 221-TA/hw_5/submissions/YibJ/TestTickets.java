
/**
 * Write a description of class TestTickets here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestTickets
{
    public static void main(String[] args){
        
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
        
        Ticket t6 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t7 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 5, 1),
        new CalendarDate());
        Ticket t8 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 6, 1),
        new CalendarDate(2018, 5, 27));
        Ticket t9 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 7, 1),
        new CalendarDate());
        Ticket t10 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 8, 1),
        new CalendarDate(2018, 7, 27));
        System.out.println(t6);
        System.out.println(t7);
        System.out.println(t8);
        System.out.println(t9);
        System.out.println(t10);
    }
}
