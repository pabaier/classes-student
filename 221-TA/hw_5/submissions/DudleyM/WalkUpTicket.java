public class WalkUpTicket extends Ticket{

    public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent) {
        super(nameOfEvent, dateOfEvent);

    }

    public String toString(){
        return "Walk-up Ticket: " + getNameOfEvent() + ", Date of Event: " + getDateOfEvent() + ", Price: " + getPrice();
    }

    public double getPrice(){
        return 50;
    }

}
