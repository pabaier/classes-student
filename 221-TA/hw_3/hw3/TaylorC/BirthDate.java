
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  * >Updated getBirthDate to prompt for an input of the user's birthday in integers
  * >Calculatd the days until the next birthday and printed the results,
  *     if the birthday was today then it prints a happy birthday message.
  * >Calculated how old the user is in days.
  * 
  * were added by
  * 
  *   Corey Taylor
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
        int year = 0;
        int month = 0;
        int day = 0;
        
        Scanner scnr = new Scanner(System.in);
        System.out.print("What month, day, and year were you born?");
        month = scnr.nextInt();
        day = scnr.nextInt();
        year = scnr.nextInt();
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
        
        int daysUntilBirthday = 0;
        if(daysUntilBirthday == 0){
            System.out.println("Happy Birthday! You are now " + " years old");
       } 
        else{    // Hint: count the days from today's date until the user's next birthday
        System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
       }// If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
    }
    
        
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        
        // Hint: count the days from birthdate to today's date
        System.out.println("You are " + daysOld + " days old.");
    }
}