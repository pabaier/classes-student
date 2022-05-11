import java.util.Scanner;
public class Appointment {
	private CalendarDate date;
	private Employee worker;
	
	
	public Appointment(CalendarDate date, Employee worker){
		this.date = date;
		this.worker = worker;
		
	}

	public Employee getEmployee(){
		return this.worker;
	}
	
	public CalendarDate getDate(){
		int year = 0;
		int month = 0;
		int day = 0;
		
		Scanner myScan = new Scanner(System.in);
		year = myScan.nextInt();
		month = myScan.nextInt();
		day = myScan.nextInt();
		myScan.close();
		
		this.date = new CalendarDate(year, month, day);
		
		return this.date;
	}

	public String toString(){
		return date + "  " + worker;
	}
	
}

