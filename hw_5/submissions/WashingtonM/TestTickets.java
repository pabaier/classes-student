/*
 * Creates a test driver for the super Ticket class and its subclasses
 * Author: Mary Washington
 * Version: Eclipse Oxygen 4.7
 */

public class TestTickets{
	
	public static void main (String[] arg0) {
		//tests the normal walk up ticket
		Ticket t1 = new WalkUpTicket("Basketball vs. LSU", new CalendarDate());
		//tests the purchasing of tickets in 10 or more days in advance
		Ticket t2 = new AdvanceTicket("Baseball vs LSU", new CalendarDate(2018, 4, 11),
				new CalendarDate());
		//tests the purchasing of tickets less than 10 days in advance
		Ticket t3 = new AdvanceTicket("Baseball vs. LSU", new CalendarDate(),
				new CalendarDate(2017, 11, 1));
		//tests the student purchasing of tickets in 10 or more days in advance
		Ticket t4 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(2018, 4, 1),
				new CalendarDate());
		//tests the student purchases of tickets in less than 10 days in advance
		Ticket t5 = new StudentAdvanceTicket("Baseball vs. LSU", new CalendarDate(),
				new CalendarDate(2017, 11, 1));
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
	}

}
