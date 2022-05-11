
/**
 * asks for when a ticket was purchased, uses that data to figure out days purchased before event
 * then uses that to figure out price. takes relevant data and adds to string to be output.
 * @Dustin Cragg
 * @11/10/2017
 */
public class AdvanceTicket extends Ticket
{
   int numberDays;
   CalendarDate datePurchased;
   int year;
   int month;
   int day;
   public AdvanceTicket()
   {
       System.out.println("When was the ticket purchased? ( month day year ): ");
       month = scan.nextInt();
       day = scan.nextInt();
       year = scan.nextInt();
       datePurchased = new CalendarDate(year, month, day);
       //numberDays = dateOfEvent.daysUntil(datePurchased); cant get to work
       CalendarDate temp = datePurchased;
       while( !dateOfEvent.equals(temp))
       {
           ++numberDays;
           temp.nextDay();
       }
       this.price = getPrice();
   }
   
   double getPrice()
   {
       double price;
       if (numberDays >= 10)
       {
           price = 30.00;
       }
       else
       {
           price = 40.00;
       }
       return price;
   }
   
   public String toString()
   {
       return "Advance Ticket: " + super.toString() + " Purchase Date: " + datePurchased + " Price: " + price;
   }
}
   
   

