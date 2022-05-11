/*
 * Tyler Gray
 * Class for running and testing ticket classes
 * generate tickets and outputs the info testing toString methods of all ticket and ticket subclasses
 * 
 * 
 * 
 */

import java.util.ArrayList;

public class TestTickets {
	
	public static void main(String[] args) {
		
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
		Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate());
		Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate(2018, 3, 27));
		Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate());
		Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate(2018, 3, 27));
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		tickets.add(t5);
		for(Ticket t : tickets) {
			System.out.printf("%s\n",t.toString());
		}
		

	}

}
