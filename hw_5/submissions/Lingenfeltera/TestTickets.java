/**
 * HW5 test driver.
 * uses CalendarDate class with daysUntil method to calculate date until event
 * calls to construct WalkUp Ticket, Advance Ticket, Student Advance Tickets to test functionality.
 * 
 * @author:  Andrea Lingenfelter-
 */
public class TestTickets {

    public static void main(String[] args) {
    Ticket t1 = new WalkupTicket("Basketball vs. LSU", new CalendarDate());
    Ticket t2 = new AdvanceTicket("Baseball vs. LSU" , new CalendarDate(2018, 4, 1), new CalendarDate (2018, 3, 27));
    Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
    Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU" , new CalendarDate(2018, 4, 1), new CalendarDate (2018, 3, 27));
    Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
    
    System.out.println(t1.toString());
    System.out.println(t2.toString());
    System.out.println(t3.toString());
    System.out.println(t4.toString());
    System.out.println(t5.toString());
    
    
    }

}
