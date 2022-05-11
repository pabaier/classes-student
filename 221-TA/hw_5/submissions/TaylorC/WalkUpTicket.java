public class WalkUpTicket extends Ticket{
    public WalkUpTicket(String nameOfEvent, CalendarDate dateOfEvent){
        super(nameOfEvent,dateOfEvent);
    }
    public double getPrice(){
        return 50.00;
    }
    public String toString(){
        return  super.toString() + ", Price: $" + this.getPrice();
    }
}
