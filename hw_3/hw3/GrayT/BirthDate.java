


 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    <List updates here> 
  *    Added function to the getBirthdate method
  *    Added function to daysUntilBirthday method
  *    Added function to daysOld method
  * 
  * were added by
  * 
  *   Tyler Gray
  */ 

import java.util.*;

public class BirthDate {
    public static void main(String[] args) {
        
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
        /* Your solution goes here and change the return */
    	Scanner sc = new Scanner(System.in);
    	System.out.println("What month, day, and year were you born? ");
    	int month = sc.nextInt();
    	int day = sc.nextInt();
    	int year = sc.nextInt();
    	
    	//SampleDate date = new SampleDate(year, month, day);
        return new SampleDate(year, month, day); 
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
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
         
        int daysUntilBirthday = 0;
        SampleDate today = new SampleDate(); //More like comparison day
        boolean isBday = today.getDay() == birthdate.getDay() && today.getMonth() == birthdate.getMonth();
        if(isBday) {
        	System.out.println("Happy Birthday!!!");
        	System.out.printf("You are now age %d\n", today.getYear() - birthdate.getYear() );
        	return;
        }
        else {
        	//Calculate days until Birthday
        	//Continue to increment the day of "today" until it hits the birthday
        	while(!isBday) {
        		daysUntilBirthday++;
        		today.nextDay();
        		isBday = today.getDay() == birthdate.getDay() && today.getMonth() == birthdate.getMonth();
        	}
        	System.out.printf("It is %d day(s) until your birthday.\n" , daysUntilBirthday);
        }

    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        // Hint: count the days from birthdate to today's date
        SampleDate today = new SampleDate();
        //Uses three booleans to make sure day month and year match
        //Go with with vars to make code cleaner
        boolean sameDay = birthdate.getDay() == today.getDay();
        boolean sameMonth =  birthdate.getMonth() == today.getMonth();
        boolean sameYear = birthdate.getYear() == today.getYear();
        boolean isToday = sameDay && sameMonth && sameYear ;
        //Increment borthdate until its today and count num of days
        while(!isToday) {
    		daysOld++;
    		birthdate.nextDay();
    		sameDay = birthdate.getDay() == today.getDay();
            sameMonth =  birthdate.getMonth() == today.getMonth();
            sameYear = birthdate.getYear() == today.getYear();
            isToday = sameDay && sameMonth && sameYear ;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}