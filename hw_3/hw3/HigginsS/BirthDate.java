
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
  *   Steven Higgins
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
        System.out.println("What month, day, and year were you born?");
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();
        int year = input.nextInt();
        SampleDate birthDate = new SampleDate(year, month, day); 
        return birthDate;
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
        // Hint: count the days from today's date until the user's next birthday
        // If today is the birthday, print Happy Birthday message
        // if not print the message stating the number of days until the user's
        // next birthday
        SampleDate today = new SampleDate();
        if(today.getMonth() == birthdate.getMonth() && today.getDay() == birthdate.getDay()){
            System.out.println("Happy Birthday");
        }
        else{
        SampleDate count = new SampleDate();
        while(count.getMonth() != birthdate.getMonth() || count.getDay() != birthdate.getDay()){
            count.nextDay();
            daysUntilBirthday = daysUntilBirthday + 1;
        }
        System.out.println("There are " + daysUntilBirthday + " days until your Birthday.");
        }
    
    }          
    /*
     * count # days old this person is
     */ 
    private static void daysOld(SampleDate birthdate) {
        
        int daysOld = 0;
        // Hint: count the days from birthdate to today's date
        SampleDate today = new SampleDate();
        while(today.getMonth() != birthdate.getMonth() || today.getDay() != birthdate.getDay() || birthdate.getYear() != today.getYear()){
            birthdate.nextDay();
            daysOld= daysOld + 1;
        }
        
        System.out.println("You are " + daysOld + " days old.");
    }
}