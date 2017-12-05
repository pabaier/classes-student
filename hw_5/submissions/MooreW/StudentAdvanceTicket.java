
public class StudentAdvanceTicket extends AdvanceTicket{

	public StudentAdvanceTicket(String nameofEvent, CalendarDate dateofEvent, CalendarDate datePurchased) {
		super(nameofEvent, dateofEvent, datePurchased);
		
	}
	
	public double getPrice(){
		if(this.getDateOfEvent() - this.datePurcahsed.getDay() >= 10){
			return 15;
		}
		else{
			return 20;
		}
	}
	
	public String toString(){
		return super.toString() + "(ID Required)";
	}

}
