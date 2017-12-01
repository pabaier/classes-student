//@author Carson Barber

public class AdvanceTicket extends Ticket
{
    private CalendarDate dateOfPurchase;
    final static double priceLessTenDays = 40;
    final static double priceMoreEqualTenDays = 30;
    
    public AdvanceTicket(String eventName, CalendarDate eventDate, CalendarDate purchaseDate){
        super(eventName, eventDate);
        dateOfPurchase = purchaseDate;
    }
    
    public double getPrice(){
        if(dateOfPurchase.daysUntil(getDateOfEvent())<10)return priceLessTenDays;
        return priceMoreEqualTenDays;
    }
    public String toString(){
        return "Advance Ticket: " + super.toString() + ", Purchase Date: "
            + dateOfPurchase.toString() + ", Price: $" + getPrice();
    }
}
