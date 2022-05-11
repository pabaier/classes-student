//<Stefan Veloff>
public class Appointment {
	private Employee emp;
	private CalendarDate calDate;

	// constructor
	public Appointment(CalendarDate calendardate, Employee employee) {
		//specific to this constructor:
		this.calDate = calendardate;
		this.emp = employee;
	}

	// getter:
	public Employee getEmployee() {
		// return statement:
		return emp;

	}

	// getter method:
	public CalendarDate getDate() {
		//return statement:
		return calDate;
	}

	public String toString() {
		//returns a string:
		return calDate.toString() + " " + emp.getName();
	}

}
