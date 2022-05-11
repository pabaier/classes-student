
/**
 * superclass for all ticket classes. asks for name and date of event and then passes them to the
 * other classes. sets price to 0 and returns it. takes all relevant data and turns it into a string.
 * @Dustin Cragg
 * @11/10/2017
 */

import java.util.Scanner;
public class Ticket
{
   Scanner scan = new Scanner(System.in);
   CalendarDate dateOfEvent;
   double price;
   String toStringVariable;
   String nameOfEvent;
   
   public Ticket()
   {
       this.nameOfEvent = getNameOfEvent();
       this.dateOfEvent = getDateOfEvent();
       this.price = getPrice();
       
       
   }
   
   String getNameOfEvent()
   {
       System.out.println("Please enter the name of the event: ");
       nameOfEvent = scan.nextLine();
       return nameOfEvent;
   }
   
   CalendarDate getDateOfEvent()
   {
       int month;
       int day;
       int year;
      
       System.out.println("Please enter the date of the event ( month day year ): ");
       month = scan.nextInt();
       day = scan.nextInt();
       year = scan.nextInt();
       
       CalendarDate dateOfEvent = new CalendarDate(year, month, day);
       return dateOfEvent;
   }
   
   double getPrice()
   {
       price = 0;
       return price;
   }
   
   public String toString()
   {
       return "Event: " + nameOfEvent + ", Date of Event: " + dateOfEvent;
   }
}
