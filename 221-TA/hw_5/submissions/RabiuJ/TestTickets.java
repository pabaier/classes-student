
/** Driver to test the Ticket classes
 * 
 *
 * Jonathan Rabiu
 * 
 */
public class TestTickets
{
    public static void main (String[] args){
        Ticket t1 = new WalkupTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        
        System.out.println("Ticket 1's Price: " + t1.getPrice());
        System.out.println("Name of Ticket 1's event: " + t1.getNameOfEvent());
        System.out.println("Date of Ticket 1's event: " + t1.getDateOfEvent());
        System.out.println(t1.toString());
        System.out.println("Ticket 2's Price: " + t2.getPrice()); //should be 30
        System.out.println(t2.toString());
        System.out.println("Ticket 3's Price: " + t3.getPrice()); //should be 40
        System.out.println(t3.toString()); 
        System.out.println("Ticket 4's Price: " + t4.getPrice()); //should be 15
        System.out.println(t4.toString());
        System.out.println("Ticket 5's Price: " + t5.getPrice()); //should be 20
        System.out.println(t5.toString());
    }
    
}
