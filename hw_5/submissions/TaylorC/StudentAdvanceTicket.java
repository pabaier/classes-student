public class StudentAdvanceTicket extends AdvanceTicket{
    public StudentAdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased){
        super(nameOfEvent, dateOfEvent, datePurchased);
    }
    public double getPrice(){
        if(this.getDateOfEvent().getDay() == this.datePurchased.getDay()){
            return 15.00;
        }
        else{
            return 20.00;
        }
    }
    public String toString(){
        return super.toString() + "***(ID Required)***";
    }
}
