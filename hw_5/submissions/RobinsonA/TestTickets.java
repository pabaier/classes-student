
/**
 *
 * Ariel Robinson
 * The main method used to test the different classes
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
        Ticket t6= new AdvanceTicket("Music Symphony", new CalendarDate(2018, 1, 1), new CalendarDate(2017,12,27));
        Ticket t7 = new WalkUpTicket("Rock Concert", new CalendarDate());
        Ticket t8 = new AdvanceTicket("Country Music Festival", new CalendarDate(2017, 11, 10),
                new CalendarDate(2017,5,1));

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
        System.out.println(t7);
        System.out.println(t8);

    }
}
