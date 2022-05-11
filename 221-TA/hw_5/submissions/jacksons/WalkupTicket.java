
public class WalkupTicket extends Ticket
{   
    private static double WALK_UP_PRICE = 50.0;
    public WalkupTicket(String eventName, CalendarDate eventDate)
    {
        super(eventName, eventDate);
    }
    public double getPrice(){
        return WALK_UP_PRICE;
    }
    @Override
    public String toString(){
        return "Walk-up Ticket: " + super.toString() + ", Price: $" + this.getPrice() + "0";
    }
}
