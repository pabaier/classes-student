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
    }
}
