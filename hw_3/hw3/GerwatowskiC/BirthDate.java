
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
  *   Claire Gerwatowski
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
        System.out.print("What month, day, and year were you born? ");
        Scanner scnr = new Scanner(System.in);
        int month = scnr.nextInt();
        int day = scnr.nextInt();
        int year = scnr.nextInt();
        SampleDate date = new SampleDate(year,month,day);
    
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
    
    /*
     * Count # days until next birthday
     * Complete the following method
     */ 
    private static void daysUntilBirthday(SampleDate birthdate) {
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
        SampleDate today = new SampleDate();
        
        int daysUntilBirthday = 0;
        
        if (today.getDay()==(birthdate.getDay()) && 
        today.getMonth()==(birthdate.getMonth())) {
            System.out.println("Happy birthday! You are now age " + 
            (today.getYear()-birthdate.getYear()) + ".");
        }
        else {
            while (!(today.getDay()==birthdate.getDay() && 
            today.getMonth()==birthdate.getMonth())) {
                today.nextDay();
                daysUntilBirthday++;
            }
            System.out.println("It will be your birthday in " + daysUntilBirthday + 
            " days.");
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
        int daysOld = 0;
        
        while (!(today.getDay()==birthdate.getDay() && 
        today.getMonth()==birthdate.getMonth() && today.getYear()==birthdate.getYear())) {
            birthdate.nextDay();
            daysOld++;
        }
        
        // Hint: count the days from birthdate to today's date
        System.out.println("You are " + daysOld + " days old.");
    }
}