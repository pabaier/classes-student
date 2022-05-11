//Kyle Winstead

public class Appointment {
	public static final String ArrayUtils = null;
	private Employee emp;
	private CalendarDate calDate;
	
	public Appointment(CalendarDate calendardate, Employee employee) {
		this.calDate = calendardate;
		this.emp = employee;
	}
	
	//getter
	public Employee getEmployee() {
		return emp;
	}
	
	//getter method
	public CalendarDate getDate() {
		return calDate;
	}
	public String toString() {
		return calDate.toString()+ " " + emp.getName();
	}

}
