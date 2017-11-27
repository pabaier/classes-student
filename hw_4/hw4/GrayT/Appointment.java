/*
 * Contains a data and employeer obj to store an appointment
 * 
 * Tyler Gray

 */ 

import java.util.Scanner;

public class Appointment {
	
	
	CalendarDate date;
	Employee employee;
	
	
	public Appointment(CalendarDate date, Employee employee) throws Exception {
		if(!date.isAValidDate()) {
			throw new Exception("Invalid Date");
		}
		this.date = date;
		this.employee = employee;
	}
	
	//Getters
	public CalendarDate getDate() {
		return date;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	//Gens string of info about appointment
	public String toString() {
		return date.toString() + " " + employee.getName();
	}
	
	
	
	

}
