//@ author: Stefan Veloff
//I discussed this assignment with: Mackenzie S. & Anthony M. (CSCI LAB) as well as Kyle W.
//This is a tester for creating tickets.
//Various dates were tested as well to see if they were valid
public class TestTickets {
	public static void main(String[] args) {

	//creating tickets and event information:
	Ticket t1 = new WalkUpTicket("Hootie And The Blowfish", new CalendarDate(2018, 4, 1));
	Ticket t2 = new AdvanceTicket("Elvis Presley Not-live", new CalendarDate(2018, 4, 1),
	 new CalendarDate());
	Ticket t3 = new AdvanceTicket("Veil of Maya", new CalendarDate(2018, 4, 1),
	 new CalendarDate(2018, 3, 27));
	Ticket t4 = new StudentAdvanceTicket("All Shall Perish", new CalendarDate(2018, 4, 1),
	 new CalendarDate());
	Ticket t5 = new StudentAdvanceTicket("Warpped Tour", new CalendarDate(2018, 4, 1),
	 new CalendarDate(2018, 3, 27));
	Ticket t6 = new WalkUpTicket("CofC Soccer vs. NC State Soccer", new CalendarDate(2018, 9, 11));
	Ticket t7 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 5, 1),
	 new CalendarDate());
	Ticket t8 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
	Ticket t9 = new StudentAdvanceTicket("Clemson vs. ALL", new CalendarDate(2018, 5, 1),
	 new CalendarDate());
	
	//this checks for a failed date:
	Ticket t10 = new StudentAdvanceTicket("FAIL DATE", new CalendarDate(2010, 5, 1),
			 new CalendarDate());

	//testing and printing out the output:
	System.out.println(t1);
	System.out.println(t2);
	System.out.println(t3);
	System.out.println(t4);
	System.out.println(t5);
	System.out.println(t6);
	System.out.println(t7);
	System.out.println(t8);
	System.out.println(t9);
	System.out.println(t10);
	}
}