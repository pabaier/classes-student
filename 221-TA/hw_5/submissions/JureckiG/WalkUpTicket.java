//Gabe Jurecki
public class WalkUpTicket extends Ticket {
    public WalkUpTicket(){

    }
    public WalkUpTicket(String name, CalendarDate date){
        super(name,date);
    }
    public double getPrice(){
        return 50;
    }
    @Override
    public String toString() {
        return super.toString() + " Price: " + getPrice();
    }
}
