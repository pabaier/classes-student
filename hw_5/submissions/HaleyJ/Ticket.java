import java.util.*;
public class Ticket {
    private String nameOfEvent;
    private CalendarDate dateOfEvent;

    public Ticket(String eventName, CalendarDate date) {
        nameOfEvent = eventName;
        dateOfEvent = date;
    }

    public String getNameOfEvent(){
        return nameOfEvent;
    }

    public CalendarDate getDateOfEvent(){
        return dateOfEvent;
    }
    public double getPrice(){
        return 0;
    }

    public String toString(){
        return "Event: " + nameOfEvent + ", Date: " + dateOfEvent;
    }
}
