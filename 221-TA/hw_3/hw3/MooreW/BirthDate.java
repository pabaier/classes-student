
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 	
  *    Created a scanner so the user can input their birthday.
  *    Made three variables for the month, day, and year that the scanner
  *    will read and used SampleDate (name = birth) to put them in year/month/date order
  *    and returned birth.
  *    
  *    
  * 
  * were added by
  * 
  *   Elex Moore
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
    	int month = 0;
    	int day = 0;
    	int year = 0;
    	
        System.out.print("What month, day, and year were you born?: ");
        Scanner bDay = new Scanner(System.in);
        
        month = bDay.nextInt();
        day = bDay.nextInt();
        year = bDay.nextInt();
        bDay.close();
        SampleDate birth = new SampleDate(year, month, day);
        return birth; 
    }
    
    // print stats about user's birthdate
    private static void details(SampleDate birthdate) {
        System.out.print("You were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear()) {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
    }
    
    /*
     * Count # days until next birthday
     * Complete the following method
     */ 
    private static void daysUntilBirthday(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        
        int daysUntilBirthday = 0;
        
        if(daysUntilBirthday == 0){
        	System.out.println("Happy Birthday! You are now age ");
        }
        else{
        	System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
        }        // Hint: count the days from today's date until the user's next birthday

        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
        
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
       SampleDate today = new SampleDate();
       
    	int daysOld = 0;
    	
     
       System.out.println("You are " + daysOld + " days old.");
    }
}