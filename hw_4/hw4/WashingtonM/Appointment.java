/*
 * Creates an appointment for an employee
 * Author: Mary Washington
 * Eclipse Oxygen 4.7
 */
public class Appointment {

	private CalendarDate date;
	private Employee employee;
	
	//Constructor
	public Appointment(CalendarDate date,  Employee employee) {
		this.date = date;
		this.employee = employee;
	}
	
	//gets the the name of employee for the appointment
	public Employee getEmployee() {
		return this.employee;
	}
	
	//gets the date for the appointment
	public CalendarDate getDate() {
		return this.date;
	}
	
	//overrides default toString
	public String toString() {
		return date.toString() + "  " + employee.toString();
	}
	
}
