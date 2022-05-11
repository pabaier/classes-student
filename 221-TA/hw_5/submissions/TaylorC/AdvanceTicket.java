public class AdvanceTicket extends Ticket{
   public CalendarDate datePurchased;
    public AdvanceTicket(String nameOfEvent, CalendarDate dateOfEvent, CalendarDate datePurchased){
       super(nameOfEvent, dateOfEvent);
   }
   
   
   public double getPrice(){
       if(this.getDateOfEvent().getDay() - datePurchased.getDay() >= 10){
           return 30.00;
       }
       else{
           return 40.00;
       }
   }
   public String toString(){
       return "Advance Ticket: " + super.toString() + ", Purchase Date: " + datePurchased + ", Price: $" + this.getPrice(); 
   }
}
