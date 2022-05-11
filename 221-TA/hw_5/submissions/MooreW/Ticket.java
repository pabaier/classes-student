
public class Ticket {
	private String nameofEvent;
	private CalendarDate dateofEvent;
	
	public Ticket(String nameofEvent, CalendarDate dateofEvent){
		this.nameofEvent = nameofEvent;
		this.dateofEvent = dateofEvent;
	}

	public String getNameofEvent(){
		return nameofEvent;
	}
	
	public double getPrice(){
		return 0;
	}
	
	public CalendarDate getDateOfEvent(){
		return dateofEvent;
	}
	
	public String toString(){
		return "Event: " + nameofEvent + ", Date of Event: " + dateofEvent;
	}
}
