
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    finished getBirthdate, daysold and daysuntilbirthday method calls
  * 
  * were added by
  * 
  *   Dustin Cragg
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
        Scanner scnr = new Scanner(System.in);
        System.out.println("What month, day, and year were you born? ");
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate birthdate = new SampleDate(year, month, day);
        
        return birthdate; 
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
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
         SampleDate today = new SampleDate();
         int daysUntilBirthday = 0;
         SampleDate birthdate3 = birthdate;
         
         int day1 = birthdate.getDay();
         int month1 = birthdate.getMonth();
         int year3 = birthdate.getYear();
         int month2 = today.getMonth();
         SampleDate today2 = today;
         int year1 = today.getYear();
         int year2 = year1 + 1;
         SampleDate guessBday1 = new SampleDate(year1, month1, day1);
         SampleDate guessBday2 = new SampleDate(year2, month1, day1);
         int yearsOld = 0;
         
         
        if( month1 < month2  )
         {
            while(!guessBday2.equals(today2)){
                today2.nextDay();
                ++daysUntilBirthday;
            }
                yearsOld = year2 - year3;
            }
        else
        {
            while(!guessBday1.equals(today2)){
                today2.nextDay();
                ++daysUntilBirthday;
            }
        yearsOld = year1 - year3;
        }
        
        if(daysUntilBirthday !=0){
        System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
        
        }
        else{
            System.out.println("Happy birthday! you are now age " + yearsOld + " years old");
        }
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        SampleDate today = new SampleDate();
        SampleDate birthdate2 = birthdate;
        int daysOld = 0;
        do{
            birthdate2.nextDay();
            ++daysOld;
        }while(!birthdate2.equals(today));
        
        System.out.println("You are " + daysOld + " days old.");
    }
}