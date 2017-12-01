
/**
 * Represents tickets bought before the day of the event
 *
 * Jonathan Rabiu
 * 
 */
public class AdvanceTicket extends Ticket
{
    private CalendarDate dateBought = new CalendarDate();

    public AdvanceTicket(String nameofEvent, CalendarDate dateofEvent, CalendarDate datePurchased){  
        super(nameofEvent, dateofEvent);
        dateBought = datePurchased;

    }

    @Override
    public double getPrice(){
        //if ticket purchased 10 or more days before the event, return 30
        if(dateBought.daysUntil(date) >= 10){
            ticketPrice = 30;
        }else if(dateBought.daysUntil(date) < 10){//if ticket purchased less than 10 days before event, return 40
            ticketPrice = 40;
        }
        return ticketPrice;   
    }

    @Override
    public String toString(){
        return "Advance Ticket: " + super.toString() + ", Purchase Date: " + dateBought + ", " + "Price: " + "$" + String.format("%.2f",ticketPrice);
    }
}

