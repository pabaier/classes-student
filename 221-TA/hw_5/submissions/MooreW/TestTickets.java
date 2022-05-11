
public class TestTickets {

	public static void main(String[] args) {
		Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
		System.out.println(t1);
		
		Ticket t2 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate());
		System.out.println(t2);
		
		Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate(2018, 3, 27));
		System.out.println(t3);
		
		Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate());
		System.out.println(t4);
		
		Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
		 new CalendarDate(2018, 3, 27));
		System.out.println(t5);

	}

}
