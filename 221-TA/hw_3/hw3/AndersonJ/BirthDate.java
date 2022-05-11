
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    Added the functionality to:
  *    details
  *    daysUntilNextBirthDay
  *    daysOld
  * 
  * were added by
  * 
  *   Jonathan E. Anderson
  */ 

import java.util.*;
import java.util.Scanner;

public class BirthDate {
    public static void main(String[] args) {
        
        // retrives a users input
        SampleDate birthdate = getBirthdate();
        details(birthdate);
        daysUntilBirthday(birthdate);
        daysOld(birthdate);
    }
    
    /*
     * prompt user for their birthdate and return it as a CalendarDate
     */ 
    private static SampleDate getBirthdate() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("What month, day, and year were you born? ");
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        
        SampleDate date = new SampleDate(year, month, day);
        
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
         SampleDate todayDate = new SampleDate();
        int daysUntilBirthday = 0;
        if(birthdate.getMonth() == today.getMonth() && birthdate.getDay() == today.getDay()){
            System.out.println("Happy Birthday!!!");
        } else {
            while(today.getMonth() != birthdate.getMonth()){
                daysUntilBirthday++;
                today.nextDay();
            }
            while(todayDate.getDay() != birthdate.getDay()){
                daysUntilBirthday++;
                todayDate.nextDay();
            }
            System.out.println("It will be your birthday in " + daysUntilBirthday + " days.");
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
        int daysOld = 0;
        
        SampleDate today = new SampleDate();
        SampleDate todayMonth = new SampleDate();
        SampleDate todayDate = new SampleDate();
        
        while(today.getYear() != birthdate.getYear()){
            daysOld++;
            birthdate.nextDay();
        }
        while(todayMonth.getMonth() != birthdate.getMonth()){
            daysOld++;
            todayMonth.nextDay();
            }
        while(todayDate.getDay() != birthdate.getDay()){
            daysOld++;
            todayDate.nextDay();
            }

        // Hint: count the days from birthdate to today's date
        System.out.println("You are " + daysOld + " days old.");
    }
}