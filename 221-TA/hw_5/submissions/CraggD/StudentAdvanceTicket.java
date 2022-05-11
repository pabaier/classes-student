
/**
 * extends AdvanceTicket determines price for a student and returns it to be displayed by
 * advance ticket.
 *
 * @Dustin Cragg
 * @11/10/2017
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
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
       return price/2;
   }
}
