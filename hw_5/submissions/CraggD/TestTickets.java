
/**
 * Tests the ticket superclass and all classes extended from it.
 *
 * @Dustin Cragg
 * @11/10/2017
 */
public class TestTickets
{
    public static void main(String[] args)
    {
        Ticket ticket1 = new WalkUpTicket();
        Ticket ticket2 = new AdvanceTicket();
        Ticket ticket3 = new StudentAdvanceTicket();
        
        
        System.out.println( ticket1 );
        System.out.println( ticket2 );
        System.out.println( ticket3 );
        
    }
    

}
