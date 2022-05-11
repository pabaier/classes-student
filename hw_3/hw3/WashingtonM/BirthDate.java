
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    <List updates here> 
  * 
  * were added by
  * 
  *   Mary Washington
  *   
  *   Eclipse Oxygen 4.7
  */ 
import java.util.Scanner;
import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
        
      
       /* Test code
        * CalendarDate day = new CalendarDate(2017, 10,15);
        * System.out.println("date " + day.toString());
        *
        * System.out.println("day of week: " + day.getDayOfWeek());
        * day.nextDay();
        * System.out.println("next day: " + day.toString());
       
        */
    }
    
    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is your birthday?  Please put it in month, day, year format.");
        int month = userInput.nextInt(); // setting first int as a month
        int day = userInput.nextInt(); // setting second int as day
        int year = userInput.nextInt(); // setting third int as year
        
        SampleDate date = new SampleDate(year, month, day);
        userInput.close();
        
        return date; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }
     
    private static void daysUntilBirthday(SampleDate birthdate) {
        
    	SampleDate today = new SampleDate();
    	
        int daysUntilBirthday = 0;
        // checking to see if if user birthday is today
        if((today.getMonth() == birthdate.getMonth()) && (today.getDay() == birthdate.getDay()))  {
    		System.out.println("Happy birthday!");
    		return;
    	}
    	int nextBdayYear = today.getYear();
    	// checking to see if birthday has already happened or not
        if(today.getMonth() > birthdate.getMonth() || ((today.getMonth() == birthdate.getMonth()) && 
        		today.getDay() > birthdate.getDay())){
        	nextBdayYear++;
        }
        // checking to see how long until next birthday 
        SampleDate nextBday = new SampleDate(nextBdayYear, birthdate.getMonth(), birthdate.getDay());
        while(!today.equals(nextBday)) {
        	today.nextDay();
        	daysUntilBirthday++;
        	
        
        }
        System.out.println("There are " + daysUntilBirthday + " days until your next birthday.");
        
    }
    // checks for amount of days between birthday and current date
    private static void daysOld(SampleDate birthdate) {
    
        	SampleDate curDay = new SampleDate();
        	SampleDate compareDate = birthdate;
        	int daysOld = 0;
            while(!(curDay.equals(compareDate))) {
            	daysOld++;
            	compareDate.nextDay();
            }
            
            
            System.out.println("You are " + daysOld + " days old.");
        }

    }
