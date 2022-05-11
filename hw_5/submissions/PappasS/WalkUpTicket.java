//Stephen Pappas
public class WalkUpTicket extends Ticket {

    //private String nameOfEvent;
   // private CalendarDate dateOfEvent;
    private final double price = 50;

    public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent) {
        super(nameOfEvent, dateOfEvent);
    }

    @Override
    public double getPrice(){
        return price;
    }


    @Override
    public String toString() {
        return "Walk-up Ticket: " + super.toString();
    }
}
