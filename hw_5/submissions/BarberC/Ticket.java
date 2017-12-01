//@author Carson Barber

public class Ticket
{
   private String nameOfEvent;
   private CalendarDate dateOfEvent;
   
   public Ticket(String eventName, CalendarDate dateOf){
       nameOfEvent = eventName;
       dateOfEvent = dateOf;
    }
   
   public String getNameOfEvent(){
       return nameOfEvent;
    }
   public double getPrice(){
       return 0;
    }
   public CalendarDate getDateOfEvent(){
       return dateOfEvent;
    }
   public String toString(){
       return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent.toString();
    }
}
