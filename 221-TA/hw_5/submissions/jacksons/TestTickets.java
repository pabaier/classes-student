/* Sydney Jackson
 * TestTickets tests each class derived from Tickets class by creating a new ticket of each type
 * and printing them.
 */
public class TestTickets{
    public static void main(String[] args){
        Ticket t1 = new WalkupTicket("Basketball", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball", new CalendarDate(2018,4, 1), new CalendarDate());
        Ticket t3 = new AdvanceTicket("Soccer", new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Football", new CalendarDate(2018, 4,1), new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Softball", new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
    }
}
    