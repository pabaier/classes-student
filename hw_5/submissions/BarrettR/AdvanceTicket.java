//Ryan Barrett
//StudentAdvanceTicket class for HW5
public class AdvanceTicket extends Ticket {
    private CalendarDate datePurchased;
    private double price;

    public AdvanceTicket(String event, CalendarDate dateOfEvent, CalendarDate purchaseDate) {
        super(event, dateOfEvent);
        datePurchased = purchaseDate;
        CalendarDate dayCounter = new CalendarDate(purchaseDate.getYear(), purchaseDate.getMonth(), purchaseDate.getDay());

        if(purchaseDate.daysUntil(dateOfEvent) < 10)
            price = 40.00;
        else
            price = 30.00;
    }

    public double getPrice() {
        return price;
    }

    public String toString(){
        return super.toString() + ", Purchase Date: " + datePurchased + ", Price: $" + price;
    }
}
