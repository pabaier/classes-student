
 /* 
  * CSCI 221, Fall 2017, HW 3
  * 
  * Program to prompt the user for the date of their birth and tell them 
  * something about that date.
  * 
  * Base code provided by instructor. The following updates 
  * 
  *   Updated: getBirthdate(), daysUntilBirthday(SampleDate birthdate),
  *   and daysOld(SampleDate birthdate)
  * 
  * were added by
  * 
  *   Lexus Hartung
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
        /* Your solution goes here and replaces the declaration and
         * initialization of daysUntilBirthday */
        SampleDate today = new SampleDate();
        int monthNow = today.getMonth();
        int dayNow = today.getDay();
        int yearNow = today.getYear();
        int monthBorn = birthdate.getMonth();
        int dayBorn = birthdate.getDay();
        int yearBorn = birthdate.getYear();
        int total = 0;
        for (int daysTil = 1; monthNow != monthBorn || dayNow != dayBorn; ++daysTil){
            today.nextDay();
            monthNow = today.getMonth();
            dayNow = today.getDay();
            total = daysTil;
        }
        if (total == 0){
            System.out.println("Happy birthday! You are now age " + (yearNow - yearBorn) + "");
        }
        else{
            System.out.println("It will be your birthday in " + total + " days.");
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
        int monthNow = today.getMonth();
        int dayNow = today.getDay();
        int yearNow = today.getYear();
        int monthBorn = birthdate.getMonth();
        int dayBorn = birthdate.getDay();
        int yearBorn = birthdate.getYear();
        while (dayNow != dayBorn || monthNow != monthBorn || yearNow != yearBorn){
            birthdate.nextDay();
            dayBorn = dayBorn = birthdate.getDay();
            monthBorn = birthdate.getMonth();
            yearBorn = birthdate.getYear();
            daysOld += 1;
        }
        System.out.println("You are " + daysOld + " days old.");
    }
}