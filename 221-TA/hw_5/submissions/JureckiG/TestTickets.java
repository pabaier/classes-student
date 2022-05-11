/*Gabe Jurecki*/
public class TestTickets {
    public static void main(String args[]){
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());

        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());

        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());

        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());

        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());

        Ticket t6 = new AdvanceTicket("Timmy Hicken's live", new CalendarDate(2017, 11, 5 ), new CalendarDate());

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
    }
}
