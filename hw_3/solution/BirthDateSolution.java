
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * 
  * Base code provided by instructor. The following updates 
  * 
  *    <List updates here> 
  * 
  * were added by
  * 
  *   <Your name goes here
  */ 

import java.util.*;

public class BirthDateSolution {
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
        Scanner console = new Scanner(System.in);
        System.out.print("What month, day, and year were you born? ");
        int month = console.nextInt();
        int day = console.nextInt();
        int year = console.nextInt();
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
        SampleDate today = new SampleDate();
        int daysUntilBirthday = 0;
        while (today.getDay() != birthdate.getDay() || 
               today.getMonth() != birthdate.getMonth()) {
            today.nextDay();
            daysUntilBirthday++;
        }
        if (daysUntilBirthday == 0) {
            int age = (today.getYear() - birthdate.getYear());
            System.out.println("Happy birthday!  You are now age " + age + ".");
        } else {
            System.out.print("It will be your birthday in " + daysUntilBirthday + " day");
            if (daysUntilBirthday > 1) {
                System.out.print("s");  // no 's' for 1 day
            }
            System.out.println(".");
        }
    }
    
    // count # days old this person is
    private static void daysOld(SampleDate birthdate) {
        int daysOld = 0;
        SampleDate today = new SampleDate();
        while (!birthdate.equals(today)) {
            birthdate.nextDay();
            daysOld++;
        }
        
        System.out.println("You are " + daysOld + " days old.");
    }
}