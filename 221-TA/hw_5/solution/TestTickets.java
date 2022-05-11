
/**
 * Write a description of class TestTickets here.
 *
 * @author Jacob Mattox
 * @version 11/8/17
 */
public class TestTickets
{
    //various test cases for methods and variables
    public static void main(){
        
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate(2018, 3, 27));
        Ticket t6 = new WalkUpTicket("Outkast" , new CalendarDate());
        Ticket t7 = new AdvanceTicket("Soccer vs. Clemson", new CalendarDate(2018, 7, 6), 
            new CalendarDate(2018, 7, 3));
        Ticket t8 = new StudentAdvanceTicket("Soccer vs. USC", new CalendarDate(2018, 6, 6), 
            new CalendarDate());
        Ticket t9 = new StudentAdvanceTicket("Soccer vs. USC", new CalendarDate(2018, 6, 6), 
            new CalendarDate(2018, 6, 5));
        Ticket t10 = new Ticket("Game", new CalendarDate());
            
        //each test case followed by the getPrice() method of each
        System.out.println(t1);
        System.out.printf("$%.02f\n", t1.getPrice());
        System.out.println(t2);
        System.out.printf("$%.02f\n", t2.getPrice());
        System.out.println(t3);
        System.out.printf("$%.02f\n", t3.getPrice());
        System.out.println(t4);
        System.out.printf("$%.02f\n", t4.getPrice());
        System.out.println(t5);
        System.out.printf("$%.02f\n", t5.getPrice());
        System.out.println(t6);
        System.out.printf("$%.02f\n", t6.getPrice());
        System.out.println(t7);
        System.out.println(t8);
        System.out.println(t9);
        System.out.println(t10);
        
        //testing additional getter methods
        System.out.println(t8.getNameOfEvent());
        System.out.println(t8.getDateOfEvent());
    }
}
