//Ryan Barrett
//Ticket class for HW5
public class Ticket {
	private String nameOfEvent;
	private CalendarDate dateOfEvent;

	public Ticket(String event, CalendarDate date) {
		nameOfEvent = event;
		dateOfEvent = date;
	}

	public String getNameOfEvent() {
		return nameOfEvent;
	}

	public CalendarDate getDateOfEvent() {
		return dateOfEvent;
	}

	public double getPrice() {
		return 0;
	}

	public String toString() {
		return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent;
	}
}
