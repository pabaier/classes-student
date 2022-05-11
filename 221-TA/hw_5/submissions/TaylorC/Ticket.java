public class Ticket{
   private String nameOfEvent;
   private CalendarDate dateOfEvent;
   public Ticket(String nameOfEvent, CalendarDate dateOfEvent){
    this.nameOfEvent = nameOfEvent;
    this.dateOfEvent = dateOfEvent;
   }
   public String getNameOfEvent(){
       return nameOfEvent;
   }
   public double getPrice(double price){
       return 0;
   }
   public CalendarDate getDateOfEvent(){
       return dateOfEvent;
   }
   public String toString(){
    return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent;
   }
}