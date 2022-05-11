
/**
 * A tester for the diffrent types of tickets
 *
 * @author Lexus Hartung
 */
public class TestTickets{
    public static void main(String[] args){
        //All the tickets are made
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", 
        new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", 
        new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", 
        new CalendarDate(2018, 4, 1), new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", 
        new CalendarDate(2018, 4, 1), new CalendarDate(2018, 3, 27));
        
        //Walk-up Ticket test
        System.out.println("Walk up ticket test");
        System.out.println(t1.getPrice());
        System.out.println(t1);
        System.out.println();
        
        //Advance Ticket tests
        System.out.println("Advance ticket test number 1");
        System.out.println(t2.getPrice());
        System.out.println(t2);
        System.out.println();
        
        System.out.println("Advance ticket test number 2");
        System.out.println(t3.getPrice());
        System.out.println(t3);
        System.out.println();
        
        //Student Advance Ticket tests
        System.out.println("Student Advance ticket test number 1");
        System.out.println(t4.getPrice());
        System.out.println(t4);
        System.out.println();
        
        System.out.println("Student Advance ticket test number 2");
        System.out.println(t5.getPrice());
        System.out.println(t5);
        System.out.println();
    }
}