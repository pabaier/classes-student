
/**
 * extends ticket class. returns price of $50 and then returns string with important information.
 *
 * @Dustin Cragg
 * @11/10/2017
 */
public class WalkUpTicket extends Ticket
{
   public WalkUpTicket()
   {
       this.price = getPrice();
   }
   public double getPrice()
   {
       return 50.00;
   }
   
   public String toString()
   {
       return "Walk-up Ticket: " + super.toString() + " Price: " + price;
   }

}
