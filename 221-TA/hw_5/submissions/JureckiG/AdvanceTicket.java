//Gabe Jurecki
public class AdvanceTicket extends Ticket {
    public CalendarDate datePurchased;
    public AdvanceTicket(){

    }
    public AdvanceTicket(String name,CalendarDate date, CalendarDate datePurchased){
        super(name,date);
        this.datePurchased = datePurchased;

    }
    public double getPrice() {
        if (datePurchased.daysUntil(this.getDateOfEvent()) < 10) {
            return 30;

        } else {
            return 40;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Purchase Date: " + datePurchased + " Price: " + getPrice() ;
    }
}
