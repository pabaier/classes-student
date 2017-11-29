/**
 * Appointment Class.
 * Initializes appointment objects
 * getter methods getEmployee() and and getDate() to return employee and date respectively
 * also includes a toString method to return string of name and appt date
 * 
 * @author:  Andrea Lingenfelter-
 */

import java.util.*;
public class Appointment {
	
	private CalendarDate date; 
	private Employee employee;

	public Appointment(CalendarDate date, Employee employee) {
		this.date = date;
		this.employee = employee;
	}
	
	public CalendarDate getDate() {
     return date;
    }
	
    public Employee getEmployee() {
      return employee;
    }
    
    public String toString() {
    	return CalendarDate.toString() + " " Employee.getName();
    }
}
