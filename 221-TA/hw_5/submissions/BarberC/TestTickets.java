//@author Carson Barber
import java.util.ArrayList;
public class TestTickets
{
    public static void main(String[] args){
        //create various test tickets
        Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
        Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate());
        Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate(2018, 3, 27));
        Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate());
        Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
            new CalendarDate(2018, 3, 27));
        
        //Put each ticket into an array list
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);
        
        //print each ticket's toString
        for(int i = 0; i<tickets.size(); i++){
            System.out.println(tickets.get(i).toString());
        }
        
    }
}
