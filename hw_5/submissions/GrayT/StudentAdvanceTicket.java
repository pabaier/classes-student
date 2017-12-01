/*
 * Tyler Gray
 * StudentAdvanceTicekt extends AdvanceTicket
 * Adds a student discount to the advance ticket 
 * 
 */
public class StudentAdvanceTicket extends AdvanceTicket{

	public StudentAdvanceTicket(String name, CalendarDate date, CalendarDate purchDate) {
		super(name, date, purchDate);
	}
	@Override
	public double getPrice() {
		return super.getPrice()/2;
	}
	@Override
	public String toString() {
		return "Student " + super.toString() + " (ID Required)" ;
	}

}
